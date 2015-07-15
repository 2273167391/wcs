/**
 * 用户角色
 */
function userRole(result) {
	$(".wcs_role_container").show();// 显示用户选择角色容器
	$("#wcs_role_win").dialog({
		title : "角色选择",
		iconCls : "icon-role",
		width : 200,
		height : 115,
		modal : true,
		draggable : false,
		buttons : [ {
			iconCls:"icon-confirm",
			text : "确定",
			plain:true,
			handler : function() {
				location.href = "main/" + $("#wcs_role").combobox('getValue');
			}
		} ]
	});
	// 下拉框
	$("#wcs_role").combobox({
		valueField : "roleId",
		textField : "roleName",
		data : result,
		onLoadSuccess : function(node) {
			$(this).combobox('setValue', node[0].roleId);
		}
	});
}

/**
 * 分页数据过滤
 * @param data
 * @returns
 */
function pagerFilter(data) {
    if (typeof data.length == 'number' && typeof data.splice == 'function') {
        data = {
            total: data.length,
            rows: data
        };
    }
    var wcsDg = $(this);//获取Grid对象
    var opts = wcsDg.datagrid('options');//获取属性对象
    var pager = wcsDg.datagrid('getPager');//返回页面对象
    pager.pagination({
        //选择一个新页面触发
        onSelectPage: function (pageNum, pageSize) {
            opts.pageNumber = pageNum;
            opts.pageSize = pageSize;
            //刷新页面
            pager.pagination('refresh', {
                pageNumber: pageNum,
                pageSize: pageSize
            });
            pager.pagination('loaded');
            wcsDg.datagrid('loadData', data);
        }
    });
    if (!data.originalRows) {
        data.originalRows = (data.rows);
    }

    var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
    var end = start + parseInt(opts.pageSize);
    data.rows = data.originalRows.slice(start, end);
    return data;
}

/**
 * 获取当前时间
 */
function getCurrentDate(){
	var date=new Date();
	var year=date.getFullYear();//获取年份
	var month=date.getMonth()+1;//获取月份
	var day=date.getDate();//获取天
	if(month<10){
		month="0"+month;
	}
	if(day<10){
		day="0"+day;
	}
	return year+"-"+month+"-"+day;
}


