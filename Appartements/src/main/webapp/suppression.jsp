<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="accueil.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="bootstrap.css">
<link rel="stylesheet" type="text/css" href="styleAjout.css">
</head>
<body>
   <div class="container">
      
      <form action="suppression" method="post">
         <input type="submit" value="Confirmer" class="btn btn-outline-success" name="confirmer"/>
      </form>
      <form action="appartement" method="get">
         <input type="submit" value="Annuler" class="btn btn-outline-danger" />
      </form>
   </div>
</body>
</html>