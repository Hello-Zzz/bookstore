<%--
  Created by IntelliJ IDEA.
  User: zhao1
  Date: 2021/5/20
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://" + request.getServerName()
            + ":" + request.getServerPort()
            + request.getContextPath() + "/";
    pageContext.setAttribute("basePath", basePath);
%>
<%--<%= basePath %>--%>

<base href="<%= basePath %>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src = "static/script/http_code.jquery.com_jquery-3.3.1.js"></script>