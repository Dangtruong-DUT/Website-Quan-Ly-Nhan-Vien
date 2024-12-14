package BachKhoaDaNang.service;

import java.util.ArrayList;

import BachKhoaDaNang.bean.User;
import BachKhoaDaNang.paging.IPageble;

public interface IUserService {
	ArrayList<User> getAllEmploy(IPageble value);
	ArrayList<User> getAllEmploywithIDPB(String idpb,IPageble Pageble);

    // Method to get a specific wife by ID
   User getEmployeeDetail(String id);

    // Method to add a new wife to the database
    int addEmployee(User employee);
    // Method to update a wife in the database
    int updateEmployee(User employee);

    // Method to delete a wife from the database
    int deleteEmployees(String[] ids);
	public int getTotalEmployee();
	public int getTotalEmployeewithIPB(String idpb);

}
