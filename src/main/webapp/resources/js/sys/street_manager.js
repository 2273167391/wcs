/**
 * 加载页面
 */
function loadPage(){
	$("#update_street").linkbutton({"disabled":true});
	$("#delete_street").linkbutton({"disabled":true});
	$("#wcs_street_list").datagrid({
		loadFilter: pagerFilter,
		url:"../sys/street/all",
		onSelect:function(rowIndex,rowData){
			$("#update_street").linkbutton('enable');
			$("#delete_street").linkbutton('enable');
		}
	});
}

//查询
function queryStreet(){
	var index=layer.load();//加载框
	$("#wcs_street_search_form").form("submit",{
		url:"../sys/street/all",
		success:function(data){
			layer.close(index);
			$("#wcs_street_list").datagrid('loadData',jQuery.parseJSON(data));
		}
	});
}

//添加
function addStreet(){
	$("#wcs_save_street_form").form("clear");//清空表单
	$("#wcs_save_street_win").dialog({
		title:"添加街道信息",
		width:400,
		height:150,
		modal:true,
		buttons:saveStreetBtn
	});
}

//修改
function updateStreet(){
	var street=$("#wcs_street_list").datagrid("getSelected");
	if(null==street){
		$.messager.alert("提示框","请选择要编辑的街道信息！","error");
	}else{
		$("#wcs_save_street_win").dialog({
			title:"修改街道信息",
			width:400,
			height:150,
			modal:true,
			buttons:saveStreetBtn
		});
		$("#wcs_save_street_form").form("load",street);
	}
}

//删除
function deleteStreet(){
	var street=$("#wcs_street_list").datagrid("getSelected");
	if(null==street){
		$.messager.alert("提示框","请选择要删除的街道信息！","error");
	}else{
		$.ajax({
			url:"../sys/street/delete/"+street.streetId,
			type:'GET',
			dataType:'json',
			success:function(data){
				if(data.result==1){
					$("#wcs_street_list").datagrid("reload");//刷新表格
				}else{
					$.messager.alert("提示框",data.message,"error");
				}
			}
		});
	}
}

//保存街道按钮
var saveStreetBtn=[{
	iconCls:"icon-save",
	text:"保存",
	plain:true,
	handler:function(){
		var index=layer.load();
		$("#wcs_save_street_form").form("submit",{
			url:"../sys/street/save",
			onSubmit:function(param){
				var isValid=$(this).form("validate");
				if(!isValid){
					layer.close(index);
				}
				return isValid;
			},
			success:function(data){
				data=jQuery.parseJSON(data);
				if(data.result==1){
					$("#wcs_street_list").datagrid("reload");//刷新表格
					$("#wcs_save_street_win").dialog("close");//关闭弹窗
				}else{
					$.messager.alert("提示框",data.message,"error");
				}
				layer.close(index);
			}
		});
	}
}];