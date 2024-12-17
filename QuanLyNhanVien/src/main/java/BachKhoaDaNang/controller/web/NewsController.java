package BachKhoaDaNang.controller.web;

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
import BachKhoaDaNang.service.INewService;
import BachKhoaDaNang.sorter.Sorter;
import BachKhoaDaNang.utils.FormUtil;


@WebServlet(urlPatterns = {"/news"})
public class NewsController extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	@Inject
	private INewService newService;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String type = req.getParameter("type");
		 String view ="";

	    if (type.equals("tamnhinvasumang")) {
	        view = "/views/web/news/template/tamnhinvasumang.jsp";
	    } else if (type.equals("mohinhdaotao")) {
	        view = "/views/web/news/template/mohinhdaotao.jsp";
	    } else if (type.equals("cachuongnghiencuu")) {
	        view = "/views/web/news/template/ScientificResearch.jsp";
	    } else if (type.equals("hoptacnhatruong")) {
	        view = "/views/web/news/template/hoptacnhatruong.jsp";
	    } else if (type.equals("cuusinhviendaihoc")) {
	        view = "/views/web/news/template/PostgraduateTraining.jsp";
	    } else if (type.equals("daotaothacsi")) {
	        view = "/views/web/news/template/HigherEducationPage.jsp";
	    } else if (type.equals(SystemConstant.DETAIL)) {
	    	News model = FormUtil.toModel(News.class, req);
	    	model= newService.findOne(model.getId());
			req.setAttribute(SystemConstant.MODEL, model);
	    	view = "/views/web/news/newsDetail.jsp";
	    } else  {
	    	
	    	String categoryId = req.getParameter("categoryId")!=null? 
	    						req.getParameter("categoryId")
	    						:"tintuc";
	    			;
	    	view = categoryId.equals("tintuc")
	    	        ? "/views/web/news/pageNews.jsp"
	    	                : "/views/web/news/pageNoti.jsp";;
			News model = FormUtil.toModel(News.class, req);
			int page = (model.getPage() != null) ? model.getPage() : 1;
			int maxPageItem = (model.getMaxPageItem() != null) ? model.getMaxPageItem() : 10;
				IPageble pageble = new PageRequest(page, maxPageItem,
						new Sorter(model.getSortName(), model.getSortBy()));
			model.setlistResult(newService.findAllbyCategoryId(categoryId,pageble));
			model.setTotalItem(newService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			req.setAttribute(SystemConstant.MODEL, model);
	    }
		 
		 RequestDispatcher rd = req.getRequestDispatcher(view);
		 rd.forward(req, resp);
	        
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
	}
}
