package BachKhoaDaNang.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import BachKhoaDaNang.bean.News;

public class NewMapper implements IRowMapper<News> {

	@Override
	public News mapRow(ResultSet resultSet) {
		try {
			News news = new News();
			news.setId(resultSet.getString("id"));;
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setCategoryId(resultSet.getString("categoryid"));
			news.setThumbnail(resultSet.getBytes("thumbnail"));
			news.setShortDescription(resultSet.getString("shortdescription"));
			news.setCreatedDate(resultSet.getTimestamp("createddate"));
			news.setCreatedBy(resultSet.getString("createdby"));
			if (resultSet.getTimestamp("modifieddate") != null) {
				news.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if (resultSet.getString("modifiedby") != null) {
				news.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}
}
