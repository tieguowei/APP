package com.resale.background.shiro;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.resale.background.pojo.Employee;
import com.resale.background.pojo.Menu;
import com.resale.background.pojo.Role;
import com.resale.background.service.LoginService;

public class MyShiroRealm extends AuthorizingRealm {
	
    @Autowired
    private LoginService loginService;
	protected final Log logger = LogFactory.getLog(getClass());

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    	Employee employee  = (Employee)principals.getPrimaryPrincipal();
        //根据商户ID查询角色信息
         List<Role> roleList = loginService.findRoleByMerchantId(employee.getEmployeeId());
         for(Role role:roleList){
            authorizationInfo.addRole(role.getRoleCode());
            //根据商户角色id 查询权限
            List<Menu> permissionList = loginService.permissionListRoleId(role.getId());
            for(Menu p:permissionList){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }
    

	 /*进行身份认证，验证用户输入的账号和密码是否正确。*/
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		 //获取用户的输入的账号.
	        String employeeNo = (String)token.getPrincipal();
	        //通过username从数据库中查找 User对象，如果找到，没找到.
	        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
	        Employee employee = loginService.getEmployeeByEmployeeNo(employeeNo);
	        if(employee == null){
	            return null;
	        }
	        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
	        		employee, //用户名
	        		employee.getPassword(), //密码
	                ByteSource.Util.bytes(employee.getEmployeeNo()+employee.getSalt()),//salt=username+salt
	                getName()  //realm name
	        );
	        return authenticationInfo;
	}
	

}