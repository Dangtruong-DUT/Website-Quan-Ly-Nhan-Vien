package BachKhoaDaNang.Mapper;

import java.sql.ResultSet;

/*
 * 
 * interface mapping cac row tuong ung voi tung record trong
 * table tra ve tu resultset
 * 
 * */
public interface IRowMapper<T> {
	T mapRow(ResultSet resultSet);
}
