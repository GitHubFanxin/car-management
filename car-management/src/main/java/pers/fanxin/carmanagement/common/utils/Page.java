package pers.fanxin.carmanagement.common.utils;

import java.util.List;

public class Page {
	private long total;
	private List<Object> rows;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<Object> getRows() {
		return rows;
	}

	public void setRows(List<Object> rows) {
		this.rows = rows;
	}
}
