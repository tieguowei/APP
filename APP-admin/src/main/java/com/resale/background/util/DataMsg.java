
package com.resale.background.util;

import java.util.List;


/**
 *  响应给前台的数据、消息封装
 *
 */
public class DataMsg {
	
	//总记录数
	private Long total;
	
	//结果集
	private List rows;

    /**
     * 信息提示代码
     * {@link property/message_code.properties}
     */
	private String messageCode;
	
	//请求状态
	private String requestState;
	
	//是否重复
	private String isRepeat;
	
	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getRequestState() {
		return requestState;
	}

	public void setRequestState(String requestState) {
		this.requestState = requestState;
	}

	public String getIsRepeat() {
		return isRepeat;
	}

	public void setIsRepeat(String isRepeat) {
		this.isRepeat = isRepeat;
	}
}
