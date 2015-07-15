var roleGrid=$(".wcs_role_list");
roleGrid.datagrid({
	loadFilter: pagerFilter,
    url:'../sys/role/role_list',
    onLoadSuccess:function(data){
    	$(this).datagrid("selectRow",0);
    	checkMenu(data.rows[0].roleId);
    },
    onSelect:function(rowIndex,rowData){
    	checkMenu(rowData.roleId);
    }
});

$(".wcs_menu_tree").tree({
	url:'../sys/menu/all',
	lines:true,
	checkbox:true,
	cascadeCheck:false,
	animate:true,
	loadFilter:function(data){
		return data;
	}
});
//选中菜单
function checkMenu(roleId){
	$.ajax({
   		url:"../sys/role_menu/"+roleId,
   		type:'GET',
   		dataType:'html',
   		success:function(result){
   			result=result.split(",");
   			//获取选中的菜单节点
			var allCheckNode=$(".wcs_menu_tree").tree('getChecked');
			for(var i=0;i<allCheckNode.length;i++){
				//取消选中的节点
				$(".wcs_menu_tree").tree('uncheck',allCheckNode[i].target);
			}
   			for(var i=0;i<result.length;i++){
   				var node=$(".wcs_menu_tree").tree('find',result[i]);//查找节点
   				if(null!=node){
   					 $(".wcs_menu_tree").tree('check',node.target);//选中节点
   				}
   			}
   		}
   	});
}
//保存菜单角色
function saveRoleMenu(){
	//获取选中的菜单节点
	var allCheckNode=$(".wcs_menu_tree").tree('getChecked');
	var role=$(".wcs_role_list").datagrid('getSelected');//获取选中的用户
	var menuId="";
	for(var i=0;i<allCheckNode.length;i++){
	   menuId=menuId+allCheckNode[i].id+',';
	}
	$.ajax({
		url:"../sys/role_menu/save/"+menuId.substring(0,menuId.length-1)+"/"+role.roleId,
		type:'GET',
		dataType:'json',
		success:function(data){
			$.messager.alert("提示框",data.message,"info");
		}
	});
}