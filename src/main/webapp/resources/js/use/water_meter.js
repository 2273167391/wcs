//页面加载
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
	//安装人员
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
	
	$(".wcs_is_change_meter").combobox({
		valueField:"isChangeMeter",
		textField:"isChangeMeter",
		data:[{"isChangeMeter":"否","isChangeMeter":"否"},{"isChangeMeter":"是","isChangeMeter":"是"}]
	});
	
	$(".wcs_is_execute").combobox({
		valueField:"isChangeMeter",
		textField:"isChangeMeter",
		data:[{"isChangeMeter":"否","isChangeMeter":"否"},{"isChangeMeter":"是","isChangeMeter":"是"}]
	});
	
	$(".wcs_meter_status").combobox({
		valueField:"wordBookCode",
		textField:"wordBookContent",
		url:"../base/common/wordbook/W006"
	});
	
	$("#meter_install").linkbutton({"disabled":true});
	$("#meter_start").linkbutton({"disabled":true});
	$("#meter_end").linkbutton({"disabled":true});
	$("#meter_del").linkbutton({"disabled":true});
	
	$(".wcs_water_meter_list").datagrid({
		loadFilter:pagerFilter,
		url:"../use/water_mater/all",
		onSelect:function(rowIndex, rowData){
			if(rowData.meterStatusCode=="W006001"){
				$("#meter_install").linkbutton('enable');
				$("#meter_start").linkbutton('disable');
				$("#meter_end").linkbutton('disable');
				$("#meter_del").linkbutton('enable');
			}else if(rowData.meterStatusCode=="W006002"){
				$("#meter_install").linkbutton('disable');
				$("#meter_start").linkbutton('disable');
				$("#meter_end").linkbutton('enable');
				$("#meter_del").linkbutton('disable');
			}else if(rowData.meterStatusCode=="W006003"){
				$("#meter_install").linkbutton('disable');
				$("#meter_start").linkbutton('enable');
				$("#meter_end").linkbutton('disable');
				$("#meter_del").linkbutton('enable');
			}
		}
	});
}




//添加水表
function addWaterMeter(){
	handlerWaterMeter("添加水表","wcs_save_water_meter_win",320,"wcs_save_water_meter_form");
	//清空表单
	$(".wcs_save_water_meter_form").form("clear");
	$(".wcs_user").combobox({readonly:false});
}

//安装水表
function installWaterMeter(){
	//获取要安装的水表
	var waterMeter=$(".wcs_water_meter_list").datagrid("getSelected");
	if(null==waterMeter){
		$.messager.alert("提示框","请选择要安装的水表！","error");
	}else{
		handlerWaterMeter("安装水表","wcs_install_meter",220,"wcs_install_meter_form");
		$(".wcs_user").combobox({readonly:true});
		//加载表单
		$(".wcs_install_meter_form").form("load",waterMeter);
	}
}

//启用或停用水表
function startOrEndWaterMeter(status){
	var title="确定要停用该用户水表？";
	if("W006002"==status){
		title="确定要启用该用户水表？";
	}
	//获取要停用的水表
	var waterMeter=$(".wcs_water_meter_list").datagrid("getSelected");
	$.messager.confirm("确认对话框",title,function(r){
		if(r){
			$.ajax({
				url:"../use/water_mater/"+waterMeter.waterMeterCode+"/"+status,
				type:'GET',
				dataType:'JSON',
				success:function(data){
					if(data.result==1){
						$(".wcs_water_meter_list").datagrid("reload");//刷新表格
					}else{
						$.messager.alert("提示框",data.message,"error");
					}
				}
			});
		}
	});
}
//删除水表
function deleteMeter(){
	//获取要删除的水表
	var waterMeter=$(".wcs_water_meter_list").datagrid("getSelected");
	$.ajax({
		url:"../use/water_mater/delete/"+waterMeter.waterMeterId,
		type:'GET',
		dataType:'JSON',
		success:function(data){
			if(data.result==1){
				$(".wcs_water_meter_list").datagrid("reload");//刷新表格
			}else{
				$.messager.alert("提示框",data.message,"error");
			}
		}
	});
}

//操作水表
function handlerWaterMeter(title,id,height,form){
	$("#"+id).dialog({
		title:title,
		width:380,
		height:height,
		modal:true,
		buttons:[{
			iconCls:"icon-save",
			text:"保存",
			plain:true,
			handler:function(){
				var index=layer.load();//加载框
				$("."+form).form("submit",{
					url:"../use/water_mater/save",
					onSubmit:function(param){
						var isValid=$(this).form('validate');
						//判断安装日期
						if($("#execute_date").datebox("getText")!=""&&getCurrentDate()>$("#execute_date").datebox("getText")){
							$.messager.alert("提示框","安装日期不能小雨当前日期","info");
							isValid=false;
						}
						//判断换表日期
						if($("#changeDate").datebox("getText")!=""&&getCurrentDate()>$("#changeDate").datebox("getText")){
							$.messager.alert("提示框","换表日期不能小雨当前日期","info");
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
							$(".wcs_water_meter_list").datagrid("reload");//刷新表格
							$("#"+id).dialog("close");//关闭窗口
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

//搜索水表
function queryWaterMeter(){
	var ixs=$("#install_date_s").datebox("getText");//预约安装开始日期
	var ixe=$("#install_date_e").datebox("getText");//预约结束日期
	var exs=$("#execute_date_s").datebox("getText");//安装开始日期
	var exe=$("#execute_date_e").datebox("getText");//安装结束日期
	var changes=$("#change_s").datebox("getText");//换表开始日期
	var changee=$("#change_e").datebox("getText");//换表结束日期
	if(ixs!=""&&ixe!=""&&ixe<ixs){
		$.messager.alert("提示框","预约安装结束日期不能小于开始日期！","info");
		return;
	}
	
	if(exs!=""&&exe!=""&&exe<exs){
		$.messager.alert("提示框","安装结束日期不能小于开始日期！","info");
		return;
	}
	
	if(changes!=""&&changee!=""&&changee<changes){
		$.messager.alert("提示框","换表结束日期不能小于开始日期！","info");
		return;
	}
	//显示加载框
	var index=layer.load();
	$("#wcs_meter_search_form").form('submit',{
		url:"../use/water_mater/all",
		success:function(data){
			layer.close(index);
			$(".wcs_water_meter_list").datagrid('loadData',jQuery.parseJSON(data));
		}
	});
}