package quanlynhanvien.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import quanlynhanvien.bean.Account;
import quanlynhanvien.bean.Employee;
import quanlynhanvien.service.IAccountService;
import quanlynhanvien.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-account"})
public class AccountAPI extends HttpServlet {
	@Inject
	private IAccountService accountService;
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		Account account = HttpUtil.of(req.getReader()).toModel(Account.class);
		accountService.insert(account);
		
		mapper.writeValue(resp.getOutputStream(), account);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		// set định dạng nhận được tại server
		req.setCharacterEncoding("UTF-8");
		//thiet lap dinh dang gui ve client
		resp.setContentType("application/json");
		
		Account account = HttpUtil.of(req.getReader()).toModel(Account.class);
		accountService.update(account);
		mapper.writeValue(resp.getOutputStream(), "success");
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		// set định dạng nhận được tại server
		req.setCharacterEncoding("UTF-8");
		//thiet lap dinh dang gui ve client
		resp.setContentType("application/json");
		
		Account account = HttpUtil.of(req.getReader()).toModel(Account.class);
		accountService.delete(account.getUserName());
		mapper.writeValue(resp.getOutputStream(), "success delete");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}