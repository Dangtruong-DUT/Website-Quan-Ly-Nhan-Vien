package quanlynhanvien.service.imple;

import java.util.ArrayList;

import javax.inject.Inject;

import quanlynhanvien.bean.Employee;
import quanlynhanvien.dao.IEmployeeDAO;
import quanlynhanvien.paging.IPageble;
import quanlynhanvien.service.IEmployeeService;
/*
 * 
 * xử lý nghiệp vụ BO triển khai gọi các hàm từ DAO thông
 * qua interface và thư viên weld servlet qua anotation 
 * Inject
 * 
 * */

public class EmployeeService implements IEmployeeService {
	@Inject 
	private IEmployeeDAO dao;
	 
	 
    // Method to get all wives from the database
    public ArrayList<Employee> getAllEmploy(IPageble value) {
    	return dao.findAll(value);
    }

    // Method to get a specific wife by ID
    public Employee getEmployeeDetail(String id) {
        return dao.findByEmployeeID(id);
    }

    // Method to add a new wife to the database
    public int addEmployee(Employee employee) {
        return dao.insert(employee);
    }
    // Method to update a wife in the database
    public int updateEmployee(Employee employee) {
        return dao.update(employee);
    }

    // Method to delete a wife from the database
    public int deleteEmployees(String[] ids) {
        int count =0;
    	for (String id : ids) {
    		count+=dao.delete(id);
		}
    	return count;
    }


	@Override
	public int getTotalEmployee() {
		return dao.getTotalItem();
	}

	@Override
	public ArrayList<Employee> getAllEmploywithIDPB(String idpb,IPageble Pageble) {
		// TODO Auto-generated method stub
		return dao.findALLEmployeeByIDPB(idpb,Pageble);
	}

	@Override
	public int getTotalEmployeewithIPB(String idpb) {
		return dao.getTotalEmployeeByIDPB(idpb);
	}
}
