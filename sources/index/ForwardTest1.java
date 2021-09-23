
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ForwardTest1 extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
		out.println("<head>");
		out.println("<title>JEUS Samples</title>");
		out.println("<link rel='stylesheet' type='text/css' href='infolink.css'>");
		out.println("</head>");
		
		out.println("<body BGCOLOR='#FFFFFF' TEXT='#000000' LINK='#0000EE' VLINK='#551A8B' ALINK='#FF0000' leftmargin='0' topmargin='0' marginwidth='0' marginheight='0'>");
		out.println("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
		out.println("<tr>");
		out.println("<td height='67' background='images/bgColor.gif'><img src='images/logo.gif' width='237' height='67'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td height='11' background='images/bgline.gif'></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<br>");
		out.println("<table width='760' border='0' align='left' cellpadding='1' cellspacing='1' bgcolor='#FFFFFF'>");
		out.println("<tr bgcolor='#999999'>");
		out.println("<td  width=\"25%\" height=\"27\" align=\"center\" onMouseover=\"this.style.backgroundColor='#0099cc'\" onMouseout=\"this.style.backgroundColor='#999999'\">");
		out.println("<a href='/examples/index2.jsp'><b><font color='#FFFFFF' face='Arial'>home</font></b></a></td>");
		out.println("<td  width=\"25%\" align=\"center\" onMouseover=\"this.style.backgroundColor='#0099cc'\" onMouseout=\"this.style.backgroundColor='#999999'\">");
		out.println("<a href='/examples/sources/ForwardTest1.java'><b><font color='#FFFFFF'><b>view source </b></font></a></td>");
		out.println("<td  width=\"25%\" align=\"center\" onMouseover=\"this.style.backgroundColor='#0099cc'\" onMouseout=\"this.style.backgroundColor='#999999'\">");
		out.println("</td>");
		out.println("<td  width=\"25%\" align=\"center\" onMouseover=\"this.style.backgroundColor='#0099cc'\" onMouseout=\"this.style.backgroundColor='#999999'\">");
		out.println("</td>");
		out.println("</tr>");
		out.println("<td colspan='4' class='tdpadding'>");
  
  
        out.println("<br><h3>Forward using RequestDispatcher</h3>");
        out.println("<b>This table is generated by ForwardTest1</b><br>");
        out.println("<table border=\"0\" cellpadding=\"5\">");
        out.println("<tr><td bgcolor=\"#B0E2FF\">Context Path</td><td>");
        out.println(request.getContextPath() + "</td></tr>");
        out.println("<tr><td bgcolor=\"#B0E2FF\">Servlet Path</td><td>");
        out.println(request.getServletPath() + "</td></tr>");
        out.println("<tr><td bgcolor=\"#B0E2FF\">Path Info</td><td>");
        out.println(request.getPathInfo() + "</td></tr>");
        out.println("<tr><td bgcolor=\"#B0E2FF\">Request URI</td><td>");
        out.println(request.getRequestURI() + "</td></tr>");
        out.println("<tr><td bgcolor=\"#B0E2FF\">Query String</td><td>");
        out.println(request.getQueryString() + "</td></tr>");
  
        Enumeration enum = request.getParameterNames();
        while (enum.hasMoreElements()) {
      	    String name = (String)enum.nextElement();
      	    String value = request.getParameter(name);
            out.println("<tr><td bgcolor=\"#B0E2FF\">Parameter: " + name + "</td><td>");
            out.println(value + "</td></tr>");
        }

	request.setAttribute("original servlet", "ForwardTest1");
	request.setAttribute("forwarded servlet", "ForwardedPage");
        enum = request.getAttributeNames();
        while (enum.hasMoreElements()) {
      	    String name = (String)enum.nextElement();
      	    String value = (String)request.getAttribute(name);
            out.println("<tr><td bgcolor=\"#B0E2FF\">Attribute: " + name + "</td><td>");
            out.println(value + "</td></tr>");
        }
        out.println("</table>");
  
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher(
                               "/ForwardedPage/han?color=blue");
        rd.forward(request, response);
        out.println("<br><br><b>After forwarding to /ForwardedPage</b>");
        out.println("<table border=\"0\" cellpadding=\"5\">");
        enum = request.getParameterNames();
        while (enum.hasMoreElements()) {
      	    String name = (String)enum.nextElement();
      	    String value = request.getParameter(name);
            out.println("<tr><td bgcolor=\"#B0E2FF\">Parameter: " + name + "</td><td>");
            out.println(value + "</td></tr>");
        }
        enum = request.getAttributeNames();
        while (enum.hasMoreElements()) {
      	    String name = (String)enum.nextElement();
      	    String value = (String)request.getAttribute(name);
            out.println("<tr><td bgcolor=\"#B0E2FF\">Attribute: " + name + "</td><td>");
            out.println(value + "</td></tr>");
        }
        out.println("</table>");
 		out.println("</td></tr></table><br><br>");	
        out.println("</body>");
        out.println("</html>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
