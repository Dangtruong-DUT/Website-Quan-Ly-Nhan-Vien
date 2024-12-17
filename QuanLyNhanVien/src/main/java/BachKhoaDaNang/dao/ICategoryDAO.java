package BachKhoaDaNang.dao;

import java.util.ArrayList;

import BachKhoaDaNang.bean.Category;


public interface ICategoryDAO extends IGenericDAO<Category> {
	ArrayList<Category> findAll();
	Category findOne(String id);
}
