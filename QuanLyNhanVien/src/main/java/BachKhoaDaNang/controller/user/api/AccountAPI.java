package BachKhoaDaNang.controller.user.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import BachKhoaDaNang.bean.Account;
import BachKhoaDaNang.bean.User;
import BachKhoaDaNang.service.IAccountService;
import BachKhoaDaNang.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-user-account"})
public class AccountAPI extends HttpServlet {
	@Inject
	private IAccountService accountService;
	
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		// set định dạng nhận được tại server
		req.setCharacterEncoding("UTF-8");
		//thiet lap dinh dang gui ve client
		resp.setContentType("application/json");
		
		Account account = HttpUtil.of(req.getReader()).toModel(Account.class);
		int count =accountService.update(account);
		mapper.writeValue(resp.getOutputStream(), count);
	}
	
}
