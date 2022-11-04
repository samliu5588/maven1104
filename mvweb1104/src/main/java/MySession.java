

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MySession
 *
 */
@WebListener
public class MySession implements HttpSessionListener, HttpSessionAttributeListener ,ServletContextListener{
	ServletContext context;
	int users;
    /**
     * Default constructor. 
     */
    public MySession() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event)  { 
         // TODO Auto-generated method stub
    	 users++;
         logout("sessionCreated('" + event.getSession().getId() + "'),目前有"+users+"個用戶");
         context.setAttribute("users",Integer.valueOf(users));
    }
       

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
   	 public void sessionDestroyed(HttpSessionEvent event) {
             users--;
             logout("sessionDestroyed('" + event.getSession().getId() + "'),目前有"+users+"個用戶");
             context.setAttribute("users",Integer.valueOf(users));


        
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	logout("attributeAdded('" + event.getSession().getId() + "', '" +  event.getName() + "', '" + event.getValue() + "')");

    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }
  //ServletContextListener
    public void contextDestroyed(ServletContextEvent sce) {
     logout("contextDestroyed()-->ServletContext被銷毀");
        this.context = null;
    }
    public void contextInitialized(ServletContextEvent sce) {
     this.context = sce.getServletContext();
     logout("contextInitialized()-->ServletContext初始化了");
    }//ServletContextListener

    
    private void logout(String msg) {
        System.out.println(msg);
    }
}
