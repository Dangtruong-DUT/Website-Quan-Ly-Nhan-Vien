package quanlynhanvien.service;

import java.util.ArrayList;

import quanlynhanvien.bean.Employee;
import quanlynhanvien.paging.IPageble;

public interface IEmployeeService {
	ArrayList<Employee> getAllEmploy(IPageble value);
	ArrayList<Employee> getAllEmploywithIDPB(String idpb,IPageble Pageble);

    // Method to get a specific wife by ID
   Employee getEmployeeDetail(String id);

    // Method to add a new wife to the database
    int addEmployee(Employee employee);
    // Method to update a wife in the database
    int updateEmployee(Employee employee);

    // Method to delete a wife from the database
    int deleteEmployees(String[] ids);
	public int getTotalEmployee();
	public int getTotalEmployeewithIPB(String idpb);
	
}
