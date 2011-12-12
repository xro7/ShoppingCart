package Cart;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.*;
import java.net.*;


public class RedirectServlet extends HttpServlet {
 
   public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {
 //javac -d . -classpath /apache/tomcat/common/lib/servlet-api.jar ccServlet.java UriReport.java  RedirectServlet.java
     
      response.setContentType("text/html");
     
      PrintWriter out = response.getWriter();
 
      UriReport ur = (UriReport)getServletContext().getAttribute("redirectsite");
      response.sendRedirect(ur.getUri());
      out.close();  // Always close the output writer
         
    }

}