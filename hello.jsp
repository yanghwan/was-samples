<%@ page contentType="text/html;charset=EUC-KR"  %>

<%@ page import = "java.rmi.*,
                   javax.naming.*,
                   javax.rmi.*,
                   java.net.*,                   
                   javax.ejb.*,
                   java.util.*"
					
%>

<head>
<title>Hello World!</title>
</head>

<body bgcolor="#DCDCDC" TEXT="#000000" LINK="#0000EE" VLINK="#551A8B" ALINK="#FF0000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<br><br><div align="center"><img src="./images/Splash.gif"></div>
<h2 align="center">
<br>JEUS Web Application Server is successfully Installed on this server!</h2>
<h2 align="center">
<br>
    <%

	Context ctx = new InitialContext();
	helloejb.Hello hello = (helloejb.Hello)ctx.lookup("helloejb.HelloApp");
	out.println("EJB output : "+ hello.sayHello());


%>
</h2></p>
</body>
</html>


