package servlet;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.SiteEV;
import model.SiteEVLogic;

@WebServlet("/MinatoIndex")
public class MinatoIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		SiteEV siteEV = (SiteEV) application.getAttribute("siteEV");
		if (siteEV == null) {
			siteEV = new SiteEV();
		}
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		SiteEVLogic siteEVLogic = new SiteEVLogic();
		if (action != null && action.equals("like")) {
			siteEVLogic.like(siteEV);
		}
		else if (action != null && action.equals("dislike")) {
			siteEVLogic.dislike(siteEV);
		}
		application.setAttribute("siteEV", siteEV);
		String url = "WEB-INF/jsp/minatoIndex.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
