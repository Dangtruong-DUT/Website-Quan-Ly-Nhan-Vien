package BachKhoaDaNang.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import BachKhoaDaNang.bean.Category;


public class CategoryMapper implements IRowMapper<Category> {

	@Override
	public Category mapRow(ResultSet resultSet) {
		try {
			Category category = new Category();
			category.setId(resultSet.getString("id"));
			category.setName(resultSet.getString("name"));
			return category;
		} catch (SQLException e) {
			return null;
		}
	}
}
