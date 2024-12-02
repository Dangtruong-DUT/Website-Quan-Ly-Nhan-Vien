package quanlynhanvien.service.imple;


import javax.inject.Inject;

import quanlynhanvien.bean.Account;
import quanlynhanvien.dao.IAccountDAO;
import quanlynhanvien.service.IAccountService;


public class AccountService implements IAccountService {
	@Inject
	private IAccountDAO dao;
	
	public Account findAccountByUserNameAndPassword(String userName, String passWord){
		return dao.findByUsernameAndPassowrd(userName, passWord);
	}
}
