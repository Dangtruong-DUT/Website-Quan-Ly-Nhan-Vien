package quanlynhanvien.service;

import quanlynhanvien.bean.Account;

public interface IAccountService {
	public Account findAccountByUserNameAndPassword(String userName, String passWord) ;
}
