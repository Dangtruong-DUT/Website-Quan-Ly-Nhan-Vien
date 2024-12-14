package BachKhoaDaNang.sorter;

public class Sorter {
	private String sortName;
	private String sortBy;
	public String getSortName() {
		return sortName;
	}
	public Sorter(String sortName, String sortBy) {
		this.sortName = sortName;
		this.sortBy = sortBy;
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
	
}
