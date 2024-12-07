package quanlynhanvien.service;

import quanlynhanvien.bean.Account;

public interface IAccountService {
	public Account findAccountByUserNameAndPassword(String userName, String passWord) ;
	int update(Account account);
	int delete(String username);
	int insert(Account account);
}
