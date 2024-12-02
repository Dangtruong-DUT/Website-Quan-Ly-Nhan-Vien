package quanlynhanvien.dao;

import java.util.ArrayList;

import quanlynhanvien.bean.Department;
import quanlynhanvien.paging.IPageble;

public interface IDepartmentDAO extends IGenericDAO<Department> {
	ArrayList<Department> findAll(IPageble pageble);
	ArrayList<Department> findAll();
	Department findByDepartmentID(String id);
	int delete(String id);
	int update(Department department);
	int insert(Department department);
	public int getTotalItem() ;
}