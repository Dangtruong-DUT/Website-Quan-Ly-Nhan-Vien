package quanlynhanvien.dao.imple;

import java.util.ArrayList;

import quanlynhanvien.Mapper.EmployeeMapper;
import quanlynhanvien.bean.Employee;
import quanlynhanvien.dao.IEmployeeDAO;
import quanlynhanvien.paging.IPageble;

public class EmployeeDAO extends AbstractDAO<Employee>  implements IEmployeeDAO  {
	
	
	@Override
	public ArrayList<Employee> findAll(IPageble pageble) {
        String sql = "SELECT * FROM nhanvien ";
        if (pageble.getSorter() != null&&pageble.getSorter().getSortName()!=null &&pageble.getSorter().getSortBy()!=null) {
			sql+=" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"";
		}
		if (pageble.getKey()!=null) {
			sql+= String.format(" WHERE %s LIKE ?",pageble.getKey());
			if (pageble.getOffset() != null && pageble.getLimit() != null) {
				sql+=" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+"";
			}
			return query(sql.toString(), new EmployeeMapper(),"%"+pageble.getValue()+"%");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql+=" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+"";
		}
		return query(sql.toString(), new EmployeeMapper());
	}

	@Override
	public Employee findByEmployeeID(String id) {
        String sql = "SELECT * FROM nhanvien WHERE idnv = ?";
		ArrayList<Employee> employees = query(sql, new EmployeeMapper(), id);
		return employees==null? null : employees.get(0);
	}

	@Override
	public int delete(String id) {
        String sql = "DELETE FROM nhanvien WHERE idnv = ?";
        return  executeUpdate(sql,id);
	}

	@Override
	public int update(Employee employee) {
         String sql = "UPDATE nhanvien SET hoten = ?, idpb = ?, diachi = ? WHERE idnv = ?";
         return  executeUpdate(sql,employee.getHoten(),employee.getIdpb(), employee.getDiachi(),employee.getIdnv());
	}

	@Override
	public int insert(Employee employee) {
    	String sql = "INSERT INTO nhanvien (idnv, hoten, idpb, diachi) VALUES (?, ?, ?, ?)";
        return  executeUpdate(sql,employee.getIdnv(),employee.getHoten(),employee.getIdpb(), employee.getDiachi());
	}
	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM nhanvien";
		return count(sql);
	}

	@Override
	public ArrayList<Employee> findALLEmployeeByIDPB(String id,IPageble pageble ) {
		 String sql = "SELECT * FROM nhanvien WHERE idpb = ? ";
		 if (pageble.getSorter() != null&&pageble.getSorter().getSortName()!=null &&pageble.getSorter().getSortBy()!=null) {
				sql+=" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"";
			}
			if (pageble.getOffset() != null && pageble.getLimit() != null) {
				sql+=" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+"";
			}
		return query(sql, new EmployeeMapper(), id);
	}

	@Override
	public int getTotalEmployeeByIDPB(String idpb) {
		String sql = "SELECT count(*) FROM nhanvien WHERE idpb = ?";
		return count(sql, idpb);
	}
}
