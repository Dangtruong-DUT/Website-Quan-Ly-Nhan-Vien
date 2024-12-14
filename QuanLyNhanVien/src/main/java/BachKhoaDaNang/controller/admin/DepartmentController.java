package BachKhoaDaNang.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BachKhoaDaNang.bean.Department;
import BachKhoaDaNang.constant.SystemConstant;
import BachKhoaDaNang.paging.IPageble;
import BachKhoaDaNang.paging.imple.PageRequest;
import BachKhoaDaNang.service.IDepartmentService;
import BachKhoaDaNang.sorter.Sorter;
import BachKhoaDaNang.utils.FormUtil;



@WebServlet(urlPatterns = {"/admin-department"})
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
				view ="/views/admin/Department/list.jsp";
		 } else if (model.getType().equals(SystemConstant.EDIT)) {
			 if (model.getIdpb()!=null) {
				 model = departmentService.getDepartmentDetail(model.getIdpb());
				}
				view = "/views/admin/Department/edit.jsp";
			
		 }else if (model.getType().equals("listEmployee")) {
			 if (model.getIdpb()!=null) {
				 view = "";
				 resp.sendRedirect(String.format("admin-user?type=list&idpb=%s&page=1&maxPageItem=10", model.getIdpb()));
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
