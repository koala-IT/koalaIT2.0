package com.koalaIT.common.querypage;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

public class QueryBase implements Serializable {
	private static final long serialVersionUID = 7603300820027561064L;
	private static final Integer defaultPageSize = new Integer(15);

	private static final Integer defaultFriatPage = new Integer(1);
	private static final Integer defaultTotleItem = new Integer(0);
	private Integer pageCount;
	private Integer pageSize;
	private Integer pageNumber;
	private Integer startRow;
	protected final Integer getDefaultPageSize() {
		return defaultPageSize;
	}

	public boolean isFirstPage() {
		return getPageNumber().intValue() == 1;
	}

	public int getPreviousPage() {
		int back = getPageNumber().intValue() - 1;
		if (back <= 0) {
			back = 1;
		}
		return back;
	}

	public boolean isLastPage() {
		return getTotalPage() == getPageNumber().intValue();
	}

	public int getNextPage() {
		int back = getPageNumber().intValue() + 1;
		if (back > getTotalPage()) {
			back = getTotalPage();
		}
		return back;
	}

	public Integer getPageNumber() {
		if (this.pageNumber == null) {
			return defaultFriatPage;
		}
		return this.pageNumber;
	}

	public void setPageNumber(Integer cPage) {
		if ((cPage == null) || (cPage.intValue() <= 0))
			this.pageNumber = defaultFriatPage;
		else
			this.pageNumber = cPage;
	}

	public void setPageNumberString(String s) {
		if (StringUtils.isBlank(s))
			return;
		try {
			setPageNumber(Integer.valueOf(Integer.parseInt(s)));
		} catch (NumberFormatException ignore) {
			setPageNumber(defaultFriatPage);
		}
	}

	public Integer getPageSize() {
		if (this.pageSize == null) {
			return getDefaultPageSize();
		}

		return this.pageSize;
	}

	public boolean hasSetPageSize() {
		return this.pageSize != null;
	}

	public void setPageSize(Integer pSize) {
		if (pSize == null) {
			throw new IllegalArgumentException("PageSize can't be null.");
		}

		if (pSize.intValue() <= 0) {
			throw new IllegalArgumentException("PageSize must great than zero.");
		}

		this.pageSize = pSize;
	}

	public void setPageSizeString(String pageSizeString) {
		if (StringUtils.isBlank(pageSizeString)) {
			return;
		}
		try {
			Integer integer = new Integer(pageSizeString);
			setPageSize(integer);
		} catch (NumberFormatException localNumberFormatException) {
		}
	}

	public Integer getPageCount() {
		if (this.pageCount == null) {
			return defaultTotleItem;
		}
		return this.pageCount;
	}

	public void setPageCount(Integer tItem) {
		if (tItem == null) {
			tItem = new Integer(0);
		}
		this.pageCount = tItem;
		int current = getPageNumber().intValue();
		int lastPage = getTotalPage();
		if (current > lastPage)
			setPageNumber(new Integer(lastPage));
	}

	public int getTotalPage() {
		int pgSize = getPageSize().intValue();
		int total = getPageCount().intValue();
		int result = total / pgSize;
		if (total % pgSize != 0) {
			result++;
		}
		return result;
	}

	public int getPageFristItem() {
		int cPage = getPageNumber().intValue();
		if (cPage == 1) {
			return 1;
		}
		cPage--;
		int pgSize = getPageSize().intValue();

		return pgSize * cPage + 1;
	}

	public int getMysqlPageFristItem() {
		return getPageFristItem() - 1;
	}

	public int getPageLastItem() {
		int assumeLast = getExpectPageLastItem();
		int pageCount = getPageCount().intValue();

		if (assumeLast > pageCount) {
			return pageCount;
		}
		return assumeLast;
	}

	public int getExpectPageLastItem() {
		int cPage = getPageNumber().intValue();
		int pgSize = getPageSize().intValue();
		return pgSize * cPage;
	}

	public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

}
