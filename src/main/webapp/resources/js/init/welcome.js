//未缴费
$(".wcs_water_not_charge_list").datagrid({
	loadFilter:pagerFilter,
	url:"../cost/water_charge/not_charge"
});

//未安装
$(".wcs_not_install_water_meter_list").datagrid({
	loadFilter:pagerFilter,
	url:"../use/water_mater/not_install"
});