/**
 * 加载页面
 */
function loadPage(){
	$("#dele_copy_meter").linkbutton({"disabled":true});
	
	$(".wcs_copy_meter_list").datagrid({
		loadFilter:pagerFilter,
		url:"../cost/meter/all",
		onSelect:function(rowIndex, rowData){
			$("#dele_copy_meter").linkbutton('enable');
		}
	});
	
	$(".wcs_meter_code").combobox({
		valueField:"waterMeterId",
		textField:"waterMeterCode",
		url:"../use/water_mater/employ",
		onSelect:function(record){
			//获取选中的水表编码
			var code=record.waterMeterCode;
			//获取选中的ID
			var id=record.waterMeterId;
			$.ajax({
				url:"../cost/meter/month_number/"+id+"/"+code,
				type:'GET',
				dataType:'JSON',
				success:function(data){
					$(".start_number").val(data);
				}
			});
		}
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
	
	//抄表人员		
	$(".wcs_handler").combogrid({
		fitColumns:true,
		idField:"empId",
		textField:"trueName",
		url:"../sys/emp/RT003",
		columns:[[
			{field:'empId',hidden:true},
			{field:'account',title:'登录名',width:60},
			{field:'trueName',title:'姓名',width:60}
		]]
	});
	
	$(".wcs_water_price_type").combobox({
		valueField:"wordBookCode",
		textField:"wordBookContent",
		url:"../base/common/wordbook/W001" 
	});
	
	$(".end_number").blur(function(){
		//获取起数
		var startNumber=$(".start_number").val();
		var endNumber=$(this).val();
		if(parseFloat(endNumber)<parseFloat(startNumber)){
			$.messager.alert("提示框","止数不能小于起数！","info");
		}else{
			$(".definite_number").val(endNumber-startNumber);
			}
		});
	}
	
/**
 * 添加抄表记录
 */
function addCopyMeter(){
	$(".wcs_save_water_meter_form").form("clear");//清空表单
	$("#wcs_save_copy_meter_win").dialog({
		title:"添加抄表记录",
		width:350,
		height:280,
		modal:true,
		buttons:[{
			iconCls:"icon-save",
			text:"保存",
			plain:true,
			handler:function(){
				//加载框
				var index=layer.load();
				$(".wcs_save_water_meter_form").form("submit",{
					url:"../cost/meter/save",
					onSubmit:function(param){
						var isValid=$(this).form('validate');
						//获取起数
						var startNumber=$(".start_number").val();
						var endNumber=$(".end_number").val();
						if(parseFloat(endNumber)<parseFloat(startNumber)){
							$.messager.alert("提示框","止数不能小于起数！","info");
							isValid=false;
						}
						if (!isValid){
							layer.close(index);
						}
						return isValid;	// 返回false终止表单提交
					},
					success:function(data){
						data=jQuery.parseJSON(data);
						if(data.result==1){
							$(".wcs_copy_meter_list").datagrid("reload");//刷新表格
							$("#wcs_save_copy_meter_win").dialog("close");//关闭窗口
						}else{
							$.messager.alert("提示框",data.message,"info");
							}
							layer.close(index);
						}
					});
				}
			}]
		});
	}
	
/**
 * 查询抄表记录
 */
function queryCopyMeter(){
	var startCopyDate=$(".start_copy_date").datebox("getText");//记录开始日期
	var endCopyDate=$(".end_copy_date").datebox("getText");//记录开始日期
	if(startCopyDate!=""&&endCopyDate!=""&&endCopyDate<startCopyDate){
		$.messager.alert("提示框","抄表开始日期不能小于结束日期！","info");
		return;
	}
	
	//加载框
	var index=layer.load();
	$("#wcs_copy_meter_search_form").form('submit',{
		url:"../cost/meter/all",
		success:function(data){
			layer.close(index);
			$(".wcs_copy_meter_list").datagrid('loadData',jQuery.parseJSON(data));
			}
		});
	}
	
/**
 * 删除抄表记录
 */
function deleteCopyMeter(){
	//获取要删除的记录
	var copyMeter=$(".wcs_copy_meter_list").datagrid("getSelected");
	$.ajax({
		url:"../cost/meter/delete/"+copyMeter.copyMeterId,
		type:'GET',
		dataType:'JSON',
		success:function(data){
			if(data.result==1){
				$(".wcs_copy_meter_list").datagrid("reload");//刷新表格
			}else{
				$.messager.alert("提示框",data.message,"info");
				}
			}
		});
	}