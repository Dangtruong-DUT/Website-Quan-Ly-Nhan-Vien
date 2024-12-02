package quanlynhanvien.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import quanlynhanvien.bean.Department;

public class DepartmentMapper implements IRowMapper<Department> {

	@Override
	public Department mapRow(ResultSet resultSet) {
		try {
    		Department department = new Department();
    		department.setIdpb(resultSet.getString("idpb"));
    		department.setTenpb(resultSet.getString("tenpb"));
    		department.setMota(resultSet.getString("mota"));
	    	return department;
    	} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
