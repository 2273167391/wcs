/**
 * 加载页面
 */
function loadPage(){
	$(".wcs_price_type").combobox({
		valueField:"wordBookCode",
		textField:"wordBookContent",
		url:"../base/common/wordbook/W001"
	});
	
	$("#update_price").linkbutton({"disabled":true});
	$("#delete_price").linkbutton({"disabled":true});
	$("#wcs_price_list").datagrid({
		loadFilter: pagerFilter,
		url:"../sys/price/all",
		onSelect:function(rowIndex,rowData){
			$("#update_price").linkbutton('enable');
			$("#delete_price").linkbutton('enable');
		}
	});
}

//查询价格
function queryPrice(){
	$("#wcs_price_search_form").form("submit",{
		url:"../sys/price/all",
		success:function(data){
			$("#wcs_price_list").datagrid("loadData",jQuery.parseJSON(data));
		}
	});
}

//添加水价
function addPrice(){
	//清空表单
	$("#wcs_save_price_form").form("clear");
	$(".wcs_price_type").combobox({onLoadSuccess:function(node){$(this).combobox('setValue', node[0].wordBookCode);}});
	savePrice("添加水价");
}

//更新水价
function updatePrice(){
	//获取要更新的水价
	var price=$("#wcs_price_list").datagrid("getSelected");
	if(null==price){
		$.messager.alert("提示框","请选择要更新的水价","error");
	}else{
		savePrice("修改水价");
		$("#wcs_save_price_form").form("load",price);
	}
}

//水价操作
function savePrice(title){
	$("#wcs_save_price_win").dialog({
		title:title,
		width:400,
		height:220,
		modal:true,
		buttons:[{
			iconCls:"icon-save",
			text:"保存",
			plain:true,
			handler:function(){
				var index=layer.load();
				$("#wcs_save_price_form").form("submit",{
					url:"../sys/price/save",
					onSubmit:function(param){
						var isValid=$(this).form("validate");
						if(!isValid){
							layer.close(index);
						}
						return isValid;
					},success:function(data){
						data=jQuery.parseJSON(data);
						if(data.result==1){
							//刷新表格
							$("#wcs_price_list").datagrid("reload");
							$("#wcs_save_price_win").dialog("close");//关闭窗口
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

//删除水价
function deletePrice(){
	//获取要更新的水价
	var price=$("#wcs_price_list").datagrid("getSelected");
	if(null==price){
		$.messager.alert("提示框","请选择要更新的水价","error");
	}else{
		$.ajax({
			url:"../sys/price/delete/"+price.wpId,
			type:'GET',
			dataType:'json',
			success:function(data){
				if(data.result==1){
					//刷新表格
					$("#wcs_price_list").datagrid("reload");
				}else{
					$.messager.alert("提示框",data.message,"error");
				}
			}
		});
	}
}