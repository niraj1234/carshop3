<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.niraj.vo.*" %>

<html><head><title>companyAddForm.jsp</title>
<link href="${pageContext.request.contextPath}/css/webDesign.css" type="text/css" rel="stylesheet">
</head>

<body class="composite">

<jsp:include page="/pageComn/commonHeader.jsp"></jsp:include>
<jsp:include page="/pageComn/menu.jsp"></jsp:include>
<!-- Body part  START -->

<!-- Topic STARTS -->
<div class="section4">
<jsp:include page="/pages/companyMenu.jsp"></jsp:include>
<div class="headingBox1">Company Add Form</div>

<div class="blogForm">

<%    String totalTime = (String)request.getAttribute("TotalTime"); %>
Total Time taken in the Process => <%=totalTime%><br><br>



<form:form  action="${pageContext.request.contextPath}/Company/Add" method="POST"  modelAttribute="company" >
<table>

    <tr>
        <td><spring:message code="label.companyName"/></td>
        <td><form:input  type="text" name="companyName"  path="companyName" placeholder="Company Name" /></td>
        <td><form:errors path="companyName" cssClass="errorFormField"  /></td>
    </tr>

    <tr>
        <td><spring:message code="label.businessCategory"/></td>
        <td><form:input  type="text" name="businessCategory"  path="businessCategory" placeholder="Business Category" /></td>
        <td><form:errors path="businessCategory" cssClass="errorFormField"  /></td>
    </tr>


    <tr>
        <td><spring:message code="label.yearOfCreation"/></td>
        <td><form:input  type="text" name="yearOfCreation"  path="yearOfCreation" placeholder="Year of Creation" /></td>
        <td><form:errors path="yearOfCreation" cssClass="errorFormField"  /></td>
    </tr>


    <tr>
        <td><spring:message code="label.founder"/></td>
        <td><form:input  type="text" name="founder"  path="founder" placeholder="Founder" /></td>
        <td><form:errors path="founder" cssClass="errorFormField"  /></td>
    </tr>


    <tr>
        <td><spring:message code="label.websiteAddress"/></td>
        <td><form:input  type="text" name="websiteAddress"  path="websiteAddress" placeholder="Website Address" /></td>
        <td><form:errors path="websiteAddress" cssClass="errorFormField"  /></td>
    </tr>


    <tr>
        <td><spring:message code="label.city"/></td>
        <td><form:input  type="text" name="city"  path="city" placeholder="City" /></td>
        <td><form:errors path="city" cssClass="errorFormField"  /></td>
    </tr>


    <tr>
        <td><spring:message code="label.contactEmail"/></td>
        <td><form:input  type="text" name="contactEmail"  path="contactEmail" placeholder="Valid Email" /></td>
        <td><form:errors path="contactEmail" cssClass="errorFormField"  /></td>
    </tr>


    <tr>
        <td><spring:message code="label.noOfEmployees"/></td>
        <td><form:input  type="text" name="noOfEmployees"  path="noOfEmployees" placeholder="No of Employess" /></td>
        <td><form:errors path="noOfEmployees" cssClass="errorFormField"  /></td>
    </tr>


    <tr>
        <td><spring:message code="label.contactNumber"/></td>
        <td><form:input  type="text" name="contactNumber"  path="contactNumber" placeholder="Min 10 Digit" /></td>
        <td><form:errors path="contactNumber" cssClass="errorFormField"  /></td>
    </tr>

    
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
