package com.resale.foreground.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.resale.foreground.service.TestService;

@Controller
@RequestMapping("/login")
public class TestController {
	@Autowired
	private TestService testService;
	
	
	/**
	 * 获取菜单
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/test")
	@ResponseBody
	public int getMenuByUserId(){
		int count = testService.getCount();
		return count;
	}
	
	
	
}
