<html>

<% 
   	double freeMem = Runtime.getRuntime().freeMemory();
   	double totlMem = Runtime.getRuntime().totalMemory();
   	double percent = freeMem/totlMem;
   
   	if (percent > 0.5) 
   	{ 
%>

		<jsp:forward page="two.jsp"/> 
<% 	} 
	else 
	{ 
%>

		<jsp:forward page="one.jsp"/>
<% 	} %>

</html>
