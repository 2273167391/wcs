/**
 * 加载页面
 */
function loadPage(){
	$(".wcs_sex").combobox({
		valueField:"sex",
		textField:"sexName",
		data:[{"sex":1,"sexName":"男"},{"sex":0,"sexName":"女"}]
	});
	
	$("#update_emp").linkbutton({"disabled":true});
	$("#delete_emp").linkbutton({"disabled":true});
	$(".wcs_emp_list").datagrid({
		url:"../sys/emp/list",
		loadFilter: pagerFilter,
		onSelect:function(rowIndex,rowData){
			$("#update_emp").linkbutton('enable');
			$("#delete_emp").linkbutton('enable');
		}
	});
}

/**
 * 查询
 */
function queryEmp(){
	$("#wcs_emp_search_form").form("submit",{
		url:"../sys/emp/list",
		success:function(data){
			$(".wcs_emp_list").datagrid("loadData",jQuery.parseJSON(data));
		}
	});
}

/**
 * 添加职员
 */
function addEmp(){
	//清空表单
	$(".wcs_save_emp_form").form("clear");
	$(".account").removeAttr("readonly").css("background","#fff");
	$(".wcs_sex").combobox("setValue",1);
	saveEmpHandler("添加职员");
}

/**
 * 编辑职员
 */
function updateEmp(){
	//获取选中要修改的职员
	var emp=$(".wcs_emp_list").datagrid("getSelected");
	if(emp==null){
		$.messager.alert("提示框","请选择要修改的职员！","error");
	}else{
		//清空表单
		$(".wcs_save_emp_form").form("clear");
		saveEmpHandler("修改职员");
		//加载表单数据
		$(".wcs_save_emp_form").form("load",emp);
		$(".account").attr("readonly","readonly").css("background","#F7F7F7");
		
	}
}

/**
 * 删除职员
 */
function deleteEmp(){
	//获取选中要修改的职员
	var emp=$(".wcs_emp_list").datagrid("getSelected");
	if(emp==null){
		$.messager.alert("提示框","请选择要删除的职员！","error");
	}else{
		$.ajax({
			url:"../sys/emp/delete/"+emp.empId,
			type:'GET',
			dataType:'json',
			success:function(data){
				if(data.result==1){
					$(".wcs_emp_list").datagrid("reload");//刷新表格
				}else{
					$.messager.alert("提示框",data.message,"error");
				}
			}
		});
	}
}

/**
 * 保存职员操作
 * @param title
 */
function saveEmpHandler(title){
	$("#wcs_save_emp_win").dialog({
		title:title,
		width:500,
		height:530,
		modal:true,
		buttons:[{
			iconCls:'icon-save',
			text:"保存",
			plain:true,
			handler:function(){
				var index=layer.load();
				$(".wcs_save_emp_form").form("submit",{
					url:"../sys/emp/save",
					onSubmit:function(param){
						var isValid=$(this).form("validate");
						if(!isValid){
							layer.close(index);
						}
						return isValid;
					},success:function(data){
						data=jQuery.parseJSON(data);
						$.messager.alert("提示框",data.message,"info");
						if(data.result==1){
							$(".wcs_emp_list").datagrid("reload");//刷新表格
							$("#wcs_save_emp_win").dialog("close");//关闭窗口
						}
						layer.close(index);
					}
				});
			}
		}]
	});
}