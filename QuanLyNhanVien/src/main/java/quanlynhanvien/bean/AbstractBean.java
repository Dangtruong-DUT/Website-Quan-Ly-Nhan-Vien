package quanlynhanvien.bean;

import java.util.ArrayList;

public class AbstractBean<E> {
	
	private ArrayList<E> listResult = new ArrayList<>();
	private String[] ids;
	private Integer page;
	private Integer maxPageItem=10;
	private Integer totalPage;
	private Integer totalItem;
	private String sortName;
	private String sortBy;
	private String type;

	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	
	public ArrayList<E> getlistResult() {
		return listResult;
	}

	public void setlistResult(ArrayList<E> list) {
		this.listResult = list;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getMaxPageItem() {
		return maxPageItem;
	}
	public void setMaxPageItem(Integer maxPageItem) {
		this.maxPageItem = maxPageItem;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
