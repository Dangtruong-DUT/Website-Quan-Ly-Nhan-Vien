package BachKhoaDaNang.dao.imple;

import java.util.ArrayList;

import BachKhoaDaNang.Mapper.DepartmentMapper;
import BachKhoaDaNang.bean.Department;
import BachKhoaDaNang.dao.IDepartmentDAO;
import BachKhoaDaNang.paging.IPageble;

public class DepartmentDAO extends AbstractDAO<Department>  implements IDepartmentDAO  {
	
	
	@Override
	public ArrayList<Department> findAll(IPageble pageble) {
        String sql = "SELECT * FROM department ";
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
        String sql = "SELECT * FROM department WHERE idpb = ?";
		ArrayList<Department> department = query(sql, new DepartmentMapper(), id);
		return department==null? null : department.get(0);
	}

	@Override
	public int delete(String id) {
        String sql = "DELETE FROM department WHERE idpb = ?";
        return  executeUpdate(sql,id);
	}

	@Override
	public int update(Department department) {
         String sql = "UPDATE department SET tenpb = ?, mota = ? WHERE idpb = ?";
         return  executeUpdate(sql,department.getTenpb(),department.getMota(),department.getIdpb());
	}

	@Override
	public int insert(Department department) {
    	String sql = "INSERT INTO department (idpb, tenpb, mota) VALUES (?, ?, ?)";
        return  executeUpdate(sql,department.getIdpb(),department.getTenpb(),department.getMota());
	}
	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM department";
		return count(sql);
	}

	@Override
	public ArrayList<Department> findAll() {
		String sql = "SELECT * FROM department ";
		return query(sql, new DepartmentMapper());
	}
}