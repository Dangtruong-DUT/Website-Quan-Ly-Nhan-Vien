package BachKhoaDaNang.service.imple;


import java.util.ArrayList;

import javax.inject.Inject;

import BachKhoaDaNang.bean.Account;
import BachKhoaDaNang.dao.IAccountDAO;
import BachKhoaDaNang.paging.IPageble;
import BachKhoaDaNang.service.IAccountService;


public class AccountService implements IAccountService {
	@Inject
	private IAccountDAO dao;
	
	public Account findAccountByUserNameAndPassword(String userName, String passWord){
		return dao.findByUsernameAndPassowrd(userName, passWord);
	}
	@Override
    public int addAccount(Account account) {
        return dao.insert(account);
    }
    @Override
	public int update(Account account) {
         return dao.update(account);
	}
	@Override
	public int delete(String username) {
        return  dao.delete(username);
	}
	@Override
	public int insert(Account account) {
        return  dao.insert(account);
	}

	@Override
	public int getTotalAccount() {
		return dao.getTotalItem();
	}
	@Override
	public ArrayList<Account> findAllAccount(IPageble Pageble) {
		return dao.findAll(Pageble);
	}
	@Override
	public Account findAccountByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Account> findAccountByIDNV(String idnv) {
		return dao.findByIDNV(idnv);
	}
	

}
