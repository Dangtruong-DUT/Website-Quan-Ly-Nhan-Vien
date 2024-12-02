package quanlynhanvien.service.imple;

import java.util.ArrayList;

import javax.inject.Inject;

import quanlynhanvien.bean.Department;
import quanlynhanvien.dao.IDepartmentDAO;
import quanlynhanvien.paging.IPageble;
import quanlynhanvien.service.IDepartmentService;

public class DepartmentService implements IDepartmentService{
	
	@Inject
	private IDepartmentDAO dao;
	
	
	@Override
	public ArrayList<Department> getAllDepartment(IPageble value) {
		return dao.findAll(value);
	}

	@Override
	public Department getDepartmentDetail(String id) {
		return dao.findByDepartmentID(id);
	}

	@Override
	public int updateDepartment(Department department) {
		return dao.update(department);
	}

	@Override
	public int getTotalDepartment() {
		return dao.getTotalItem();
	}

	@Override
	public ArrayList<Department> getAllDepartment() {
		return dao.findAll();
	}

	@Override
	public int addDepartment(Department department) {
		return dao.insert(department);
	}

}
