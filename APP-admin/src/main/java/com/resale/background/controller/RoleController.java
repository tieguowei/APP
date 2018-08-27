package com.resale.background.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.resale.background.pojo.Role;
import com.resale.background.service.RoleService;
import com.resale.background.util.DataMsg;
import com.resale.background.util.PageModel;
import com.resale.background.util.ViewTree;
import com.resale.util.StringUtil;

/**
 *	角色管理
 * @author tie
 *
 */
@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	

	/**
	 * 跳转到角色列表页面
	 * @return
	 */
	@RequiresPermissions("roleManager:list")//权限管理;
	@RequestMapping("/goRolePage")
	public String goRolePage(){
		return "basic/roleList";
	}
	
	/**
	 * 分页查询所有角色
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getRoleList")
	public DataMsg getRoleList(HttpServletRequest request,DataMsg dataMsg){
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("pageNumber")));
			paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("pageSize")));
			PageModel pageModel =roleService.getRoleList(paramsCondition);
			dataMsg.setTotal(pageModel.getTotalRecords());
			dataMsg.setRows(pageModel.getList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataMsg;
	}
	
	
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	@RequiresPermissions("roleManager:add")
	@ResponseBody
	@RequestMapping("/saveRole")
	public boolean saveRole(Role role){
		try {
			roleService.saveRole(role);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * 校验角色编码是否存在
	 * @param menu
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkRoleCode")
	public boolean checkRoleCode(HttpServletRequest request){
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			String roleCode = StringUtil.trim(request.getParameter("roleCode"));
			if (StringUtil.isNotBlank(roleCode)) {
				map.put("roleCode", roleCode);
			}
			String id = StringUtil.trim(request.getParameter("id"));
			if (StringUtil.isNotBlank(id)) {
				map.put("id", id);
			}
			Role result = roleService.checkRoleCodeIsRepeat(map);
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
	@RequestMapping("/getRoleById")
	public Map<String,Object> getRoleById(@RequestParam("rid")int id,Model model){
		try {
			Map<String,Object>map=new HashMap<String, Object>();
			Role role=roleService.quertRoleById(id);
			map.put("role", role);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	@RequiresPermissions("roleManager:update")
	@ResponseBody
	@RequestMapping("/updateRole")
	public boolean updateRole(Role role){
		try {
			roleService.updateRole(role);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	/**
	 * 删除菜单
	 * @param role
	 * @return
	 */
	@RequiresPermissions("roleManager:delete")
	@ResponseBody
	@RequestMapping("/deleteRole")
	public boolean deleteRole(Role role){
		try {
			roleService.deleteRole(role);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	/**
	 * 加载权限菜单
	 * @param rid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/viewTree")
	public List<ViewTree> getRoleTree(@RequestParam("rid")int rid){
		try {
			return roleService.getViewTree(rid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 修改角色权限
	 */
	
	@ResponseBody
	@RequiresPermissions("roleManager:updateRoleAuth")
	@RequestMapping("/updateRoleAuth")
	public boolean updateRoleAuth(@RequestParam("rid")int rid,@RequestParam("menuIds")String menuIds){
			try {
				roleService.updateRoleAuth(rid, menuIds);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	
}
