package com.resale.foreground.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resale.foreground.mapper.TestMapper;
import com.resale.foreground.service.TestService;
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestMapper TestMapper;
	
	protected final Log logger = LogFactory.getLog(getClass());
	

	@Override
	public int getCount() {
		return TestMapper.getCount();
	}

}
