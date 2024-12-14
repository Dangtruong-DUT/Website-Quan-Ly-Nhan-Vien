package BachKhoaDaNang.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/news"})
public class NewsController extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String type = req.getParameter("type");
		 String view ="";

		if (type != null) {
		    if (type.equals("tamnhinvasumang")) {
		        view = "/views/web/news/tamnhinvasumang.jsp";
		    } else if (type.equals("mohinhdaotao")) {
		        view = "/views/web/news/mohinhdaotao.jsp";
		    } else if (type.equals("cachuongnghiencuu")) {
		        view = "/views/web/news/ScientificResearch.jsp";
		    } else if (type.equals("hoptacnhatruong")) {
		        view = "/views/web/news/hoptacnhatruong.jsp";
		    } else if (type.equals("cuusinhviendaihoc")) {
		        view = "/views/web/news/PostgraduateTraining.jsp";
		    } else if (type.equals("daotaothacsi")) {
		        view = "/views/web/news/HigherEducationPage.jsp";
		    } else if (type.equals("thongbao")) {
		        view = "/views/web/news/thongbao.jsp";
		    } else {
		        view = "/views/web/news/pageNews.jsp";
		    }
		} else {
		    view = "/views/web/news/pageNews.jsp";
		}
		 RequestDispatcher rd = req.getRequestDispatcher(view);
		 rd.forward(req, resp);
	        
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
	}
}
