package BachKhoaDaNang.dao;

import java.util.ArrayList;


import BachKhoaDaNang.bean.News;
import BachKhoaDaNang.paging.IPageble;

public interface INewDAO extends IGenericDAO<News> {
	News findOne(String id);
	ArrayList<News> findByCategoryId(String categoryId);
	Long save(News newModel);
	void update(News updateNew);
	void delete(String id);
	ArrayList<News> findAll(IPageble pageble);
	ArrayList<News> findAllbyCatergoryId(String catergoryId,IPageble pageble);
	int getTotalItem();
}
