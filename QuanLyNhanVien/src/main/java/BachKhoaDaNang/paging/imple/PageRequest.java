package BachKhoaDaNang.paging.imple;

import BachKhoaDaNang.paging.IPageble;
import BachKhoaDaNang.sorter.Sorter;

public class PageRequest implements IPageble{
	private Integer page;
	private Integer maxPageItem;
	private Sorter sorter;
	private String key;
	private String value;
	
	public PageRequest(Integer page ,Integer maxPageItem, Sorter sorter) {
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.setSorter(sorter);
	}
	public PageRequest(Integer page,Integer maxPageItem,String key,String value, Sorter sorter) {
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.setSorter(sorter);
		this.key= key;
		this.value = value;
	}
	@Override
	public Integer getPage() {
		return page;
	}

	@Override
	public Integer getOffset() {
		if (this.page== null || this.maxPageItem == null) return null;
		Integer offset = (this.page-1)*this.maxPageItem;
		return offset;
	}

	@Override
	public Integer getLimit() {
		return maxPageItem;
	}
	@Override
	public Sorter getSorter() {
		return this.sorter;
	}
	public void setSorter(Sorter sorter) {
		this.sorter = sorter;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
