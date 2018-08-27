package com.resale.foreground.util;

import java.io.Serializable;

public class ReturnMsgData implements Serializable{

	private static final long serialVersionUID = 5014607822539057104L;
	private String returnCode;// 返回状态码
	private String returnMsg;// 返回状态描述信息
	private Object data;// 返回参数表


	public ReturnMsgData(String returnCode, String returnMsg, Object data) {
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
		this.data = data;
	}

	public ReturnMsgData(String returnCode, String returnMsg) {
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
