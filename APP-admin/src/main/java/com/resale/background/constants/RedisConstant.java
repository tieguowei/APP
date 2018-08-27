package com.resale.background.constants;

public class RedisConstant {

	public static final int REDIS_TOKEN_BACKGROUND_LOGIN = 60;//redis中存储后台登录token的时间(60s)
	public static final String  USER_TOKEN = "USERTOKEN";//redis中存储用户token的前缀
	public static final int REDIS_TOKEN_DELAY = 60*60*24*30;//redis中存储token的时间(30天)
	

}
