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
<div class="headingBox1">Welcome Page Employee Module</div>

<div class="blogForm">
${MyName}

</div>

</div>
<!-- Topic ENDS -->


<div class="footerBox">
    <a href="#">Copyright Information will be here</a>
</div>

<!-- Body part  END -->
</body></html>
