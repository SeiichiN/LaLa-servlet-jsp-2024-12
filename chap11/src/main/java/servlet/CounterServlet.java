package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CounterServlet")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			              HttpServletResponse response)
	       throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		Integer count = (Integer)application.getAttribute("count");
		count++;
		application.setAttribute("count", count);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!doctype html><html><head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>訪問回数を表示</title></head><body>");
		out.println("<p>訪問回数: " + count + "</p>");
		out.println("<a href='CounterServlet'>更新</a>");
		out.println("</body></html>");
	}
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init()が実行されました");
	}

	public void destroy() {
		System.out.println("destroy()が実行されました");
	}

}