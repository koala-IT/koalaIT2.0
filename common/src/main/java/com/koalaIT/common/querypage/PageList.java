package com.koalaIT.common.querypage;

import java.util.List;
import java.util.Map;

public class PageList<T> {
	public static final Integer MAX_PAGE_SIZE = 10000;
	private int pageNumber = 1;
	private int pageSize = 12;
	private String searchBy;
	private String keyword;
	private String orderBy;
	private OrderEnum order;
	private int pageCount;
	private Map<String, Object> parameterMap;

	private List<T> result;

	public int getPageCount() {
		int i = this.pageCount / this.pageSize;
		if (this.pageCount % this.pageSize > 0)
			i++;
		return i;
	}

	public void setPageCount(Integer tItem) {
		if (tItem == null) {
			tItem = new Integer(0);
		}
		this.pageCount = tItem;
		int current = getPageNumber();
		int lastPage = getTotalPage();
		if (current > lastPage)
			setPageNumber(new Integer(lastPage));
	}

	public int getTotalPage() {
		int pgSize = getPageSize();
		int total = getPageCount();
		int result = total / pgSize;
		if (total % pgSize != 0) {
			result++;
		}
		return result;
	}

	public int getPageNumber() {
		return this.pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		if (pageNumber < 1)
			pageNumber = 1;
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize < 1)
			pageSize = 1;
		else if (pageSize > MAX_PAGE_SIZE)
			pageSize = MAX_PAGE_SIZE;
		this.pageSize = pageSize;
	}

	public String getSearchBy() {
		return this.searchBy;
	}

	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Map<String, Object> getParameterMap() {
		return this.parameterMap;
	}

	public void setParameterMap(Map<String, Object> parameterMap) {
		this.parameterMap = parameterMap;
	}

	public String getOrderBy() {
		return this.orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public OrderEnum getOrder() {
		return this.order;
	}

	public void setOrder(OrderEnum order) {
		this.order = order;
	}

	public int getTotalCount() {
		return this.pageCount;
	}

	public void setTotalCount(int totalCount) {
		this.pageCount = totalCount;
	}

	public List<T> getResult() {
		return this.result;
	}

	public void setResult(List<T> paramList) {
		this.result = paramList;
	}
}
