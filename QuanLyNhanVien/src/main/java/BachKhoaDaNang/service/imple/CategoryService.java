package BachKhoaDaNang.service.imple;

import java.util.ArrayList;

import javax.inject.Inject;

import BachKhoaDaNang.bean.Category;
import BachKhoaDaNang.dao.ICategoryDAO;
import BachKhoaDaNang.service.ICategoryService;


public class CategoryService implements ICategoryService {
	
	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public ArrayList<Category> findAll() {
		return categoryDao.findAll();
	}
}
