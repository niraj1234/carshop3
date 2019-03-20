<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.niraj.vo.*" %>

<html><head><title>employee.jsp</title>
<link href="${pageContext.request.contextPath}/css/webDesign.css" type="text/css" rel="stylesheet">
</head>

<body class="composite">

<jsp:include page="/pageComn/commonHeader.jsp"></jsp:include>
<jsp:include page="/pageComn/menu.jsp"></jsp:include>
<!-- Body part  START -->

<!-- Topic STARTS -->
<div class="section4">
<jsp:include page="/pages/employeeMenu.jsp"></jsp:include>
<div class="headingBox1">Employee Add Form</div>

<div class="blogForm">





<form:form  action="${pageContext.request.contextPath}/Employee/Add" method="POST"  modelAttribute="employee" >
<table>
    <tr><td><spring:message code="label.employeeName"/></td>  <td> <form:input  type="text" name="employeeName"  path="employeeName" placeholder="Employee Name"  /></td><td><form:errors path="employeeName" cssClass="errorFormField"  /></td></tr>
    <tr><td><spring:message code="label.email"/> </td>  <td> <form:input  type="text" name="email" path="email" /></td><td><form:errors path="email" cssClass="errorFormField"  /></td></tr>
    <tr><td><spring:message code="label.department"/> </td>  <td> <form:input  type="text" name="department" path="department" /></td><td><form:errors path="department" cssClass="errorFormField"  /></td></tr>
    <tr><td><spring:message code="label.mobile"/> </td>  <td> <form:input  type="text" name="mobile" path="mobile" /></td><td><form:errors path="mobile" cssClass="errorFormField"  /></td></tr>
    <tr><td><spring:message code="label.city"/> </td>  <td> <form:input  type="text" name="city" path="city" /></td><td><form:errors path="city" cssClass="errorFormField"  /></td></tr>
    <tr><td><spring:message code="label.salary"/> </td>  <td> <form:input  type="text" name="salary" path="salary" /></td><td><form:errors path="salary" cssClass="errorFormField"  /></td></tr>
    <tr><td><spring:message code="label.active"/> </td>  <td> <form:input  type="text" name="active" path="active" /></td><td><form:errors path="active" cssClass="errorFormField"  /></td></tr>

</table> 



<input type="submit" value="Send Data" >

</form:form>








</div>


</div>
<!-- Topic ENDS -->






<div class="footerBox">
    <a href="#">Copyright Information will be here</a>
</div>

<!-- Body part  END -->
</body></html>
