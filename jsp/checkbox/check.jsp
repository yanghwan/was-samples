<!-- upper.jsp -->
<%@ include file="../../upper.jsp" %>

<FORM TYPE=POST ACTION="checkresult.jsp">
<input type="hidden" name="home" value="/examples/index.jsp">
	<BR>
		<b>Check all Favorite fruits: </b><br><br>
	
			<input TYPE=checkbox name=fruits VALUE=apples> Apples <BR>
			<input TYPE=checkbox name=fruits VALUE=grapes> Grapes <BR>
			<input TYPE=checkbox name=fruits VALUE=oranges> Oranges <BR>
			<input TYPE=checkbox name=fruits VALUE=Coconut> Coconut <BR>
			<br> <INPUT TYPE=submit name=submit Value="Submit">
</FORM>

<!-- footer.html -->
<%@ include file="../../footer.html" %>

 