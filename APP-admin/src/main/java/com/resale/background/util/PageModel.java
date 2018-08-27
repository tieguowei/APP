package com.resale.background.util;

import java.util.List;

/**
 * 
 *
 * Description: 分页组件
 *
 */
public class PageModel {
	
	//总记录数
	private Long totalRecords;
	
	//结果集
	private List list;
	
	//当前页
	private int pageNo;
	
    //每页显示多少条
	private int pageSize; 
	
	public Long getTotalRecords() {
		return totalRecords;
	}
	
	/**
	 * 取得总页数
	 * @return
	 */
	public int getTotalPages() {
		return (totalRecords.intValue() + pageSize - 1) / pageSize;
	}
	
	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * 取得第一页
	 * @return
	 */
	public int getTopPageNo() {
		return 1;
	}
	
	/**
	 * 取得上一页
	 * @return
	 */
	public int getPreviousPageNo() {
		if (pageNo <= 1) {
			return 1;
		}
		return pageNo -1;
	}
	
	/**
	 * 取得下一页
	 * @return
	 */
	public int getNextPageNo() {
		if (pageNo >= getTotalPages()) {
			return getTotalPages()==0?1:getTotalPages();
		}
		return pageNo + 1;
	}
	
	/**
	 * 取得最后一页
	 * @return
	 */
	public int getBottomPageNo() {
		return getTotalPages() == 0?1:getTotalPages();
	}
	
	/**
	 * 
	 * Description: 每一页的起始索引
	 *
	 * @param 
	 * @return int
	 * @throws Exception if has error
	 * @Author daweiyao
	 * Create Date: 2012-9-14 下午06:11:25
	 */
	public int getStartIndex() {
		if(pageNo <= 0){
			pageNo = 1;
		}
		return (pageNo - 1) * pageSize; 
	}
	
	/**
	 * 
	 * Description: 每一页的结束索引
	 *
	 * @param 
	 * @return int
	 * @throws Exception if has error
	 * @Author daweiyao
	 * Create Date: 2012-9-14 下午06:11:34
	 */
	public int getEndIndex() {
		return (pageNo - 1) * pageSize + pageSize;
	}
}
