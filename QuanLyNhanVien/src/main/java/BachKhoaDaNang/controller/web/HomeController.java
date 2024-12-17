package BachKhoaDaNang.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BachKhoaDaNang.bean.Account;
import BachKhoaDaNang.bean.User;
import BachKhoaDaNang.constant.SystemConstant;
import BachKhoaDaNang.service.IAccountService;
import BachKhoaDaNang.service.IUserService;
import BachKhoaDaNang.utils.FormUtil;
import BachKhoaDaNang.utils.SessionUtil;

@WebServlet(urlPatterns = {"/dang-nhap","/trang-chu","/thoat"})
public class HomeController extends HttpServlet {
	
	@Inject
	private IAccountService accountService;
	@Inject
	private IUserService userService;
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action !=null && action.equals("login")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
			rd.forward(req, resp);
		} else if (action !=null && action.equals("logout")){
			SessionUtil.getInstance().removeValue(req, SystemConstant.USERMODEL);
			 SessionUtil.getInstance().removeValue(req,  SystemConstant.USERACCOUNT);
			resp.sendRedirect(req.getContextPath()+"/trang-chu");
		} else {
			 resp.sendRedirect("news?type=list&categoryId=tintuc&page=1&maxPageItem=10");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action !=null && action.equals("login")) {
			 Account account =FormUtil.toModel(Account.class, req);
			 // authentication
			 account = accountService.findAccountByUserNameAndPassword(account.getUserName(),account.getPassWord());
			 if (account!= null) {
				 User model = userService.getEmployeeDetail(account.getIdNV());
				 // Authorization + session (put value and remove value, get value)
				 SessionUtil.getInstance().putValue(req, SystemConstant.USERACCOUNT, account);
				 SessionUtil.getInstance().putValue(req, SystemConstant.USERMODEL, model);
					if (account.getRole().equals("USER")) {
						resp.sendRedirect(req.getContextPath()+"/user-trang-chu");
					} else if (account.getRole().equals("ADMIN")) {
						 resp.sendRedirect(req.getContextPath()+"/admin-trang-chu");
					}
			 } else {
				 // false login
				 req.setAttribute("ivalidMessage","Username or Password is invalid");
				RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
				rd.forward(req, resp);
			 }
			 
			
		} 
	}
}

