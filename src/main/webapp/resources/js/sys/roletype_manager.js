//角色类型工具栏
var roletypeToolBar=[{
	iconCls:"icon-add",
	text:"添加",
	handler:function(){
		$("#wcs_handler_roletype").dialog({
			title:"添加角色类型",
			width:350,
			height:120,
			modal:true,
			buttons:saveRoleTypeBtn
		});
		//清空表单
		$("#wcs_roletype_form").form('clear');
	}
},{
	iconCls:"icon-edit",
	text:"编辑",
	handler:function(){
		//获取选中的行
		var roleType=$("#wcs_roletype_list").datagrid("getSelected");
		if(null==roleType){
			$.messager.alert("提示框","请选择要编辑的角色类型","error");
		}else{
			$("#wcs_handler_roletype").dialog({
 				title:"添加角色类型",
 				width:350,
				height:120,
				modal:true,
				buttons:saveRoleTypeBtn
 			});
 			$("#wcs_roletype_form").form('load',roleType);
		}
	}
},{
	iconCls:"icon-cancel",
	text:"删除",
	handler:function(){
		//获取选中的行
		var roleType=$("#wcs_roletype_list").datagrid("getSelected");
		if(null==roleType){
			$.messager.alert("提示框","请选择要编辑的角色类型","error");
		}else{
 			$.ajax({
 				url:"../sys/role_type/delete/"+roleType.roleTypeId,
 				type:'GET',
 				dataType:'json',
 				success:function(data){
 					if(data.result==1){
						$("#wcs_roletype_list").datagrid('reload');//刷新表格
					}else{
						$.messager.alert("提示框",data.message,"error");
					}
 				},
 				error:function(e){
 					$.messager.alert("提示框","异步请求失败！","error");
 				}
 			});
		}
	}
}];

//保存角色按钮
var saveRoleTypeBtn=[{
	iconCls:"icon-save",
	plain:true,
	text:"保存",
	handler:function(){
		var index=layer.load();//显示加载框
		$("#wcs_roletype_form").form("submit",{
			url:"../sys/role_type/save",
			onSubmit:function(param){
				var isValid = $(this).form('validate');
				if (!isValid){
					layer.close(index);	// 如果表单是无效的则关闭加载框
				}
				return isValid;	// 返回false终止表单提交
			},
			success:function(data){
				data=jQuery.parseJSON(data);//转换为JSON对象
				//关闭加载框
				layer.close(index);
				if(data.result==1){
					$("#wcs_roletype_list").datagrid('reload');//刷新表格
					$("#wcs_handler_roletype").dialog('close');//关闭窗口
				}else{
					$.messager.alert("提示框",data.message,"error");
				}
			}
		});
	}
}];

var grid= $("#wcs_roletype_list");
var empGrid=$("#wcs_roletype_role_list");
grid.datagrid({
    loadFilter: pagerFilter,
    url:'../sys/role_type/all',
    onLoadSuccess:function(data){
    	$(this).datagrid("selectRow",0);
    	empGrid.datagrid({
    		loadFilter: pagerFilter,
    		url:'../sys/role/type/'+data.rows[0].roleTypeId
    	});
    },
    onSelect:function(rowIndex,rowData){
    	empGrid.datagrid({
    		loadFilter: pagerFilter,
    		url:'../sys/role/type/'+rowData.roleTypeId
    	});
    }
});