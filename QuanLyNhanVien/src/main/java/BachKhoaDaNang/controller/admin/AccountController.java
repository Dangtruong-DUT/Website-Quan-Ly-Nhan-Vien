package BachKhoaDaNang.controller.admin;

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

@WebServlet(urlPatterns = {"/admin-account"})
public class AccountController extends HttpServlet {
	@Inject
	private IAccountService accountService;

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Account model =FormUtil.toModel(Account.class, req);
		 String view ="";
		 if (model.getType().equals(SystemConstant.LIST)) {
			 IPageble Pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
		        		new Sorter(model.getSortName(), model.getSortBy()));
		        int page = req.getParameter("page")!=null
		        		?Integer.parseInt(req.getParameter("page")):1;
		        int maxPageItem = req.getParameter("maxPageItem")!=null
		        		?Integer.parseInt(req.getParameter("maxPageItem")):10;
		        // if client seen employee with idpb or not
		        if (model.getIdNV()==null||model.getIdNV().equals("")) {
		        	model.setTotalItem(accountService.getTotalAccount());
			        model.setlistResult(accountService.findAllAccount(Pageble));
		        } else {
			        model.setlistResult(accountService.findAccountByIDNV(model.getIdNV()));
			        model.setTotalItem(model.getlistResult()!=null?model.getlistResult().size():0);
		        }
		        model.setMaxPageItem(maxPageItem);
		        model.setPage(page);
		        
		        model.setTotalPage((int) Math.ceil((double)model.getTotalItem()/model.getMaxPageItem()));
		        
		        if (model.getTotalItem()!=0) {
		        	view ="/views/admin/Account/list.jsp";
		        } else {
		        	view = "/views/admin/Account/edit.jsp";
		        }
				// response edit or insert
		 } else if (model.getType().equals(SystemConstant.EDIT)) {
			 if (model.getIdNV() != null) {
				    ArrayList<Account> accountList = accountService.findAccountByIDNV(model.getIdNV());
				    
				    if (accountList != null && !accountList.isEmpty()) {
				        model = accountList.get(0);
				    }
				}
				view = "/views/admin/Account/edit.jsp";
			
		 }else if (model.getType().equals(SystemConstant.SEARCH)) {
				view = "/views/admin/Account/search.jsp";	
		 }
		 if (view!="") {
			 req.setAttribute(SystemConstant.MODEL, model);
			 RequestDispatcher rd = req.getRequestDispatcher(view);
			 rd.forward(req, resp);
		         
		 }
	}
}
