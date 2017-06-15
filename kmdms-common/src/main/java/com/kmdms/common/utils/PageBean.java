package com.kmdms.common.utils;

import java.util.List;

public class PageBean<T> {
	
	private int pageCode;//当前页码
	private int totalPage;//总页数
	private int totalRecord;//总记录数
	private int pageRecord;//每页记录数
	private int pagePosition;//当前记录数
	private List<T> beanList;//当前页记录
	
	private T condition;//方便条件查询
	
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPagePosition() {
		return pagePosition;
	}
//	public void setPagePosition(int pagePosition) {
//		this.pagePosition = pagePosition;
//	}
	public void setPagePosition(String pageRecord, String pageCode ) {
		pageCode = pageCode == null ? "1" : pageCode;
		this.pagePosition = Integer.parseInt(pageRecord) * (Integer.parseInt(pageCode) - 1);
	}
	public T getCondition() {
		return condition;
	}
	public void setCondition(T condition) {
		this.condition = condition;
	}
	public int getPageCode() {
		return pageCode;
	}
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	public void setPageCode(String pageCode) {
		this.pageCode = pageCode != null && !"".equals(pageCode) ? Integer.parseInt(pageCode) : 1;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(String pageRecord,int totalRecord) {
		int pr = Integer.parseInt(pageRecord);
		this.totalPage = totalRecord % pr == 0 ? totalRecord/pr : totalRecord/pr + 1;
	}
	public void setTotalPage(int pageRecord,int totalRecord) {
		this.totalPage = totalRecord % pageRecord == 0 ? totalRecord/pageRecord : totalRecord/pageRecord + 1;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getPageRecord() {
		return pageRecord;
	}
	public void setPageRecord(int pageRecord) {
		this.pageRecord = pageRecord;
	}
	public void setPageRecord(String pageRecord) {
		this.pageRecord = Integer.parseInt(pageRecord);
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	
}

