package quanlynhanvien.service;

import java.util.ArrayList;

import quanlynhanvien.bean.Department;
import quanlynhanvien.paging.IPageble;

public interface IDepartmentService  {
	ArrayList<Department> getAllDepartment(IPageble value);
	ArrayList<Department> getAllDepartment();

    // Method to get a specific wife by ID
   Department getDepartmentDetail(String id);

	public int getTotalDepartment();
	
	 // Method to add a new wife to the database
    int addDepartment(Department department);
    // Method to update a wife in the database
    int updateDepartment(Department department);

}
