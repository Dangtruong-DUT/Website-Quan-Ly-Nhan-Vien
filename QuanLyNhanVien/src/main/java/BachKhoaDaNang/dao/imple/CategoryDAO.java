package BachKhoaDaNang.dao.imple;

import java.util.ArrayList;

import BachKhoaDaNang.Mapper.CategoryMapper;
import BachKhoaDaNang.bean.Category;
import BachKhoaDaNang.dao.ICategoryDAO;


public class CategoryDAO extends AbstractDAO<Category> implements ICategoryDAO {

	@Override
	public ArrayList<Category> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

	@Override
	public Category findOne(String id) {
		String sql = "SELECT * FROM category WHERE id = ?";
		ArrayList<Category> category = query(sql, new CategoryMapper(), id);
		return category.isEmpty() ? null : category.get(0);
	}

}
