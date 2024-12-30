package filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class SetPathFilter extends HttpFilter {
	private static final long serialVersionUID = 1L;

	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		String path = request.getServletPath();
		if (path.equals("/")) {
			response.sendRedirect("game");
			return;
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);

	}

}
