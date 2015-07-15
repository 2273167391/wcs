/**
 * 加载页面
 */
function loadPage(){
	//水表编码
	$(".wcs_meter_code").combobox({
		valueField:"waterMeterId",
		textField:"waterMeterCode",
		url:"../use/water_mater/employ"
	});
	
	//收费类型
	$(".wcs_charge_type").combobox({
		valueField:"wordBookCode",
		textField:"wordBookContent",
		url:"../base/common/wordbook/W007",
		onSelect:function(record){
			//获取收费类型编码
			var chargeType=record.wordBookCode;
			if("W007001"==chargeType){
				$(".real_price").numberbox({"disabled":true,"value":$(".month_money").val()}).css("background","#f5f5f5");
				$(".change_money").val(0);
			}else{
				$(".real_price").numberbox({"disabled":false,"value":0}).css("background","#fff").val(0);
			}
		}
	});
	
	//收费状态
	$(".wcs_charge_status").combobox({
		valueField:"wordBookCode",
		textField:"wordBookContent",
		url:"../base/common/wordbook/W008" 
	});
	
	//收费人员
	$(".wcs_charge_emp").combogrid({
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
	
	$("#water_charge").linkbutton({"disabled":true});
	$("#dele_water_charge").linkbutton({"disabled":true});

	$(".wcs_water_charge_list").datagrid({
		loadFilter:pagerFilter,
		url:"../cost/water_charge/all",
		onSelect:function(rowIndex, rowData){
			//判断收费状态
			if("W008001"==rowData.chargeStatus){
				$("#water_charge").linkbutton('disable');
			}else{
				$("#water_charge").linkbutton('enable');
			}
			$("#dele_water_charge").linkbutton('enable');
		}
	});
	
	//实收金额失去焦点
	$(".real_price").blur(function(){
		//获取应收金额
		var monthMoney=$(".month_money").val();
		//获取实收金额
		var realPrice=$(this).val();
		if(parseFloat(realPrice)<parseFloat(monthMoney)){
			$.messager.alert("提示框","实收金额不能小于应收金额！","info");
		}else{
			$(".change_money").val(realPrice-monthMoney);
		}
	});
}

/**
 * 记录类型样式
 */
function noteStyle(value,rowData,rowIndex){
	if(rowData.chargeStatus=="W008001"){
		return "color:red;text-align:center;";
	}else{
		return "color:#058048;text-align:center;";
	}
}

/**
 * 收费
 */
function waterCharge(){
	//获取表单
	var waterChargeForm=$(".wcs_save_water_charge_form");
	//获取收费窗口
	var waterChargeWin=$("#wcs_save_water_charge_win");
	//获取收费记录
	var waterCharge=$(".wcs_water_charge_list").datagrid("getSelected");
	waterChargeForm.form("clear");//清空表单
	$(".remarks").val("用水收费");
	waterChargeWin.dialog({
		title:"用水收费",
		width:350,
		height:350,
		buttons:[{
			iconCls:"icon-save",
			plain:true,
			text:"保存",
			handler:function(){
				//加载框
				var index=layer.load();
				waterChargeForm.form("submit",{
					url:"../cost/water_charge/save",
					onSubmit:function(param){
						var isValid=$(this).form("validate");
						//获取应收金额
						var monthMoney=$(".month_money").val();
						//获取实收金额
						var realPrice=$(".real_price").numberbox('getValue');
						if(parseFloat(realPrice)<parseFloat(monthMoney)){
							$.messager.alert("提示框","实收金额不能小于应收金额！","info");
							isValid=false;
						}
						if(!isValid){
							layer.close(index);
						}
						return isValid;
					},success:function(data){
						data=jQuery.parseJSON(data);
						if(data.result==1){
							$(".wcs_water_charge_list").datagrid("reload");//刷新表格
							waterChargeWin.dialog("close");//关闭窗口
						}else{
							$.messager.alert("提示框",data.message,"info");
						}
						layer.close(index);
					}
				});
			}
		}]
	});
	//加载表单
	waterChargeForm.form("load",waterCharge);
}

/**
 * 查询记录
 */
function queryWaterCharge(){

	var startChargeDate=$(".start_charge_date").datebox("getText");//记录开始日期
	var endChargeDate=$(".end_charge_date").datebox("getText");//记录开始日期
	if(startChargeDate!=""&&endChargeDate!=""&&endChargeDate<startChargeDate){
		$.messager.alert("提示框","收费开始日期不能小于结束日期！","info");
		return;
	}
	
	//加载框
	var index=layer.load();
	$("#wcs_water_charge_search_form").form('submit',{
		url:"../cost/water_charge/all",
		success:function(data){
			layer.close(index);
			$(".wcs_water_charge_list").datagrid('loadData',jQuery.parseJSON(data));
		}
	});
}