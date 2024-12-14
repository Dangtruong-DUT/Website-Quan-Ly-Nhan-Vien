package BachKhoaDaNang.controller.user.api;

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


@WebServlet(urlPatterns = {"/api-employee-user"})
public class UserAPI extends HttpServlet {
	
	@Inject
	private IUserService employeeService;
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		

		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		User employee = HttpUtil.of(req.getReader()).toModel(User.class);
		int count = employeeService.updateEmployee(employee);
		mapper.writeValue(resp.getOutputStream(),count);
	}
	
	
}
