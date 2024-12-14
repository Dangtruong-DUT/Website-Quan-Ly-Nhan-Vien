package BachKhoaDaNang.dao.imple;

import java.util.ArrayList;

import BachKhoaDaNang.Mapper.AccountMapper;
import BachKhoaDaNang.bean.Account;
import BachKhoaDaNang.dao.IAccountDAO;
import BachKhoaDaNang.paging.IPageble;

public class AccountDAO extends AbstractDAO<Account> implements IAccountDAO {
	
	@Override
	public Account findByUsernameAndPassowrd(String username, String password) {
		String sql = "SELECT * FROM account WHERE username = ? AND password = ?";
		ArrayList<Account> account = query(sql, new AccountMapper(), username, password);
		return ((account==null) || account.isEmpty())? null : account.get(0);
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
        		account.getIdNV(), account.getRole());
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM account";
		return count(sql);
	}

	@Override
	public ArrayList<Account> findAll(IPageble pageble) {
        String sql = "SELECT * FROM account ";
        if (pageble.getSorter() != null&&pageble.getSorter().getSortName()!=null &&pageble.getSorter().getSortBy()!=null) {
			sql+=" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"";
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql+=" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+"";
		}
		return query(sql.toString(), new AccountMapper());
	}

	@Override
	public Account findByUsername(String username) {
		String sql = "SELECT * FROM account WHERE username = ?";
		ArrayList<Account> account = query(sql, new AccountMapper(), username);
		return account==null ? null : account.get(0);
	}

	@Override
	public ArrayList<Account> findByIDNV(String idnv) {
		String sql = "SELECT * FROM account WHERE idNV = ?";
		ArrayList<Account> account = query(sql, new AccountMapper(), idnv);
		return account;
	}

}
	
