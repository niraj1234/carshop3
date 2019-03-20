<%@page import="java.util.Hashtable" %>
<%@page import="java.util.ArrayList" %>
<%@page import="org.niraj.vo.*" %>

<% String pageCtx = request.getContextPath();
   CompanyUserVO companyUser = (CompanyUserVO)request.getSession().getAttribute("USER");
%>

<div class="moduleHeaderBox">
   <%--   <img src="${pageContext.request.contextPath}/images/logo-newsgear-3.png" > --%>
     <img src="${pageContext.request.contextPath}/images/logo-spring-a.png" >

     <a href="<%=response.encodeURL(pageCtx+"/")%>">Home</a>

<% if(companyUser != null){%>
     <a href="<%=response.encodeURL(pageCtx+"/Logout")%>">Logout</a>	
<%}else{%>
	
<%}%>
    


</div>
