package quanlynhanvien.service.imple;


import javax.inject.Inject;

import quanlynhanvien.bean.Account;
import quanlynhanvien.bean.Employee;
import quanlynhanvien.dao.IAccountDAO;
import quanlynhanvien.service.IAccountService;


public class AccountService implements IAccountService {
	@Inject
	private IAccountDAO dao;
	
	public Account findAccountByUserNameAndPassword(String userName, String passWord){
		return dao.findByUsernameAndPassowrd(userName, passWord);
	}
	
    public int addAccount(Account account) {
        return dao.insert(account);
    }

	public int update(Account account) {
         return dao.update(account);
	}
	
	public int delete(String username) {
        String sql = "DELETE FROM account WHERE username = ?";
        return  dao.executeUpdate(sql, username);
	}

	public int insert(Account account) {
    	String sql = "INSERT INTO account (username, password, idNV, role) VALUES (?, ?, ?, ?)";
        return  dao.executeUpdate(sql, account.getUserName(), account.getPassWord(),
        		account.getIdNV(), account.getRole().getCode());
	}

}
