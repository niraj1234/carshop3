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
<div class="headingBox1">Company View</div>

<div class="blogForm">

<%  String pageCtx = request.getContextPath(); %>
<% 
   String totalTime = (String)request.getAttribute("TotalTime");
   ArrayList<CompanyVO> companyList = (ArrayList<CompanyVO>)request.getAttribute("CompanyList");
%>

Total Time taken in the Process => <%=totalTime%><br><br>

<% if(companyList.size() >0 ){
	for(CompanyVO cVo : companyList){%>
<div style="border: 2px solid #808080 ;margin-top: 10px; width:310px; height:300px; float:left; margin:5px;">            
     <div class="article">
       <h2 class="article-title"><a title="this will be title" rel="bookmark"><%= cVo.getCompanyName()%></a></h2>
           <div class="index-author-comments-date">
              <span class="author-name"><%= cVo.getCity() %>&nbsp;&nbsp;</span><span class="author-name"><%= cVo.getContactEmail() %></span>&nbsp;&nbsp;<%= cVo.getNoOfEmployees()%><br>
              <span class="author-name"><%= cVo.getBusinessCategory() %></span>&nbsp;&nbsp;<%=cVo.getFounder() %></div></span></div>
           <p><%= cVo.getWebsiteAddress() %></p>
           <div class="read-more3">
                  <a href="<%=response.encodeURL(pageCtx+"/Company/Update/"+cVo.getCompanyId())%>">Update</a> 
                  <a href="<%=response.encodeURL(pageCtx+"/Company/Delete/"+cVo.getCompanyId())%>">Delete</a> 
           </div>
     </div>

<%  } 
 }%>

</div>


</div>
<!-- Topic ENDS -->






<div class="footerBox">
    <a href="#">Copyright Information will be here</a>
</div>

<!-- Body part  END -->
</body></html>
