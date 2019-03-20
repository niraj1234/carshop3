<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.niraj.vo.*" %>

<html><head><title>login.jsp</title>
<link href="${pageContext.request.contextPath}/css/webDesign.css" type="text/css" rel="stylesheet">
</head>

<body class="composite">

<jsp:include page="/pageComn/commonHeader.jsp"></jsp:include>
<jsp:include page="/pageComn/menu.jsp"></jsp:include>
<!-- Body part  START -->

<!-- Topic STARTS -->
<div class="section4">
<div class="headingBox1">Login Page</div>

<% String userMessage = (String)request.getAttribute("USER_MESSAGE") ;%>

<div class="blogForm">

<form:form  action="${pageContext.request.contextPath}/Login" method="POST" modelAttribute="login" >
<table>
	<%if(null != userMessage){%>
	    <tr>
	        <td><%=userMessage%></td>
	    </tr>	
	<%} %>
    <tr>
        <td><spring:message code="label.userName"/></td>
        <td><form:input  type="text" name="userName"  path="userName" placeholder="User Name" /></td>
        <td><form:errors path="userName" cssClass="errorFormField"  /></td>
    </tr>
    <tr>
        <td><spring:message code="label.password"/></td>
        <td><form:input  type="text" name="password"  path="password" placeholder="Password" /></td>
        <td><form:errors path="password" cssClass="errorFormField"  /></td>
    </tr>
</table> 

<input type="submit" value="Login" >
</form:form>
</div>


</div>
<!-- Topic ENDS -->






<div class="footerBox">
    <a href="#">Copyright Information will be here</a>
</div>

<!-- Body part  END -->
</body></html>
