package com.resale.background.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resale.background.mapper.MenuMapper;
import com.resale.background.pojo.Employee;
import com.resale.background.pojo.Menu;
import com.resale.background.service.MenuService;
import com.resale.background.util.PageModel;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuMapper menuMapper;
	
	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public List<Menu> getMenuByEmployeeId(Integer employeeId) {
		Map<String,Object> requestMap = new HashMap<String,Object>();
		requestMap.put("employeeId", employeeId);
		requestMap.put("pid", 0);
		List<Menu>plist=menuMapper.getMenuByMerchantId(requestMap);
		for(Menu m:plist){
			Map<String,Object>map = new HashMap<String,Object>();
			map.put("employeeId", employeeId);
			map.put("pid", m.getMenuId());
			List<Menu>clist=menuMapper.getMenuByMerchantId(map);
			if(clist!=null){
				m.setChildren(clist);
			}
		}
		return plist;
	}
	
	/**
	 *  分页查询所有
	 */
	@Override
	public PageModel getMenuList(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = menuMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = menuMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}

	@Override
	public List<Map<String, Object>> getParentMenuList() {
		return menuMapper.getParentMenuList();
	}

	@Override
	public Menu checkMenuNameIsRepeat(Map<String, Object> map) {
		return menuMapper.checkMenuNameIsRepeat(map);
	}

	@Override
	public void saveMenu(Menu menu) {
		//从shiro中获取商户信息
		Subject subject = SecurityUtils.getSubject();
		Employee employee = (Employee) subject.getPrincipal();
		menu.setCreatorId(employee.getEmployeeId());
		menu.setUpdateTime(new Date());
		menu.setCreateTime(new Date());
		menuMapper.insert(menu);
	}

	@Override
	public Menu quertMenuById(int mid) {
		return menuMapper.selectByPrimaryKey(mid);
	}

	@Override
	public void updateMenu(Menu updateMenu) {
		//从shiro中获取商户信息
		Subject subject = SecurityUtils.getSubject();
		Employee employee = (Employee) subject.getPrincipal();
		//查询出要修改的记录
		Menu menu = menuMapper.selectByPrimaryKey(updateMenu.getMenuId());
		
		updateMenu.setCreatorId(employee.getEmployeeId());
		updateMenu.setUpdateTime(new Date());
		updateMenu.setCreateTime(new Date());
		
		//以下字段无需修改
		updateMenu.setCreateTime(menu.getCreateTime());
		updateMenu.setNameEn(menu.getNameEn());
		updateMenu.setMenuSort(menu.getMenuSort());
		menuMapper.updateByPrimaryKey(updateMenu);
	}

	@Override
	public void deleteMenu(Menu menu) {
		
		//从shiro中获取商户信息
		Subject subject = SecurityUtils.getSubject();
		Employee employee = (Employee) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("menuId", menu.getMenuId());
		map.put("creatorId", employee.getEmployeeId());
		map.put("menuStatus", "3");
		menuMapper.deleteMenuByMenuId(map);
	}

	
	


}
