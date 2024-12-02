package quanlynhanvien.dao.imple;

import java.util.ArrayList;

import quanlynhanvien.Mapper.AccountMapper;
import quanlynhanvien.bean.Account;
import quanlynhanvien.dao.IAccountDAO;

public class AccountDAO extends AbstractDAO<Account> implements IAccountDAO {
	
	@Override
	public Account findByUsernameAndPassowrd(String username, String password) {
		String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
		ArrayList<Account> account = query(sql, new AccountMapper(), username, password);
		return account==null ? null : account.get(0);
	}

}
	
