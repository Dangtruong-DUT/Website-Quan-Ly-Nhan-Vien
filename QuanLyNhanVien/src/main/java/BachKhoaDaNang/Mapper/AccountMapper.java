package BachKhoaDaNang.Mapper;

import java.sql.ResultSet;

import BachKhoaDaNang.bean.Account;

public class AccountMapper implements IRowMapper<Account> {
	@Override
	public Account mapRow(ResultSet resultSet) {
    	try {
    		Account account= new Account();
    		account.setUserName(resultSet.getString("username"));
    		account.setPassWord(resultSet.getString("password"));
    		account.setIdNV(resultSet.getString("idNV"));
    		account.setRole(resultSet.getString("role"));
    		return account;
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
    	return null;
    	
	}
    	
}
