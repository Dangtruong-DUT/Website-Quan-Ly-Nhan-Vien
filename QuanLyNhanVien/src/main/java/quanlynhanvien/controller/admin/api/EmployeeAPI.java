package quanlynhanvien.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import quanlynhanvien.bean.Employee;
import quanlynhanvien.service.IEmployeeService;
import quanlynhanvien.utils.HttpUtil;

/*
 * url api use nouns but no verbs
 * 
 * ten key se trung voi ten bien trong modal
 * 
 * use HTTP headers for serialization formats
 * 
 * */
@WebServlet(urlPatterns = {"/api-admin-employee"})
public class EmployeeAPI extends HttpServlet {
	
	@Inject
	private IEmployeeService employeeService;
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		// set định dạng nhận được tại server
		req.setCharacterEncoding("UTF-8");
		//thiet lap dinh dang gui ve client
		resp.setContentType("application/json");
		
		Employee employee = HttpUtil.of(req.getReader()).toModel(Employee.class);
		employeeService.addEmployee(employee);
		
		mapper.writeValue(resp.getOutputStream(), employee);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		// set định dạng nhận được tại server
		req.setCharacterEncoding("UTF-8");
		//thiet lap dinh dang gui ve client
		resp.setContentType("application/json");
		
		Employee employee = HttpUtil.of(req.getReader()).toModel(Employee.class);
		employeeService.updateEmployee(employee);
		mapper.writeValue(resp.getOutputStream(), "success");
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		// set định dạng nhận được tại server
		req.setCharacterEncoding("UTF-8");
		//thiet lap dinh dang gui ve client
		resp.setContentType("application/json");
		
		Employee employee = HttpUtil.of(req.getReader()).toModel(Employee.class);
		employeeService.deleteEmployees(employee.getIds());
		mapper.writeValue(resp.getOutputStream(), "success delete");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
}
