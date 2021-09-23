
<% 
	String[] fruits;
	fruits = request.getParameterValues("fruits");
%>

<!-- upper.jsp -->
<%@ include file="../../upper.jsp" %>

The checked fruits (using request object) are: <br>
<ul>
<%
    if (fruits != null) 
    {
	  for (int i = 0; i < fruits.length; i++) 
	  {
%>
		<li><%= fruits[i] %>
<%
	  }
	} 
	else  
	{
%>
		no fruit selected
<%
	}
%>
</ul>

<%@ include file="../../footer.html" %>