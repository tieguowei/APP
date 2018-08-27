package com.resale.background.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resale.background.constants.RedisConstant;
import com.resale.background.mapper.EmployeeMapper;
import com.resale.background.mapper.MenuMapper;
import com.resale.background.mapper.RoleMapper;
import com.resale.background.pojo.Employee;
import com.resale.background.pojo.Menu;
import com.resale.background.pojo.Role;
import com.resale.background.redis.RedisClient;
import com.resale.background.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private EmployeeMapper  employeeMapper;
	@Autowired
	private RedisClient redisClinet;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private MenuMapper menuMapper;
	
	protected final Log logger = LogFactory.getLog(getClass());

	
	@Override
	public Employee getEmployeeByEmployeeNo(String employeeNo) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("employeeNo", employeeNo);
		Employee employee = employeeMapper.getEmployeeByEmployeeNo(map);
		return employee;
	}
	
	
	@Override
	public void deleteImageVerificationCode(String key) {
		redisClinet.delete(key);
	}

	@Override
	public void setImageVerificationCode(String key, String value) {
		redisClinet.set(key, value);
		redisClinet.expire(key, RedisConstant.REDIS_TOKEN_BACKGROUND_LOGIN);
	}




	/**
	 * 根据商户ID查询角色信息
	 */
	@Override
	public List<Role> findRoleByMerchantId(Integer id) {
		return roleMapper.findRoleByMerchantId(id);
	}



	/**
	 * 根据商户角色id 查询权限
	 */
	@Override
	public List<Menu> permissionListRoleId(Integer id) {
		return menuMapper.permissionListRoleId(id);
	}




	

	
}
