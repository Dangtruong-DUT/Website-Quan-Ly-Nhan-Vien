package BachKhoaDaNang.dao;

import java.util.ArrayList;

import BachKhoaDaNang.bean.Account;
import BachKhoaDaNang.paging.IPageble;

public interface IAccountDAO extends IGenericDAO <Account>{
	public Account findByUsernameAndPassowrd(String username, String password);
	public Account findByUsername(String username);
	public ArrayList<Account> findByIDNV(String idnv);
	public int getTotalItem() ;
	ArrayList<Account> findAll(IPageble pageble);
	int update(Account account);
	int delete(String username);
	int insert(Account account);
	
}
