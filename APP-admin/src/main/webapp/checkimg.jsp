<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.resale.background.util.VerifyCode"%>
<%@page contentType="image/jpeg"%>
<%@page import="javax.imageio.ImageIO"%>   
<%@page import="com.resale.background.constants.Constants"%>
<%@page import="java.awt.Color"%>


<%-- <%@page import="org.springframework.web.context.WebApplicationContext" %>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@page import="com.resale.background.service.LoginService" %> --%>


 
<%  
	//WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
	//LoginService redis = (LoginService) ctx.getBean("loginServiceImpl");	
	response.setHeader("Pragma","No-cache");   
	response.setHeader("Cache-Control","no-cache");   
	response.setDateHeader("Expires",0);  
	session.removeAttribute(Constants.CHECK_CODE);
	
	//删除redis中的验证码 (shiro CustomFormAuthenticationFilter 注入不进去redis)
	//redis.deleteImageVerificationCode(Constants.CHECK_CODE);
	String checkCode = VerifyCode.generateTextCode(VerifyCode.TYPE_NUM_UPPER,4,"0oOilJI1");
	session.setAttribute(Constants.CHECK_CODE, checkCode);
	//将新生成的验证码存入redis
	//redis.setImageVerificationCode(Constants.CHECK_CODE, checkCode);
	response.setContentType("image/jpeg");
	ImageIO.write(VerifyCode.generateImageCode(checkCode, 90, 30, 5,true,Color.WHITE,Color.BLACK,null),"JPEG",response.getOutputStream());
	
	response.flushBuffer();
	out.clear();
	out = pageContext.pushBody();
%>