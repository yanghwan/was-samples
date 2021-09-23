
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ForwardedPage extends HttpServlet {
    
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
		out.println("<a href='/examples/sources/ForwardedPage.java'><b><font color='#FFFFFF'><b>view source </b></font></a></td>");
		out.println("<td  width=\"25%\" align=\"center\" onMouseover=\"this.style.backgroundColor='#0099cc'\" onMouseout=\"this.style.backgroundColor='#999999'\">");
		out.println("</td>");
		out.println("<td  width=\"25%\" align=\"center\" onMouseover=\"this.style.backgroundColor='#0099cc'\" onMouseout=\"this.style.backgroundColor='#999999'\">");
		out.println("</td>");
		out.println("</tr>");
		out.println("<td colspan='4' class='tdpadding'>");
        out.println("<font color=\"blue\">");
        out.println("<br><br><b>This table is generated by ForwardedPage<b><br><br>");
        out.println("<table border=\"0\" cellpadding=\"5\">");
        out.println("<tr><td bgcolor=\"#CCFFFF\">Context Path</td><td>");
        out.println(request.getContextPath() + "</td></tr>");
        out.println("<tr><td bgcolor=\"#CCFFFF\">Servlet Path</td><td>");
        out.println(request.getServletPath() + "</td></tr>");
        out.println("<tr><td bgcolor=\"#CCFFFF\">Path Info</td><td>");
        out.println(request.getPathInfo() + "</td></tr>");
        out.println("<tr><td bgcolor=\"#CCFFFF\">Request URI</td><td>");
        out.println(request.getRequestURI() + "</td></tr>");
        out.println("<tr><td bgcolor=\"#CCFFFF\">Query String</td><td>");
        out.println(request.getQueryString() + "</td></tr>");

        Enumeration enum = request.getParameterNames();
        while (enum.hasMoreElements()) {
            String name = (String)enum.nextElement();
            String value = request.getParameter(name);
            out.println("<tr><td bgcolor=\"#CCFFFF\">Parameter: " + name + "</td><td>");
            out.println(value + "</td></tr>");
        }

        enum = request.getAttributeNames();
        while (enum.hasMoreElements()) {
            String name = (String)enum.nextElement();
            String value = (String)request.getAttribute(name);
            out.println("<tr><td bgcolor=\"#CCFFFF\">Attribute: " + name + "</td><td>");
            out.println(value + "</td></tr>");
        }
	request.removeAttribute("forwarded servlet");
        out.println("</table>");
        out.println("</font>");
        out.println("</td></tr></table><br><br>");	
        out.println("</body>");
        out.println("</html>");
    }
}
