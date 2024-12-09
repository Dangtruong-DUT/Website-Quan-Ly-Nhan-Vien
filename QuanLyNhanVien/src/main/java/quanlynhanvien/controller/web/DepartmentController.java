package quanlynhanvien.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quanlynhanvien.bean.Department;
import quanlynhanvien.constant.SystemConstant;
import quanlynhanvien.paging.IPageble;
import quanlynhanvien.paging.imple.PageRequest;
import quanlynhanvien.service.IDepartmentService;
import quanlynhanvien.sorter.Sorter;
import quanlynhanvien.utils.FormUtil;



@WebServlet(urlPatterns = {"/department"})
public class DepartmentController  extends  HttpServlet {
	@Inject 
	private IDepartmentService departmentService;

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Department model =FormUtil.toModel(Department.class, req);
		 String view ="";
		 if (model.getType().equals(SystemConstant.LIST)) {
			 IPageble Pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
		        		new Sorter(model.getSortName(), model.getSortBy()));
		        int page = req.getParameter("page")!=null
		        		?Integer.parseInt(req.getParameter("page")):1;
		        int maxPageItem = req.getParameter("maxPageItem")!=null
		        		?Integer.parseInt(req.getParameter("maxPageItem")):10;
		        model.setMaxPageItem(maxPageItem);
		        model.setPage(page);
		        model.setTotalItem(departmentService.getTotalDepartment());
		        model.setlistResult(departmentService.getAllDepartment(Pageble));
		        model.setTotalPage((int) Math.ceil((double)model.getTotalItem()/model.getMaxPageItem()));
				view ="/views/web/Department/list.jsp";
		 } else if (model.getType().equals("listEmployee")) {
			 if (model.getIdpb()!=null) {
				 view = "";
				 resp.sendRedirect(String.format("employee?type=list&idpb=%s&page=1&maxPageItem=10", model.getIdpb()));
			 }	 
		}
		 
		 if (!view.equals("")) {
			 req.setAttribute(SystemConstant.MODEL, model);
			 RequestDispatcher rd = req.getRequestDispatcher(view);
			 rd.forward(req, resp);
		 }
		 
	        
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
	}
}
