package quanlynhanvien.dao.imple;

import java.util.ArrayList;

import quanlynhanvien.Mapper.DepartmentMapper;
import quanlynhanvien.bean.Department;
import quanlynhanvien.dao.IDepartmentDAO;
import quanlynhanvien.paging.IPageble;

public class DepartmentDAO extends AbstractDAO<Department>  implements IDepartmentDAO  {
	
	
	@Override
	public ArrayList<Department> findAll(IPageble pageble) {
        String sql = "SELECT * FROM phongban ";
        if (pageble.getSorter() != null&&pageble.getSorter().getSortName()!=null &&pageble.getSorter().getSortBy()!=null) {
			sql+=" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"";
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql+=" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+"";
		}
		return query(sql.toString(), new DepartmentMapper());

	}

	@Override
	public Department findByDepartmentID(String id) {
        String sql = "SELECT * FROM phongban WHERE idpb = ?";
		ArrayList<Department> department = query(sql, new DepartmentMapper(), id);
		return department==null? null : department.get(0);
	}

	@Override
	public int delete(String id) {
        String sql = "DELETE FROM phongban WHERE idpb = ?";
        return  executeUpdate(sql,id);
	}

	@Override
	public int update(Department department) {
         String sql = "UPDATE phongban SET tenpb = ?, mota = ? WHERE idpb = ?";
         return  executeUpdate(sql,department.getTenpb(),department.getMota(),department.getIdpb());
	}

	@Override
	public int insert(Department department) {
    	String sql = "INSERT INTO phongban (idpb, tenpb, mota) VALUES (?, ?, ?)";
        return  executeUpdate(sql,department.getIdpb(),department.getTenpb(),department.getMota());
	}
	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM phongban";
		return count(sql);
	}

	@Override
	public ArrayList<Department> findAll() {
		String sql = "SELECT * FROM phongban ";
		return query(sql, new DepartmentMapper());
	}
}