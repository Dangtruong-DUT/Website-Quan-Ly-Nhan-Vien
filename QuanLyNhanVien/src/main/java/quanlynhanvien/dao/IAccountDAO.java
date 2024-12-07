package quanlynhanvien.dao;

import quanlynhanvien.bean.Account;

public interface IAccountDAO extends IGenericDAO <Account>{
	public Account findByUsernameAndPassowrd(String username, String password);
	int update(Account account);
	int delete(String username);
	int insert(Account account);
}
