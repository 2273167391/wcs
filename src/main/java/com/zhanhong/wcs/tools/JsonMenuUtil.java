package com.zhanhong.wcs.tools;
import java.util.ArrayList;
import java.util.List;

import com.zhanhong.wcs.entity.sys.WcsSysMenus;

public class JsonMenuUtil {
private JsonMenuUtil(){}
	
	/**
	 * 获取JSON格式菜单
	 * @param authorityList 权限集合
	 * @return
	 */
	public static String getJsonMenu(List<WcsSysMenus> menusList){
		//创建StringBuffer
		StringBuffer jsonMenu=new StringBuffer("var menus=[");
		//声明存放父菜单集合
		List<WcsSysMenus> parentMenusList=new ArrayList<WcsSysMenus>();
		//遍历所有菜单集合
		for (WcsSysMenus menus : menusList) {
			if(menus.getMenuLevel()==0){
				parentMenusList.add(menus);
			}
		}
		
		//遍历父菜单集合拼接为JSON数据
		for (int i=0;i<parentMenusList.size();i++) {
			WcsSysMenus menus=parentMenusList.get(i);
			jsonMenu.append("{");
			jsonMenu.append("\"id\":").append(menus.getMenuId()).append(",");
			jsonMenu.append("\"name\":\"").append(menus.getMenuName()).append("\",");
			jsonMenu.append("\"url\":\"").append(menus.getMenuUrl()).append("\",");
			jsonMenu.append("\"parentId\":").append(menus.getMenuParentId()).append(",");
			jsonMenu.append("\"children\":[").append(getChildMenus(menusList,menus)).append("]");
			jsonMenu.append("}");
			if(parentMenusList.size()-1!=i){
				jsonMenu.append(",");
			}
		}
		jsonMenu.append("]");
		return jsonMenu.toString();
	}
	
	/**
	 * 获取子菜单
	 * @param authorityList 所有菜单集合
	 * @param authority 父菜单对象
	 * @return
	 */
	private static String getChildMenus(List<WcsSysMenus> parentMenusList,WcsSysMenus menus){
		//创建StringBuffer
		StringBuffer childMenu=new StringBuffer();
		//创建存放子菜单集合
		List<WcsSysMenus> childMenuList=new ArrayList<WcsSysMenus>();
		//遍历所有菜单
		for(int i=0;i<parentMenusList.size();i++){
			WcsSysMenus child=parentMenusList.get(i);
			if(null==child.getMenuParentId()) continue;
			if(menus.getMenuId()==child.getMenuParentId()){
				childMenuList.add(child);
			}
		}
		//遍历子菜单
		for(int i=0;i<childMenuList.size();i++){
			WcsSysMenus child=childMenuList.get(i);
			childMenu.append("{");
			childMenu.append("\"id\":").append(child.getMenuId()).append(",");
			childMenu.append("\"name\":\"").append(child.getMenuName()).append("\",");
			childMenu.append("\"url\":\"").append(child.getMenuUrl()).append("\",");
			childMenu.append("\"parentId\":").append(child.getMenuParentId()).append(",");
			childMenu.append("\"children\":[").append(getChildMenus(parentMenusList,child)).append("]");
			childMenu.append("}");
			if(childMenuList.size()-1!=i){
				childMenu.append(",");
			}
		}
		return childMenu.toString();
	}
}
