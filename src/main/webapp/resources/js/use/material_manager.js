//加载页面
function loadPage(){
	//用户
	$(".wcs_user").combogrid({
		fitColumns:true,
		idField:"userId",
		textField:"userName",
		url:"../use/user/all",
		columns:[[
			{field:'userId',hidden:true},
			{field:'userCode',title:'用户编码',width:60},
			{field:'userName',title:'用户名',width:60}
		]]
	});
	
	$(".wcs_material").combobox({
		valueField:"wordBookCode",
		textField:"wordBookContent",
		url:"../base/common/wordbook/W005"
	});
	
	$("#update_material").linkbutton({"disabled":true});
	$("#dele_material").linkbutton({"disabled":true});
	
	$(".wcs_material_list").datagrid({
		loadFilter: pagerFilter,
		url:"../use/material/all",
		onSelect:function(rowIndex, rowData){
			$("#update_material").linkbutton('enable');
			$("#dele_material").linkbutton('enable');
		}
	});	
}

//添加材料
function addMaterial(){
	$(".wcs_save_material_form").form("clear");//清空表单
	$(".wcs_material").combobox({readonly:false});
		$(".wcs_user").combobox({readonly:false});
	handlerMaterial("添加材料");
}

//编辑材料
function updateMaterial(){
	var material=$(".wcs_material_list").datagrid("getSelected");//获取选中的材料
	if(null==material){
		$.messager.alert("提示框","请选择要编辑的材料信息","error");
	}else{
		$(".wcs_save_material_form").form("clear");//清空表单
		handlerMaterial("编辑材料");
		$(".wcs_material").combobox({readonly:true});
		$(".wcs_user").combobox({readonly:true});
		$(".wcs_save_material_form").form("load",material);//填充表单
	}
}

//删除材料
function deleteMaterial(){
	var material=$(".wcs_material_list").datagrid("getSelected");//获取选中的材料
	if(null==material){
		$.messager.alert("提示框","请选择要编辑的材料信息","error");
	}else{
		$.ajax({
			url:"../use/material/delete/"+material.materialId,
			type:'GET',
			dataType:'JSON',
			success:function(data){
				if(data.result==1){
					$(".wcs_material_list").datagrid("reload");//刷新表格
				}else{
					$.messager.alert("提示框",data.message,"error");
				}
			}
		});
	}
}

function handlerMaterial(title){
	$("#wcs_save_material_win").dialog({
		title:title,
		height:300,
		width:400,
		modal:true,
		buttons:[{
			iconCls:"icon-save",
			text:"保存",
			plain:true,
			handler:function(){
				//加载框
				var index=layer.load();
				$(".wcs_save_material_form").form("submit",{
					url:"../use/material/save",
					onSubmit:function(param){
						var isValid = $(this).form('validate');
						if (!isValid){
							layer.close(index);
						}
						return isValid;	// 返回false终止表单提交
					},
					success:function(data){
						data=jQuery.parseJSON(data);
						if(data.result==1){
							$(".wcs_material_list").datagrid("reload");//刷新表格
							$("#wcs_save_material_win").dialog("close");//关闭窗口
						}else{
							$.messager.alert("提示框",data.message,"error");
						}
						layer.close(index);
					}
				});
			}
		}]
	});
}

function queryMaterial(){
	//显示加载框
	var index=layer.load();
	$("#wcs_material_search_form").form("submit",{
		url:"../use/material/all",
		success:function(data){
			layer.close(index);
			$(".wcs_material_list").datagrid('loadData',jQuery.parseJSON(data));
		}
	});
}