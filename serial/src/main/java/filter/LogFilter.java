package filter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class LogFilter extends HttpFilter {

	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

		ServletContext application = request.getServletContext();
		Date current = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String path = "/WEB-INF/log/" + sdf.format(current) + ".log";
		//いつもの３段ラッピングを行うがgetRealPathを使って実行環境のパスを渡していることに注意)
		//第２引数はappend->true(追記モード)
		FileOutputStream fos = new FileOutputStream(application.getRealPath(path),true);
		//コンソールにリアルパスを出力しておく
		System.out.println(application.getRealPath(path));

		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		BufferedWriter bw = new BufferedWriter(osw);
		sdf = new SimpleDateFormat("HH:mm:ss");
		bw.write(sdf.format(current));
		//win環境では"¥t"
		bw.write("\t");
		bw.write(((HttpServletRequest)request).getServletPath());
		bw.write("\t");
		bw.write(((HttpServletRequest)request).getHeader("user-agent"));
		//osに依存しない改行コード出力
		bw.newLine();
		bw.close();		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
