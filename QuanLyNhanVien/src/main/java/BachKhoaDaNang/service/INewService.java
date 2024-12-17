package BachKhoaDaNang.service;

import java.util.ArrayList;

import BachKhoaDaNang.bean.News;
import BachKhoaDaNang.paging.IPageble;

public interface INewService {
	ArrayList<News> findByCategoryId(String categoryId);
	News save(News newModel);
	News update(News updateNew);
	void delete(String[] ids);
	ArrayList<News> findAll(IPageble pageble);
	ArrayList<News> findAllbyCategoryId(String catergoryId,IPageble pageble);
	int getTotalItem();
	News findOne(String id);
}
