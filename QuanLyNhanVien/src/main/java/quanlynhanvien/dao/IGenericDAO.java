package quanlynhanvien.dao;

import java.util.ArrayList;

import quanlynhanvien.Mapper.IRowMapper;
import quanlynhanvien.bean.Account;

/*
 * Noi chua cac ham chung nhat lam viec 
 * voi Database
 * query thực hiện câu lệnh select
 * count thực hiện câu lệnh update, delete, insert 
 * */
public interface IGenericDAO<T> {
	@SuppressWarnings("hiding")
	<T>ArrayList<T> query(String sql, IRowMapper<T> rowMapper,Object... parameter);
	int count (String sql, Object... parameters);
	int executeUpdate (String sql, Object... parameters);
}
