package quanlynhanvien.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import quanlynhanvien.bean.Employee;

public class EmployeeMapper implements IRowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet resultSet) {
    	try {
    		Employee employee = new Employee();
			employee.setIdnv(resultSet.getString("idnv"));
			employee.setHoten(resultSet.getString("hoten"));
	    	employee.setIdpb(resultSet.getString("idpb"));
	    	employee.setDiachi(resultSet.getString("diachi"));
	    	return employee;
    	} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    	
	}

}
