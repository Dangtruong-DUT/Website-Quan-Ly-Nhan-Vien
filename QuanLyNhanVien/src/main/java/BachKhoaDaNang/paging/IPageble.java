package BachKhoaDaNang.paging;

import BachKhoaDaNang.sorter.Sorter;

public interface IPageble {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
	String getKey();
	String getValue();
}
