<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- Page bienvenue.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%
       if(request.getAttribute("message")!=null)
       {
    	   String message=(String)request.getAttribute("message");
    	   out.println(message);
       }
    %>
</body>
</html>