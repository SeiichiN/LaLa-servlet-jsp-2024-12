package listener;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import util.Const;

@WebListener
public class SetImgListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 

    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context = sce.getServletContext();
		context.setAttribute("pencil_png", Const.IMG_PENCIL);
		context.setAttribute("trash_png", Const.IMG_TRASH);
		context.setAttribute("find_png", Const.IMG_FIND);
    }
	
}
