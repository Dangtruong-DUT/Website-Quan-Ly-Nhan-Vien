package BachKhoaDaNang.service.imple;

import java.util.ArrayList;

import javax.inject.Inject;

import BachKhoaDaNang.bean.Account;
import BachKhoaDaNang.bean.User;
import BachKhoaDaNang.dao.IAccountDAO;
import BachKhoaDaNang.dao.IUserDAO;
import BachKhoaDaNang.paging.IPageble;
import BachKhoaDaNang.service.IUserService;

public class UserService implements IUserService {
	@Inject 
	private IUserDAO dao;
	@Inject
	private IAccountDAO accountDAO; 
	 
	 
    // Method to get all wives from the database
    public ArrayList<User> getAllEmploy(IPageble value) {
    	return dao.findAll(value);
    }

    // Method to get a specific wife by ID
    public User getEmployeeDetail(String id) {
        return dao.findByEmployeeID(id);
    }

    // Method to add a new wife to the database
    public int addEmployee(User employee) {
        return dao.insert(employee);
    }
    // Method to update a wife in the database
    public int updateEmployee(User employee) {
        return dao.update(employee);
    }

    // Method to delete a wife from the database
    public int deleteEmployees(String[] ids) {
        int count =0;
    	for (String id : ids) {
    		Account account = accountDAO.findByIDNV(id).get(0);
    		accountDAO.delete(account.getUserName());
    		count+=dao.delete(id);
		}
    	return count;
    }


	@Override
	public int getTotalEmployee() {
		return dao.getTotalItem();
	}

	@Override
	public ArrayList<User> getAllEmploywithIDPB(String idpb,IPageble Pageble) {
		// TODO Auto-generated method stub
		return dao.findALLEmployeeByIDPB(idpb,Pageble);
	}

	@Override
	public int getTotalEmployeewithIPB(String idpb) {
		return dao.getTotalEmployeeByIDPB(idpb);
	}
}
