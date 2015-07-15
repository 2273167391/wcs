/**
 * 页面加载
 */
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
	
	$(".wcs_status").combobox({
		valueField:"wordBookCode",
		textField:"wordBookContent",
		url:"../base/common/wordbook/W004"
	});
	
	//开卡人		
	$(".wcs_emp").combogrid({
		fitColumns:true,
		idField:"empId",
		textField:"trueName",
		url:"../sys/emp/RT002",
		columns:[[
			{field:'empId',hidden:true},
			{field:'account',title:'登录名',width:60},
			{field:'trueName',title:'姓名',width:60}
		]]
	});
	
	$("#recharge_magcard").linkbutton({"disabled":true});
	$("#dele_magcard").linkbutton({"disabled":true});
	$("#cancel_magcard").linkbutton({"disabled":true});
	$(".wcs_magcard_list").datagrid({
		loadFilter: pagerFilter,
		url:"../use/magcard/all",
		onLoadSuccess:function(data){
			$(".wcs_mag_recharge_list").datagrid({
				loadFilter:pagerFilter,
				url:"../cost/recharge_notes/"+data.rows[0].magcardId+"/0"
			});
			$(".wcs_mag_unrecharge_list").datagrid({
				loadFilter:pagerFilter,
				url:"../cost/recharge_notes/"+data.rows[0].magcardId+"/1"
			});
		},
		onSelect:function(rowIndex, rowData){
			if("W004003"!=rowData.statusCode){
				$("#recharge_magcard").linkbutton('enable');
				$("#cancel_magcard").linkbutton('enable');
				$("#dele_magcard").linkbutton('disable');
			}else{
				$("#recharge_magcard").linkbutton('disable');
				$("#cancel_magcard").linkbutton('disable');
				$("#dele_magcard").linkbutton('enable');
			}
			$(".wcs_mag_recharge_list").datagrid({
				loadFilter:pagerFilter,
				url:"../cost/recharge_notes/"+rowData.magcardId+"/0"
			});
			$(".wcs_mag_unrecharge_list").datagrid({
				loadFilter:pagerFilter,
				url:"../cost/recharge_notes/"+rowData.magcardId+"/1"
			});
		}
	});
}

//添加磁卡
function addMagcard(){
	$("#wcs_save_magcard_win").dialog({
		title:"添加磁卡",
		width:350,
		height:150,
		buttons:[{
			iconCls:"icon-save",
			text:"保存",
			plain:true,
			handler:function(){
				var index=layer.load();//显示加载框
				$(".wcs_save_magcard_form").form("submit",{
					url:"../use/magcard/save",
					onSubmit:function(param){
						var isValid=$(this).form("validate");
						if(!isValid){
							layer.close(index);
						}
						return isValid;
					},success:function(data){
						data=jQuery.parseJSON(data);
						if(data.result==1){
							$("#wcs_save_magcard_win").dialog("close");//关闭窗口
							$(".wcs_magcard_list").datagrid("reload");//刷新表格
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
//查询磁卡
function queryMagcard(){
	//显示加载框
	var index=layer.load();
	$("#wcs_magcard_search_form").form('submit',{
		url:"../use/magcard/all",
		success:function(data){
			layer.close(index);
			$(".wcs_magcard_list").datagrid('loadData',jQuery.parseJSON(data));
			$(".wcs_mag_recharge_list").datagrid("reload");
			$(".wcs_mag_unrecharge_list").datagrid("reload");
		}
	});
}

//充值磁卡
function rechargeMagcard(){
	//获取要充值的卡
	var magcard=$(".wcs_magcard_list").datagrid("getSelected");
	if(null==magcard){
		$.messager.alert("提示框","请选择要充值的磁卡！","info");
		return;
	}
	//加载表单
	$(".wcs_recharge_magcard_form").form("reset");
	$(".wcs_recharge_magcard_form").form("load",magcard);
	$("#wcs_recharge_magcard_win").dialog({
		title:"磁卡【"+magcard.cardNumber+"】充值",
		width:430,
		height:230,
		buttons:[{
			iconCls:"icon-save",
			text:"充值",
			plain:true,
			handler:function(){
				//获取充值金额
				var rechargeMoney=$("#recharge_money").numberbox('getValue');
				if(rechargeMoney<=0){
					$.messager.alert("提示框","充值金额不能小于等于0！","info");
					return;
				}else if(rechargeMoney%100!=0){
					$.messager.alert("提示框","充值金额必须为100的倍数！","info");
					return;
				}
				var index=layer.load();//加载框
				$(".wcs_recharge_magcard_form").form("submit",{
					url:"../use/magcard/recharge",
					success:function(data){
						data=jQuery.parseJSON(data);
						if(data.result==1){
							$("#wcs_recharge_magcard_win").dialog("close");//关闭窗口
							$(".wcs_magcard_list").datagrid("reload");//刷新表格
						}
						$.messager.alert("提示框",data.message,"info");
						layer.close(index);
					}
				});
			}
		}]
	});
}

//注销磁卡
function cancelMagcard(){
	//获取要充值的卡
	var magcard=$(".wcs_magcard_list").datagrid("getSelected");
	if(null==magcard){
		$.messager.alert("提示框","请选择要注销的磁卡！","info");
		return;
	}
	$.ajax({
		url:"../use/magcard/cancel/"+magcard.magcardId,
		type:'GET',
		dataType:'JSON',
		success:function(data){
			if(data.result==1){
				$(".wcs_magcard_list").datagrid("reload");//刷新表格
			}else{
				$.messager.alert("提示框",data.message,'info');
			}
		}
	});
}

//删除磁卡
function deleteMagcard(){
	//获取要充值的卡
	var magcard=$(".wcs_magcard_list").datagrid("getSelected");
	if(null==magcard){
		$.messager.alert("提示框","请选择要删除的磁卡！","info");
		return;
	}
	$.ajax({
		url:"../use/magcard/delete/"+magcard.magcardId,
		type:'GET',
		dataType:'JSON',
		success:function(data){
			if(data.result==1){
				$(".wcs_magcard_list").datagrid("reload");//刷新表格
			}else{
				$.messager.alert("提示框",data.message,'info');
			}
		}
	});
}