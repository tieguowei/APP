package com.resale.background.service;

import java.util.List;
import java.util.Map;

import com.resale.background.pojo.Menu;
import com.resale.background.util.PageModel;

public interface MenuService {
	
	/**
	 * 根据员工id获取菜单
	 * @param id
	 * @return
	 */
	public List<Menu> getMenuByEmployeeId(Integer employeeId);

	/**
	 *  分页查询所有菜单
	 * @param paramsCondition
	 * @return
	 */
	public PageModel getMenuList(Map<String, Object> paramsCondition);
	/**
	 * 查询所有pid为0的菜单
	 * @return map
	 */
	public List<Map<String, Object>> getParentMenuList();
	/**
	 * 校验菜单名称是否重复
	 * @param map
	 * @return
	 */
	public Menu checkMenuNameIsRepeat(Map<String, Object> map);
	/**
	 * 添加菜单
	 * @param menu
	 */
	public void saveMenu(Menu menu);
	/**
	 * 根据id 查询菜单 修改回显
	 * @param mid
	 * @return
	 */
	public Menu quertMenuById(int mid);
	/**
	 * 修改菜单
	 * @param menu
	 */
	public void updateMenu(Menu menu);
	/**
	 * 删除菜单
	 * @param menu
	 */
	public void deleteMenu(Menu menu);
	
}
