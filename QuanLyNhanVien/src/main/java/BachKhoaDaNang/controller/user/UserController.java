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

import BachKhoaDaNang.bean.User;
import BachKhoaDaNang.constant.SystemConstant;
import BachKhoaDaNang.paging.IPageble;
import BachKhoaDaNang.paging.imple.PageRequest;
import BachKhoaDaNang.service.IUserService;
import BachKhoaDaNang.sorter.Sorter;
import BachKhoaDaNang.utils.FormUtil;

@WebServlet(urlPatterns = {"/user","/user-account"})
public class UserController extends HttpServlet {
	@Inject 
	private IUserService employeeService;

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 User model =FormUtil.toModel(User.class, req);
		 String view ="";
		 // response list Employee
		 if (model.getType().equals(SystemConstant.LIST)) {
			 IPageble Pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
		        		new Sorter(model.getSortName(), model.getSortBy()));
			 
		        int page = req.getParameter("page")!=null
		        		?Integer.parseInt(req.getParameter("page")):1;
		        
		        int maxPageItem = req.getParameter("maxPageItem")!=null
		        		?Integer.parseInt(req.getParameter("maxPageItem")):10;
		        
		        
		        // if client seen employee with idpb or not
		        if (model.getIdpb()==null||model.getIdpb().equals("")) {
		        	model.setTotalItem(employeeService.getTotalEmployee());
			        model.setlistResult(employeeService.getAllEmploy(Pageble));
		        }else {
		        	model.setTotalItem(employeeService.getTotalEmployeewithIPB(model.getIdpb()));
			        model.setlistResult(employeeService.getAllEmploywithIDPB(model.getIdpb(),Pageble));
		        }
		        model.setMaxPageItem(maxPageItem);
		        model.setPage(page);
		        
		        model.setTotalPage((int) Math.ceil((double)model.getTotalItem()/model.getMaxPageItem()));
				view ="/views/user/Employee/list.jsp";
				// response edit or insert
		 }  else if (model.getType().equals(SystemConstant.SEARCH)) {
				view = "/views/user/Employee/search.jsp";	
		}
		 req.setAttribute(SystemConstant.MODEL, model);
		 RequestDispatcher rd = req.getRequestDispatcher(view);
		 rd.forward(req, resp);
	        
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String key = req.getParameter("key");
		String value = req.getParameter("value");
		Integer page = 1;
		Integer maxPageItem= 10;
		User model = new User();
		 String view ="";
		if (action!=null&&action.equals("search")) {
		 	model.setMaxPageItem(maxPageItem);
		    model.setPage(page);
		    IPageble Pageble = new PageRequest(page, maxPageItem,key,value,
	        		new Sorter(model.getSortName(), model.getSortBy()));
		    model.setlistResult(employeeService.getAllEmploy(Pageble));
		    ArrayList<User> list = employeeService.getAllEmploy(new PageRequest(null,null,key,value,null));
		    int totalIteam = list!=null?list.size():0;
		    model.setTotalItem(totalIteam);
		    model.setTotalPage((int) Math.ceil((double)model.getTotalItem()/model.getMaxPageItem()));
			view = "/views/user/Employee/list.jsp";
	 	} 
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
}
