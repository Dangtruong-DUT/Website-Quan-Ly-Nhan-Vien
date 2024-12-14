package BachKhoaDaNang.service;

import java.util.ArrayList;

import BachKhoaDaNang.bean.Account;
import BachKhoaDaNang.paging.IPageble;

public interface IAccountService {
	public Account findAccountByUserNameAndPassword(String userName, String passWord) ;
	int update(Account account);
	int delete(String username);
	int insert(Account account);
	public int addAccount(Account account);
	int getTotalAccount();
	public ArrayList<Account> findAllAccount(IPageble Pageble);
	Account findAccountByUserName(String userName);
	ArrayList<Account> findAccountByIDNV(String idnv);
	
}
