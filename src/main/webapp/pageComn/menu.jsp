<%@ page import="java.util.Hashtable" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.niraj.vo.*" %>

<% String pageCtx = request.getContextPath();%>
<div class="moduleMenuBox">

    <a href="<%=response.encodeURL(pageCtx+"/Employee/")%>">Employee</a>
    <a href="<%=response.encodeURL(pageCtx+"/Company")%>">Company</a>
<%--     <a href="<%=response.encodeURL(pageCtx+"/Login")%>">Login</a>
    <a href="<%=response.encodeURL(pageCtx+"/Logout")%>">Logout</a>
 --%>    
<div style="clear:both;"></div>
</div>
