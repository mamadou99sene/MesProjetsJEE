<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="accueil.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="bootstrap.css">
</head>
<body>
      <div class="container">
            <p>${libelle }</p>
		      <p> ${sessionScope.nom }</p>
		       <p class="text-danger">${prix} FCFA</p>
		       <h3>description:</h3>
		       <textarea rows="8" class="form-control">
		            ${description}
		       </textarea>
      </div>
</body>
</html>