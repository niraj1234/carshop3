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
<div class="headingBox1">Employee View Page</div>

Data from ModelAndView2 : ${MyName2} <br>

<div class="blogForm">
<%  String pageCtx = request.getContextPath(); %>

<% 
ArrayList<EmployeeVO> employeeList = (ArrayList<EmployeeVO>)request.getAttribute("employeeList") ; 

for(int i=0; i< employeeList.size();i++){
	EmployeeVO empVo = (EmployeeVO)employeeList.get(i);%>
	

<div style="border: 2px solid #808080 ;margin-top: 10px; width:310px; height:300px; float:left; margin:5px;">            
     <div class="article">
       <h2 class="article-title"><a title="this will be title" rel="bookmark"><%= empVo.getEmployeeName()%></a></h2>
           <div class="index-author-comments-date">
              <span class="author-name"><%= empVo.getCity() %>&nbsp;&nbsp;</span><span class="author-name"><%= empVo.getDepartment() %></span>&nbsp;&nbsp;<%= empVo.getEmployeeId() %><br>
              <span class="author-name"><%= empVo.getEmail() %></span>&nbsp;&nbsp;<%= empVo.getActive() %></div></span></div>
           <p><%= empVo.getMobile() %></p>
           <div class="read-more3">
                  <a href="<%=response.encodeURL(pageCtx+"/Employee/Update/"+empVo.getEmployeeId())%>">Update</a> 
                  <a href="<%=response.encodeURL(pageCtx+"/Employee/Delete/"+empVo.getEmployeeId())%>">Delete</a> 
           </div>
     </div>
<%}%>


</div>




</div>
<!-- Topic ENDS -->


<div class="footerBox">
    <a href="#">Copyright Information will be here</a>
</div>

<!-- Body part  END -->
</body></html>
