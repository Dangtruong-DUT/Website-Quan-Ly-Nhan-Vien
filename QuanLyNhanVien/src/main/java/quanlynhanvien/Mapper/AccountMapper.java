package quanlynhanvien.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import quanlynhanvien.bean.Account;
import quanlynhanvien.bean.Role;

public class AccountMapper implements IRowMapper<Account> {
	@Override
	public Account mapRow(ResultSet resultSet) {
    	try {
    		Account account= new Account();
    		account.setUserName(resultSet.getString("username"));
    		account.setPassWord(resultSet.getString("password"));
    		try {
				Role role = new Role();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				account.setRole(role);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
    		return account;
    	} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
    	
}
