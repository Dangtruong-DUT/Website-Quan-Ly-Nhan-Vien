package BachKhoaDaNang.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import BachKhoaDaNang.bean.User;
import BachKhoaDaNang.service.IUserService;
import BachKhoaDaNang.utils.HttpUtil;

/*
 * url api use nouns but no verbs
 * 
 * ten key se trung voi ten bien trong modal
 * 
 * use HTTP headers for serialization formats
 * 
 * */
@WebServlet(urlPatterns = {"/api-admin-user"})
public class UserAPI extends HttpServlet {
	
	@Inject
	private IUserService employeeService;
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		// set định dạng nhận được tại server
		req.setCharacterEncoding("UTF-8");
		//thiet lap dinh dang gui ve client
		resp.setContentType("application/json");
		
		User employee = HttpUtil.of(req.getReader()).toModel(User.class);
		int count =employeeService.addEmployee(employee);
		
		mapper.writeValue(resp.getOutputStream(), count);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		// set định dạng nhận được tại server
		req.setCharacterEncoding("UTF-8");
		//thiet lap dinh dang gui ve client
		resp.setContentType("application/json");
		
		User employee = HttpUtil.of(req.getReader()).toModel(User.class);
		int count = employeeService.updateEmployee(employee);
		mapper.writeValue(resp.getOutputStream(),count);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		// set định dạng nhận được tại server
		req.setCharacterEncoding("UTF-8");
		//thiet lap dinh dang gui ve client
		resp.setContentType("application/json");
		
		User employee = HttpUtil.of(req.getReader()).toModel(User.class);
		int count =employeeService.deleteEmployees(employee.getIds());
		mapper.writeValue(resp.getOutputStream(), count);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
}
