package quanlynhanvien.dao;

import java.util.ArrayList;

import quanlynhanvien.bean.Employee;
import quanlynhanvien.paging.IPageble;

public interface IEmployeeDAO extends IGenericDAO<Employee> {
	ArrayList<Employee> findAll(IPageble pageble);
	ArrayList<Employee> findALLEmployeeByIDPB(String idpb,IPageble Pageble);
	Employee findByEmployeeID(String id);
	int delete(String id);
	int update(Employee employee);
	int insert(Employee employee);
	public int getTotalItem() ;
	public int getTotalEmployeeByIDPB(String idpb);
}
