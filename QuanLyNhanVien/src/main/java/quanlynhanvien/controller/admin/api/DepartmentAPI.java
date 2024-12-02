package quanlynhanvien.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import quanlynhanvien.bean.Department;
import quanlynhanvien.service.IDepartmentService;
import quanlynhanvien.utils.HttpUtil;

/*
 * url api use nouns but no verbs
 * 
 * ten key se trung voi ten bien trong modal
 * 
 * use HTTP headers for serialization formats
 * 
 * */
@WebServlet(urlPatterns = {"/api-admin-department"})
public class DepartmentAPI extends HttpServlet {
	
	@Inject
	private IDepartmentService departmentService;
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		// set định dạng nhận được tại server
		req.setCharacterEncoding("UTF-8");
		//thiet lap dinh dang gui ve client
		resp.setContentType("application/json");
		
		Department department = HttpUtil.of(req.getReader()).toModel(Department.class);
		departmentService.addDepartment(department);
		
		mapper.writeValue(resp.getOutputStream(), department);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		// set định dạng nhận được tại server
		req.setCharacterEncoding("UTF-8");
		//thiet lap dinh dang gui ve client
		resp.setContentType("application/json");
		
		Department department = HttpUtil.of(req.getReader()).toModel(Department.class);
		departmentService.updateDepartment(department);
		mapper.writeValue(resp.getOutputStream(), "success");
	}	
}
