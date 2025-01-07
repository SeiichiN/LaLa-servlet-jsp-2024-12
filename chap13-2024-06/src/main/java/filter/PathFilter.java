package filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class PathFilter extends HttpFilter {
       
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getServletPath();
		if (path.equals("/")) {
			// "/chap13/getList"にリダイレクト
			String contextPath = req.getContextPath();
			((HttpServletResponse)response).sendRedirect(contextPath + "/getList");
			return;
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
