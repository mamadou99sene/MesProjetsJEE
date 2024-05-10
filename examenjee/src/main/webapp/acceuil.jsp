<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- Page acceuil.jsp -->
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form action="CalculeServlet" method="post">
    <div>
       <label>Saisir votre login</label>
       <input type="text" name="login" placeholder="Votre login ici">
    </div>
    <div>
       <label>Saisir votre mot de passe</label>
       <input type="password" name="password" placeholder="Votre mot de passe ici">
    </div>
    <div>
       <input type="submit" Value="Se connecter">
    </div>
  </form>
</body>
</html>