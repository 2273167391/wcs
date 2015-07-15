$("#wcs_menu_tree").tree({
	url:'../sys/menu/all',
	lines:true,
	animate:true,
	loadFilter:function(data){
		return data;
	},
	onSelect:function(node){
		//获取到菜单信息加载到表单中
		$("#menu_form").form('load','../sys/menu/'+node.id);
	}
});

/**
 *保存菜单
 */
function saveMenu(){
	var index=layer.load();//加载框
	$("#menu_form").form('submit',{
		url:'../sys/menu/save',
		onSubmit:function(param){
			var isValid = $(this).form('validate');
			if (!isValid){
				layer.close(index);	// 如果表单是无效的则关闭加载框
			}
			return isValid;	// 返回false终止表单提交
		},
		success:function(data){
			data=jQuery.parseJSON(data);
			layer.close(index);//关闭加载框
			if(data.result==1){
				$("#wcs_menu_tree").tree('reload');//刷新树
			}else{
				$.messager.alert("提示框",data.message,"error");
			}
		}
	});
}

/**
 *添加菜单
 */
function addMenu(){
	//获取选中的节点
	var node=$("#wcs_menu_tree").tree('getSelected');
	if(node!=null){
		$("#menu_form").form('load',{
			menuId:0,
			menuParentId:node.id,
			menuParentName:node.text,
			menuName:'',
			menuUrl:''
		});
	}
}

/**
 *删除菜单
 */
 function deleteMenu(){
 	//获取选中的节点
	var node=$("#wcs_menu_tree").tree('getSelected');
	if(node==null){
		$.messager.alert("提示框","请选择要删除的菜单！","info");
	}else{
		$.ajax({
			url:'../sys/menu/delete/'+node.id,
			type:'GET',
			dataType:'json',
			success:function(data){
				if(data.result==1){
					$("#wcs_menu_tree").tree('reload');//刷新树
				}else{
					$.messager.alert("提示框",data.message,"error");
				}
			},error:function(e){
				$.messager.alert("错误框","异步请求失败！","error");
			}
		});
	}
 }