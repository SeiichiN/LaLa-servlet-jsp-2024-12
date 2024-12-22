package listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SaveListener implements HttpSessionListener {

    public SaveListener() {
    	System.out.println("sessionに保存されました");
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("sessionが作成されました");
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("sessionが破棄されました");
    }
	
}
