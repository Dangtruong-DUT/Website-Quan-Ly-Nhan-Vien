package BachKhoaDaNang.dao.imple;

import java.util.ArrayList;

import BachKhoaDaNang.Mapper.UserMapper;
import BachKhoaDaNang.bean.User;
import BachKhoaDaNang.dao.IUserDAO;
import BachKhoaDaNang.paging.IPageble;

public class UserDAO extends AbstractDAO<User>  implements IUserDAO  {
	
	
	@Override
	public ArrayList<User> findAll(IPageble pageble) {
        String sql = "SELECT * FROM employee ";
        if (pageble.getSorter() != null&&pageble.getSorter().getSortName()!=null &&pageble.getSorter().getSortBy()!=null) {
			sql+=" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"";
		}
		if (pageble.getKey()!=null) {
			sql+= String.format(" WHERE %s LIKE ?",pageble.getKey());
			if (pageble.getOffset() != null && pageble.getLimit() != null) {
				sql+=" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+"";
			}
			return query(sql.toString(), new UserMapper(),"%"+pageble.getValue()+"%");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql+=" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+"";
		}
		return query(sql.toString(), new UserMapper());
	}

	@Override
	public User findByEmployeeID(String id) {
        String sql = "SELECT * FROM employee WHERE idNV = ?";
		ArrayList<User> employees = query(sql, new UserMapper(), id);
		return employees==null? null : employees.get(0);
	}

	@Override
	public int delete(String id) {
        String sql = "DELETE FROM employee WHERE idNV = ?";
        return  executeUpdate(sql,id);
	}

	@Override
	public int update(User employee) {
         String sql = "UPDATE employee SET tenNV = ?, idpb = ?, diachi = ?, ngaySinh =?, soDienThoai=? WHERE idNV = ?";
         return  executeUpdate(sql,employee.getHoten(),employee.getIdpb(), employee.getDiachi(),employee.getNgaySinh(),employee.getSoDienThoai(),employee.getIdnv());
	}

	@Override
	public int insert(User employee) {
    	String sql = "INSERT INTO employee (idnv, tenNV, idpb, diachi,ngaySinh,soDienThoai) VALUES (?, ?, ?, ?,?,?)";
        return  executeUpdate(sql,employee.getIdnv(),employee.getHoten(),employee.getIdpb(), employee.getDiachi(),employee.getNgaySinh(), employee.getSoDienThoai());
	}
	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM employee";
		return count(sql);
	}

	@Override
	public ArrayList<User> findALLEmployeeByIDPB(String id,IPageble pageble ) {
		 String sql = "SELECT * FROM employee WHERE idpb = ? ";
		 if (pageble.getSorter() != null&&pageble.getSorter().getSortName()!=null &&pageble.getSorter().getSortBy()!=null) {
				sql+=" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"";
			}
			if (pageble.getOffset() != null && pageble.getLimit() != null) {
				sql+=" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+"";
			}
		return query(sql, new UserMapper(), id);
	}

	@Override
	public int getTotalEmployeeByIDPB(String idpb) {
		String sql = "SELECT count(*) FROM employee WHERE idpb = ?";
		return count(sql, idpb);
	}

	
}
