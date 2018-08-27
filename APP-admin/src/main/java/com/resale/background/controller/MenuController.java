package com.resale.background.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.resale.background.pojo.Menu;
import com.resale.background.service.MenuService;
import com.resale.background.util.DataMsg;
import com.resale.background.util.PageModel;
import com.resale.util.StringUtil;

/**
 *	菜单管理
 * @author tie
 *
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	

	/**
	 * 跳转到菜单列表页面
	 * @return
	 */
	@RequiresPermissions("menuManager:list")//权限管理;
	@RequestMapping("/goMenuPage")
	public String goMenuPage(){
		return "basic/menuList";
	}
	
	
	/**
	 * 分页查询所有
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMenuList")
	public DataMsg getMenuList(HttpServletRequest request,DataMsg dataMsg){
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			String nameZh =StringUtil.trim(request.getParameter("nameZh"));
			if (StringUtil.isNotBlank(nameZh)) {
				paramsCondition.put("nameZh", nameZh);
			}
			paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("pageNumber")));
			paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("pageSize")));
			PageModel pageModel =menuService.getMenuList(paramsCondition);
			dataMsg.setTotal(pageModel.getTotalRecords());
			dataMsg.setRows(pageModel.getList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataMsg;
	}
	/**
	 * 查询所有pid为0的菜单
	 * @return map
	 */
	@ResponseBody
	@RequestMapping("/getParentMenuList")
	public List<Map<String,Object>> getParentMenuList(){
		try {
			return menuService.getParentMenuList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 添加菜单
	 * @param menu
	 * @return
	 */
	@RequiresPermissions("menuManager:add")
	@ResponseBody
	@RequestMapping("/saveMenu")
	public boolean saveMenu(Menu menu){
		try {
			menuService.saveMenu(menu);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * 校验菜单名称是否存在
	 * @param menu
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkMenuName")
	public boolean checkMenuName(HttpServletRequest request){
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			String nameZh = StringUtil.trim(request.getParameter("nameZh"));
			if (StringUtil.isNotBlank(nameZh)) {
				map.put("nameZh", nameZh);
			}
			String menuId = StringUtil.trim(request.getParameter("menuId"));
			if (StringUtil.isNotBlank(menuId)) {
				map.put("menuId", menuId);
			}
			Menu result = menuService.checkMenuNameIsRepeat(map);
			if(result == null){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * 修改回显
	 */
	
	@ResponseBody
	@RequestMapping("/getMenuById")
	public Map<String,Object> getMenuById(@RequestParam("mid")int mid){
		try {
			Map<String,Object>map=new HashMap<String, Object>();
			List<Map<String,Object>> list=menuService.getParentMenuList();
			Menu menu=menuService.quertMenuById(mid);
			map.put("list", list);
			map.put("menu", menu);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 修改菜单
	 * @param menu
	 * @return
	 */
	@RequiresPermissions("menuManager:update")
	@ResponseBody
	@RequestMapping("/updateMenu")
	public String updateMenu(Menu menu){
		try {
			menuService.updateMenu(menu);
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "2";
		}
		
	}
	

	/**
	 * 删除菜单
	 * @param menu
	 * @return
	 */
	@RequiresPermissions("menuManager:delete")
	@ResponseBody
	@RequestMapping("/deleteMenu")
	public boolean deleteMenu(Menu menu){
		try {
			menuService.deleteMenu(menu);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	
}
