/**
 * 加载页面
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
	
	$(".wcs_is_change_meter").combobox({
		valueField:"isExpend",
		textField:"rechargeExpense",
		data:[{"isExpend":"0","rechargeExpense":"充值"},{"isExpend":"1","rechargeExpense":"消费"}]
	});

	//记录人员
	$(".wcs_notes_emp").combogrid({
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
	
	$("#dele_notes").linkbutton({"disabled":true});
	$(".wcs_recharge_expense_list").datagrid({
		loadFilter:pagerFilter,
		url:"../cost/recharge_notes/all",
		onSelect:function(rowIndex, rowData){
			$("#dele_notes").linkbutton('enable');
		}
	});
}
/**
 * 记录类型样式
 */
function noteStyle(value,rowData,rowIndex){
	if(rowData.isExpend==0){
		return "color:red;text-align:center;";
	}else{
		return "color:#058048;text-align:center;";
	}
}

/**
 * 查询记录
 */
function queryNotes(){
	var notesDate=$("#notes_date").datebox("getText");//记录开始日期
	var endNotesDate=$("#end_notes_date").datebox("getText");//记录开始日期
	if(notesDate!=""&&endNotesDate!=""&&endNotesDate<notesDate){
		$.messager.alert("提示框","记录开始日期不能小于结束日期！","info");
		return;
	}
	//显示加载框
	var index=layer.load();
	$("#wcs_recharge_expense_search_form").form('submit',{
		url:"../cost/recharge_notes/all",
		success:function(data){
			layer.close(index);
			$(".wcs_recharge_expense_list").datagrid('loadData',jQuery.parseJSON(data));
		}
	});
}

/**
 * 删除记录
 */
function deleteNotes(){
	var notes=$(".wcs_recharge_expense_list").datagrid("getSelected");
	$.ajax({
		url:"../cost/recharge_notes/delete/"+notes.rechargeId,
		type:'GET',
		dataType:'JSON',
		success:function(data){
			if(data.result==1){
				$(".wcs_recharge_expense_list").datagrid("reload");//刷新表格
			}else{
				$.messager.alert("提示框",data.message,"info");
			}
		}
	});
}