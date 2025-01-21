package servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

// @MultipartConfig(location="/tmp", maxFileSize=1048576)

@WebServlet("/main")
@MultipartConfig
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "WEB-INF/jsp/form.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//name属性がpictのファイルをPartオブジェクトとして取得
		Part part = request.getPart("pict");
		//ファイル名を取得
		// for unix
		String _filename = part.getSubmittedFileName();
		System.out.println("_filename:" + _filename);
		// この段階では _filename には "c:" がついている。(win)
		// for win
		String filename = Paths.get(_filename).getFileName().toString();
		System.out.println("filename:" + filename);
		// この段階で、 "C:" のない filename になる。
		//アップロードするフォルダ
		String path = getServletContext().getRealPath("/upload");
		//実際にファイルが保存されるパス確認
		System.out.println("path:" + path);
		//書き込み
		part.write(path + File.separator + filename);
		request.setAttribute("filename", filename);
		String url = "WEB-INF/jsp/result.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
