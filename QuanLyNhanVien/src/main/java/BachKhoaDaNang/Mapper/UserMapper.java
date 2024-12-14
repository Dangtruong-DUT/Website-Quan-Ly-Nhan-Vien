package BachKhoaDaNang.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import BachKhoaDaNang.bean.User;

public class UserMapper implements IRowMapper<User>{

	@Override
	public User mapRow(ResultSet resultSet) {
    	try {
    		User employee = new User();
			employee.setIdnv(resultSet.getString("idnv"));
			employee.setHoten(resultSet.getString("tenNV"));
	    	employee.setIdpb(resultSet.getString("idpb"));
	    	employee.setDiachi(resultSet.getString("diachi"));
	    	employee.setSoDienThoai(resultSet.getString("soDienThoai"));
	    	employee.setNgaySinh(resultSet.getDate("ngaySinh"));
	    	return employee;
    	} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    	
	}

}
