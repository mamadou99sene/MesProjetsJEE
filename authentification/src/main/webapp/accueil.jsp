<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="login.Personne" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body
{
  
  width:50%;
  margin: auto;
  margin-top: 5%;
  padding-top: 3%;
  padding-left:  20%;
  padding-bottom: 3%;
  border: 1px solid black;

}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <p><%
  if(request.getAttribute("success")!=null)
  {
	  Personne p=(Personne)request.getAttribute("success");
	  out.println("Bienvenu "+p.getPrenom()+" "+p.getNom()+" votre email est "+p.getEmail());
  }
  %></p>
</body>
</html>