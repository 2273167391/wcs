/**
 * 加载页面
 */
function loadPage(){
	//设置字典类别
	$("#wcs_wordbook_type").combobox({
		valueField:"wordBookCode",
		textField:"wordBookContent",
		url:"../sys/wordbook/type"
	});
	
	$("#update_wordbook").linkbutton({"disabled":true});
	$("#delete_wordbook").linkbutton({"disabled":true});
	
	//填充数据字典表格数据
	$("#wcs_wordbook_list").datagrid({
		loadFilter: pagerFilter,
		url:"../sys/wordbook/all",
		rowStyler:function(index,row){
			if(null==row.wordBookTypeCode){
				return "background:#EEEE77";
			}
		},
		onSelect:function(rowIndex,rowData){
			$("#update_wordbook").linkbutton('enable');
			$("#delete_wordbook").linkbutton('enable');
		}
	});
}



//查询
function queryWordbook(){
	//显示加载框
	var index=layer.load();
	$("#wcs_wordbook_search_form").form('submit',{
		url:"../sys/wordbook/all",
		success:function(data){
			layer.close(index);
			$("#wcs_wordbook_list").datagrid('loadData',jQuery.parseJSON(data));
		}
	});
}

//新增数据字典
function addWordbook(){
	$("#wcs_save_wordbook_form").form("clear");//清空表单
	//设置默认生效时间为当前时间
	$("#wb_effective_date").datebox('setValue',getCurrentDate());
	$("#wb_code").removeAttr("readonly").css("background","#fff");
	$("#wb_type_code").removeAttr("readonly").css("background","#fff"); 
	$("#wcs_save_wordbook_win").dialog({
		title:"添加数据字典",
		width:500,
		height:350,
		modal:true,
		buttons:[{
			iconCls:"icon-save",
			plain:true,
			text:"保存",
			handler:function(){
				wordbookHandler("../sys/wordbook/add");
			}
		}]
	});
	
}

//修改数据字典
function updateWordbook(){
	
	//获取选中的行
	var wordbook=$("#wcs_wordbook_list").datagrid("getSelected");
	if(null==wordbook){
		$.messager.alert("提示框","请选择要编辑的数据字典！","error");
	}else{
		$("#wcs_save_wordbook_form").form("clear");//清空表单
		$("#wcs_save_wordbook_win").dialog({
			title:"修改数据字典",
			width:500,
			height:350,
			modal:true,
			buttons:[{
				iconCls:"icon-save",
				plain:true,
				text:"保存",
				handler:function(){
					wordbookHandler("../sys/wordbook/update");
				}
			}]
		});
		$("#wb_code").attr("readonly","readonly").css("background","#F7F7F7");
		$("#wb_type_code").attr("readonly","readonly").css("background","#F7F7F7").val(" "); 
		//加载表单
		$("#wcs_save_wordbook_form").form("load",wordbook);
	}
}

//删除数据字典
function deleteWordbook(){
	//获取选中的行
	var wordbook=$("#wcs_wordbook_list").datagrid("getSelected");
	if(null==wordbook){
		$.messager.alert("提示框","请选择要删除的数据字典！","error");
	}else{
		$.ajax({
			url:"../sys/wordbook/delete/"+wordbook.wordBookCode,
			type:'GET',
			dataType:'json',
			success:function(data){
				if(data.result==1){
					$("#wcs_wordbook_list").datagrid('reload');//刷新表格
				}else{
					$.messager.alert("提示框",data.message,"error");
				}
			}
		});
	}
}

//数据字典操作
function wordbookHandler(path){
	var index=layer.load();
	$("#wcs_save_wordbook_form").form('submit',{
		url:path,
		onSubmit:function(param){
			var isValid=$(this).form("validate");
			if(!isValid){
				layer.close(index);
			}
			return isValid;
		},
		success:function(data){
			data=jQuery.parseJSON(data);
			if(data.result==1){
				$("#wcs_wordbook_list").datagrid("reload");//刷新表格
				$("#wcs_save_wordbook_win").dialog('close');//关闭窗口
			}else{
				$.messager.alert("提示框",data.message,"error");
			}
			layer.close(index);
		}
	});
}