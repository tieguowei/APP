package com.resale.background.shiro;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.resale.background.constants.Constants;
/**
 * 
 *<dl>
 *<dt>类名：CustomFormAuthenticationFilter.java</dt>
 *<dd>描述: 校验 验证码是否正确</dd> 
 *<dd>创建时间： 2018年3月15日 下午3:54:58</dd>
 *<dd>创建人： TieGuowei </dd>
 *<dt>版本历史: </dt>
 * <pre>
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2018年3月15日 下午3:54:58    TieGuowei       1.0        1.0 Version 
 * </pre>
 *</dl>
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

	
		@Override
		protected boolean onAccessDenied(ServletRequest request,
				ServletResponse response) throws Exception {
			
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			HttpSession session =httpServletRequest.getSession();
			//取出session的验证码（正确的验证码）
			String securityCode = (String) session.getAttribute(Constants.CHECK_CODE);
			//取出页面的验证码
			String randomcode = httpServletRequest.getParameter(Constants.CHECK_CODE);
			
			if(randomcode!=null && securityCode!=null && !randomcode.equalsIgnoreCase(securityCode)){
				//如果校验失败，将验证码错误失败信息，通过shiroLoginFailure设置到request中
				httpServletRequest.setAttribute("shiroLoginFailure", "randomCodeError");
				//拒绝访问，不再校验账号和密码 
				return true; 
			}
			return super.onAccessDenied(request, response);
		}
		
		
	@Override
	    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
			// 登录成功后要跳转的链接
			String successUrl ="/index.jsp";
	        WebUtils.issueRedirect(request,response,successUrl);
	        return false;
	    }
}
