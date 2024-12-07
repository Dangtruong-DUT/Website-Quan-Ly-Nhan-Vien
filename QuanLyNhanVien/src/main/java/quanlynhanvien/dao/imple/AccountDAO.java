package quanlynhanvien.dao.imple;

import java.util.ArrayList;

import quanlynhanvien.Mapper.AccountMapper;
import quanlynhanvien.bean.Account;
import quanlynhanvien.bean.Employee;
import quanlynhanvien.dao.IAccountDAO;

public class AccountDAO extends AbstractDAO<Account> implements IAccountDAO {
	
	@Override
	public Account findByUsernameAndPassowrd(String username, String password) {
		String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
		ArrayList<Account> account = query(sql, new AccountMapper(), username, password);
		return account==null ? null : account.get(0);
	}
	
	@Override
	public int update(Account account) {
         String sql = "UPDATE account SET password = ? WHERE username = ?";
         return  executeUpdate(sql, account.getPassWord(), account.getUserName());
	}
	
	@Override
	public int delete(String username) {
        String sql = "DELETE FROM account WHERE username = ?";
        return  executeUpdate(sql, username);
	}

	@Override
	public int insert(Account account) {
    	String sql = "INSERT INTO account (username, password, idNV, role) VALUES (?, ?, ?, ?)";
        return  executeUpdate(sql, account.getUserName(), account.getPassWord(),
        		account.getIdNV(), account.getRole().getCode());
	}

}
	
