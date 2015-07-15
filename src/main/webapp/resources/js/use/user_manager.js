//页面加载
function loadPage(){
	$(".wcs_user_status").combobox({
		valueField:"wordBookCode",
		textField:"wordBookContent",
		url:"../base/common/wordbook/W002"
	});

	$(".wcs_user_type").combobox({
		valueField:"wordBookCode",
		textField:"wordBookContent",
		url:"../base/common/wordbook/W003"
	});
	
	$("#update_user").linkbutton({"disabled":true});
	$("#dele_user").linkbutton({"disabled":true});
	
	$(".wcs_user_list").datagrid({
		loadFilter: pagerFilter,
		url:"../use/user/all",
		onLoadSuccess:function(data){
			$(".wcs_user_material_list").datagrid({
				loadFilter:pagerFilter,
				url:"../use/material/"+data.rows[0].userId
			});
			$(".wcs_user_meter_list").datagrid({
				loadFilter:pagerFilter,
				url:"../use/water_mater/"+data.rows[0].userId
			});
		},
		onSelect:function(rowIndex, rowData){
			$("#update_user").linkbutton('enable');
			if("W002003"==rowData.status){
				$("#dele_user").linkbutton('disable');
			}else{
				$("#dele_user").linkbutton('enable');
			}
			
			$(".wcs_user_material_list").datagrid({
				loadFilter:pagerFilter,
				url:"../use/material/"+rowData.userId
			});
			$(".wcs_user_meter_list").datagrid({
				loadFilter:pagerFilter,
				url:"../use/water_mater/"+rowData.userId
			});
		}
	});
	
	//填充街道下拉框
	$(".wcs_use_street").combobox({
		valueField:"streetId",
		textField:"streetName",
		url:"../sys/street/all"
	});
}


//添加
function addUse(){
	//清空表单
	$(".wcs_save_use_form").form("clear");
	
	handlerUse("添加用户");
}

//编辑用户
function updateUse(){
	//获取要编辑的用户
	var user=$(".wcs_user_list").datagrid("getSelected");
	if(null==user){
		$.messager.alert("提示框","请选择要编辑的用户！","error");
	}else{
		handlerUse("编辑用户");
		//填充表单
		$(".wcs_save_use_form").form('load','../use/user/get/'+user.userId);
	}
}

//操作用户
function handlerUse(title){
	$("#wcs_save_use_win").dialog({
		title:title,
		width:500,
		height:450,
		modal:true,
		buttons:[{
			iconCls:"icon-save",
			text:"保存",
			plain:true,
			handler:function(){
				var index=layer.load();
				$(".wcs_save_use_form").form("submit",{
					url:"../use/user/save",
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
							//关闭窗口
							$("#wcs_save_use_win").dialog("close");
							//刷新表格
							$(".wcs_user_list").datagrid("reload");
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

//删除用户
function deleteUse(){
	//获取要编辑的用户
	var user=$(".wcs_user_list").datagrid("getSelected");
	if(null==user){
		$.messager.alert("提示框","请选择要注销的用户！","error");
	}else{
		$.ajax({
			url:"../use/user/delete/"+user.userId,
			type:'GET',
			dataType:'json',
			success:function(data){
				if(data.result==1){
					//刷新表格
					$(".wcs_user_list").datagrid("reload");
				}else{
					$.messager.alert("提示框",data.message,"error");
				}
			}
		});
	}
}

//查询
function queryUse(){
	//显示加载框
	var index=layer.load();
	$("#wcs_use_search_form").form('submit',{
		url:"../use/user/all",
		success:function(data){
			layer.close(index);
			$(".wcs_user_list").datagrid('loadData',jQuery.parseJSON(data));
		}
	});
}