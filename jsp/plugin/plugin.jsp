
<!-- upper.jsp -->
<%@ include file="../../upper.jsp" %>

<h3> Drawing Applet : 1</h3>
<jsp:plugin type="applet" code="applet.DrawAppletOne.class" codebase="/examples/jsp/plugin" jreversion="1.3" width="400" height="300" >
    <jsp:params>
        <jsp:param name="test" value="<%=new String(\"ttest\")%>"/>
    </jsp:params>
    <jsp:fallback>
        Plugin tag OBJECT or EMBED not supported by browser.
    </jsp:fallback>
</jsp:plugin>
<p>
<h4>
<font color=red> 
The above applet is loaded using the Java Plugin from a jsp page using the
plugin tag.
</font>
</h4>

<!-- footer.html -->
<%@ include file="../../footer.html" %>
 