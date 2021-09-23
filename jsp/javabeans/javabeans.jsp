<jsp:useBean id="stat" class="javabeans.StatBean">
	<jsp:setProperty name="stat" property="numbersList" 
		value="100,250,150,50,450" />
</jsp:useBean>

<!-- upper.jsp -->
<%@ include file="../../upper.jsp" %>

The average of <jsp:getProperty name="stat" property="numbersList" /> is
equal to <jsp:getProperty name="stat" property="average" />

<!-- footer.html -->
<%@ include file="../../footer.html" %>
 