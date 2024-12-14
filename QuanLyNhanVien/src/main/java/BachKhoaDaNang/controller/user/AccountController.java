package BachKhoaDaNang.controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BachKhoaDaNang.bean.Account;
import BachKhoaDaNang.constant.SystemConstant;
import BachKhoaDaNang.paging.IPageble;
import BachKhoaDaNang.paging.imple.PageRequest;
import BachKhoaDaNang.service.IAccountService;
import BachKhoaDaNang.sorter.Sorter;
import BachKhoaDaNang.utils.FormUtil;

@WebServlet(urlPatterns = {"/user-account"})
public class AccountController extends HttpServlet {
	@Inject
	private IAccountService accountService;

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Account model =FormUtil.toModel(Account.class, req);
		 String view ="";
		if (model.getType().equals(SystemConstant.EDIT)) {
			 if (model.getIdNV() != null) {
				    ArrayList<Account> accountList = accountService.findAccountByIDNV(model.getIdNV());
				    
				    if (accountList != null && !accountList.isEmpty()) {
				        model = accountList.get(0);
				    }
				}
				view = "/views/user/Account/edit.jsp";
			
		 }
		 if (view!="") {
			 req.setAttribute(SystemConstant.MODEL, model);
			 RequestDispatcher rd = req.getRequestDispatcher(view);
			 rd.forward(req, resp);
		         
		 }
	}
}
