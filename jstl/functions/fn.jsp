<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../../upper.jsp" %>

<h2> JSTL Functions Test </h2>
<c:set var="s1" value="This is a JSTL Function Test"/>

<table width='750' border='0' align='left' cellpadding='5'>
	<tr bgcolor="#bdb76b" height="40">
		<td><b><center>functions</center></b></td>
		<td><b><center>Input Strings</center></b></td>
		<td colspan=2><center><b>Arguments</center></b></td>
		<td><center><b>Results</b></center></td>
	</tr>
	<tr bgcolor="white">
		<td><b>length</b></td>
	    <td>${s1}</td>
		<td colspan=2></td>
	    <td>${fn:length(s1)}</td>
	</tr>
	<tr bgcolor="f5f5dc">
		<td><b>toLowerCase</b></td>
	    <td>${s1}</td>
		<td colspan=2></td>
	    <td>${fn:toLowerCase(s1)}</td>
	</tr>
	<tr bgcolor="white">
		<td><b>toUpperCase</b></td>
	    <td>${s1}</td>
		<td colspan=2></td>
	    <td>${fn:toUpperCase(s1)}</td>
	</tr>
	<tr bgcolor="f5f5dc">
		<td><b>substring</b></td>
		<td>${s1}</td>
	    <td>11</td>
	    <td>17</td>
	    <td>${fn:substring(s1, 11, 17)}</td>
	</tr>
	<tr bgcolor="white">
		<td rowspan=2><b>substringAfter</b></td>
	    <td>${s1}</td>
	    <td colspan=2>This</td>
		<td>${fn:substringAfter(s1, "This")}</td>
	</tr>
	<tr bgcolor="white">
	    <td>${s1}</td>
	    <td colspan=2>empty string</td>
	    <td>${fn:substringAfter(s1, "")}</td>
	</tr>
	<tr bgcolor="f5f5dc">
		<td><b>substringBefore</b></td>
	    <td>${s1}</td>
	    <td colspan=2>JSTL</td>
	    <td>${fn:substringBefore(s1, "JSTL")}</td>
	</tr>
	<tr bgcolor="white">
		<td><b>replace</b></td>
		<td>${s1}</td>
		<td>s</td>
		<td>*</td>
		<td>${fn:replace(s1, "s", "*")}</td>
	</tr>
	<tr bgcolor="f5f5dc">
		<td rowspan=2><b>contains</b></td>
	    <td>${s1}</td>
	    <td colspan=2>JSTL</td>
	    <td>${fn:contains(s1, "JSTL")}</td>
	</tr>
	<tr bgcolor="f5f5dc">
	    <td>${s1}</td>
	    <td colspan=2>jstl</td>
	    <td>${fn:contains(s1, "jstl")}</td>
	</tr>
	<tr bgcolor="white">
		<td rowspan=2><b>containsIgnoreCase</b></td>
	    <td>${s1}</td>
	    <td colspan=2>JSTL</td>
	    <td>${fn:containsIgnoreCase(s1, "JSTL")}</td>
	</tr>
	<tr bgcolor="white">
	    <td>${s1}</td>
	    <td colspan=2>jstl</td>
	    <td>${fn:containsIgnoreCase(s1, "jstl")}</td>
	</tr>
	<tr bgcolor="f5f5dc">
		<td rowspan=2><b>startsWith</b></td>
	    <td>${s1}</td>
	    <td colspan=2>This is</td>
	    <td>${fn:startsWith(s1, "This is")}</td>
	</tr>
	<tr bgcolor="f5f5dc">
	    <td>${s1}</td>
	    <td colspan=2>JSTL</td>
	    <td>${fn:startsWith(s1, "JSTL")}</td>
	</tr>
	<tr bgcolor="white">
		<td rowspan=2><b>endsWith</b></td>
	    <td>${s1}</td>
	    <td colspan=2>JSTL</td>
	    <td>${fn:endsWith(s1, "JSTL")}</td>
	</tr>
	<tr bgcolor="white">
	    <td>${s1}</td>
	    <td colspan=2>Test</td>
	    <td>${fn:endsWith(s1, "Test")}</td>
	</tr>
	<tr bgcolor="f5f5dc">
		<td rowspan=2><b>indexOf</b></td>
	    <td>${s1}</td>
	    <td colspan=2>JSTL</td>
	    <td>${fn:indexOf(s1, "JSTL")}</td>
	</tr>
	<tr bgcolor="f5f5dc">
	    <td>${s1}</td>
	    <td colspan=2>Test</td>
	    <td>${fn:indexOf(s1, "Test")}</td>
	</tr>
</table>

<%@ include file="../../footer.html" %>

