package BachKhoaDaNang.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BachKhoaDaNang.bean.News;
import BachKhoaDaNang.constant.SystemConstant;
import BachKhoaDaNang.paging.IPageble;
import BachKhoaDaNang.paging.imple.PageRequest;
import BachKhoaDaNang.service.ICategoryService;
import BachKhoaDaNang.service.INewService;
import BachKhoaDaNang.sorter.Sorter;
import BachKhoaDaNang.utils.FormUtil;


@WebServlet(urlPatterns = {"/admin-news"})
public class NewController extends HttpServlet {
	
	private static final long serialVersionUID = 2686801510274002166L;
	
	@Inject
	private INewService newService;

	@Inject
	private ICategoryService categoryService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryId = request.getParameter("categoryId");
		News model = FormUtil.toModel(News.class, request);
		String view = "";
		if (model.getType().equals(SystemConstant.LIST)) {
			IPageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setlistResult(newService.findAllbyCategoryId(categoryId,pageble));
			model.setTotalItem(newService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/news/list.jsp";
		} else if (model.getType().equals(SystemConstant.EDIT)) {
			if (model.getId() != null) {
				model = newService.findOne(model.getId());
			}
			request.setAttribute("categories", categoryService.findAll());
			view = "/views/admin/news/edit.jsp";
		}
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
