package quanlynhanvien.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quanlynhanvien.bean.Account;
import quanlynhanvien.service.IAccountService;
import quanlynhanvien.utils.FormUtil;
import quanlynhanvien.utils.SessionUtil;

@WebServlet(urlPatterns = {"/dang-nhap","/trang-chu","/thoat"})
public class HomeController extends HttpServlet {
	
	@Inject
	private IAccountService accountService;
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action !=null && action.equals("login")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
			rd.forward(req, resp);
		} else if (action !=null && action.equals("logout")){
			SessionUtil.getInstance().removeValue(req, "USERMODEL");
			resp.sendRedirect(req.getContextPath()+"/trang-chu");
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action !=null && action.equals("login")) {
			 Account model =FormUtil.toModel(Account.class, req);
			 // authentication
			 model = accountService.findAccountByUserNameAndPassword(model.getUserName(),model.getPassWord());
			 if (model!= null) {
				 // Authorization + session (put value and remove value, get value)
				 SessionUtil.getInstance().putValue(req, "USERMODEL", model);
					if (model.getRole().getCode().equals("USER")) {
						resp.sendRedirect(req.getContextPath()+"/trang-chu");
					} else if (model.getRole().getCode().equals("ADMIN")) {
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

