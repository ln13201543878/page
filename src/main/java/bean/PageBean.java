package bean;

import java.util.List;

public class PageBean<T> {
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	private int p; // 当前页数
	private int rowCount; // 总行数
	private int maxPage; // 总页数
	private int prev; // 上一页
	private int next; // 下一页
	private int startLine; // 起始行
	private int size; // 每页显示行数
	private int startPage; // 起始页
	private int endPage; // 结束页
	private List<T> list; // 分页数据

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getPrev() {
		return prev;
	}

	public void setPrev(int prev) {
		this.prev = prev;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getStartLine() {
		return startLine;
	}

	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public PageBean(int p, int rowCount, int maxPage, int prev, int next, int startLine, int size, int startPage,
			int endPage, List<T> list) {
		super();
		this.p = p;
		this.rowCount = rowCount;
		this.maxPage = maxPage;
		this.prev = prev;
		this.next = next;
		this.startLine = startLine;
		this.size = size;
		this.startPage = startPage;
		this.endPage = endPage;
		this.list = list;
	}

	public PageBean(int pg, int rc, int sz) {
		p = pg;
		rowCount = rc;
		size = sz;
		maxPage = (int) Math.ceil(rowCount * 1.0 / size);
		// 利用总页数，把当前页数限定在范围内
		if (p > maxPage)
			p = maxPage;
		if (p < 1)
			p = 1;
		// 流程走到这里，当前页数肯定是有效的，再根据当前页数去推上一页，下一页
		prev = p - 1;
		next = p + 1;

		/*
		 * SELECT * FROM USER LIMIT (1-1)*5,5 SELECT * FROM USER LIMIT (2-1)*5,5 SELECT
		 * * FROM USER LIMIT (3-1)*5,5 SELECT * FROM USER LIMIT (4-1)*5,5 SELECT * FROM
		 * USER LIMIT (5-1)*5,5
		 * 
		 * SELECT * FROM USER LIMIT (p-1)*size,size
		 */
		startLine = (p - 1) * size;
		if (maxPage < 10) {
			startPage = 1;
			endPage = maxPage;
		} else {
			startPage = p - 5;
			endPage = p + 4;
			if (startPage < 1) {
				startPage = 1;
				endPage = 10;
			}
			if (endPage > maxPage) {
				endPage = maxPage;
				startPage = maxPage - 9;
			}
		}
	}

	@Override
	public String toString() {
		return "PageBean [p=" + p + ", rowCount=" + rowCount + ", maxPage=" + maxPage + ", prev=" + prev + ", next="
				+ next + ", startLine=" + startLine + ", size=" + size + ", startPage=" + startPage + ", endPage="
				+ endPage + ", list=" + list + "]";
	}

}
