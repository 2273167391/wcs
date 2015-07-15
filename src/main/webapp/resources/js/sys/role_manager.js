//角色工具栏
var roleToolBar=[{
	iconCls:'icon-add',
	text:"添加",
	handler:function(){
		//添加角色窗口
		$("#wcs_handler_role").dialog({
			title:"添加角色",
			width:500,
			height:230,
			modal:true,
			buttons:saveRoleToobar
		});
		//清除表单数据
		$("#wcs_role_form").form('clear');
		
	}
},{
	iconCls:"icon-edit",
	text:"编辑",
	handler:function(){
		var role=$("#wcs_role_list").datagrid('getSelected');
		if(role==null){
			$.messager.alert("提示框","请选择要删除的角色！","error");
		}else{
			//添加角色窗口
			$("#wcs_handler_role").dialog({
				title:"编辑角色",
				width:500,
				height:230,
				modal:true,
				buttons:saveRoleToobar
			});
			
			//加载表单
			$("#wcs_role_form").form("load",role);
		}
	}
},{
	iconCls:"icon-cancel",
	text:"删除",
	handler:function(){
		var role=$("#wcs_role_list").datagrid('getSelected');
		if(role==null){
			$.messager.alert("提示框","请选择要删除的角色！","error");
		}else{
			$.ajax({
				url:'../sys/role/delete/'+role.roleId,
				type:'GET',
				dataType:'json',
				success:function(data){
					if(data.result==1){
						$("#wcs_role_list").datagrid("reload");//刷新表格
					}else{
						$.messager.alert("提示框",data.message,"error");
					}
				}
			});
		}
	}
}];

//保存角色工具栏
var saveRoleToobar=[{
	iconCls:"icon-save",
	plain:true,
	text:"保存",
	handler:function(){
		var index=layer.load();//加载框
		$("#wcs_role_form").form("submit",{
			url:"../sys/role/save",
			onSubmit:function(param){
				var isValid = $(this).form('validate');
				if (!isValid){
					layer.close(index);	// 如果表单是无效的则关闭加载框
				}
				return isValid;	// 返回false终止表单提交
			},
			success:function(data){
				//转换为JSON对象
				data=jQuery.parseJSON(data);
				if(data.result==1){
					$("#wcs_role_list").datagrid("reload");//刷新表格
					$("#wcs_handler_role").dialog('close');//关闭窗口
				}else{
					$.messager.alert("提示框",data.message,"error");
				}
				layer.close(index);
			}
		});
	}
}];

//职员工具栏
var empToolBar=[{
	iconCls:'icon-add',
	text:"关联用户",
	handler:function(){
		var role=$("#wcs_role_list").datagrid('getSelected');//获取选中的角色
		if(role==null){
			$.messager.alert("提示框","请选择对应角色！","info");
		}else{
			$("#wcs_emp_role").dialog({
				title:"业务角色关联用户查询",
				width:500,
				height:400,
				modal:true
			});
			
			$("#wcs_emp_role_list").datagrid({
				loadFilter: pagerFilter,
				url:'../sys/role/not/emp/'+role.roleId
			});
		}
	}
},{
	iconCls:'icon-cancel',
	text:"解除关联",
	handler:function(){
		var emp=$("#wcs_emp_list").datagrid('getSelected');//获取选中的职员
		var role=$("#wcs_role_list").datagrid('getSelected');//获取选中的角色
		if(emp==null){
			$.messager.alert("提示框","请选择要解除角色的职员！","info");
		}else{
			$.ajax({
				url:'../sys/role/remove/relation/'+emp.empId+'/'+role.roleId,
				type:'GET',
				dataType:'json',
				success:function(data){
					if(data.result==1){
						$("#wcs_emp_list").datagrid('reload');//刷新表格
					}
				},error:function(e){
					$.messager.alert("错误框","异步请求失败！","error");
				}
			});
		}
	}
}];

//分配用户角色工具栏
var empRoleToolBar=[{
	iconCls:'icon-confirm',
	text:"确定",
	handler:function(){
		var emp=$("#wcs_emp_role_list").datagrid('getSelected');//获取选中的用户
		var role=$("#wcs_role_list").datagrid('getSelected');//获取选中的角色
		if(null==emp){
			$.messager.alert("提示框","请选择要关联角色的职员！","info");
		}else{
			$.ajax({
				url:'../sys/role/add/relation/'+emp.empId+'/'+role.roleId,
				type:'GET',
				dataType:'json',
				success:function(data){
					if(data.result==1){
						$("#wcs_emp_list").datagrid('reload');//刷新表格
					}
					$("#wcs_emp_role").dialog('close');//关闭窗口
				},error:function(e){
					$.messager.alert("错误框","异步请求失败！","error");
				}
			});
		}
	}
}];

$(document).ready(function () {
    var empGrid=$("#wcs_emp_list");//用户表格
    $("#wcs_role_list").datagrid({
        loadFilter: pagerFilter,
        url:'../sys/role/role_list',
        onLoadSuccess:function(data){
        	empGrid.datagrid({
        		loadFilter: pagerFilter,
        		url:'../sys/role/employee/roleid/'+data.rows[0].roleId
        	});
        },
        onSelect:function(rowIndex,rowData){
        	empGrid.datagrid({
        		loadFilter: pagerFilter,
        		url:'../sys/role/employee/roleid/'+rowData.roleId
        	});
        }
    });
    
    //获取角色类型
	$("#wcs_role_type").combobox({
		url:'../sys/role_type/all',
		valueField:"roleTypeId",
		textField:"roleTypeName"
	});
});