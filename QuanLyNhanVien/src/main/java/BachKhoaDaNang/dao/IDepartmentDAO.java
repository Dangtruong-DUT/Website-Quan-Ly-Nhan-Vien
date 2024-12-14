package BachKhoaDaNang.dao;

import java.util.ArrayList;

import BachKhoaDaNang.bean.Department;
import BachKhoaDaNang.paging.IPageble;

public interface IDepartmentDAO extends IGenericDAO<Department> {
	ArrayList<Department> findAll(IPageble pageble);
	ArrayList<Department> findAll();
	Department findByDepartmentID(String id);
	int delete(String id);
	int update(Department department);
	int insert(Department department);
	public int getTotalItem() ;
}