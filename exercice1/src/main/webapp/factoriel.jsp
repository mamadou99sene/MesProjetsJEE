<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Formulaire de devinette de nombre </h1> 
   <form method ="post" action ="factoriel" >
    <p>
       Entrer un nombre: <input type ="number" name = "nombre">
    </p> 
     <p> <input type ="submit" name = "Envoyer" value = "Envoyer"> </p>
    </form> 
    <c:if test="${ !empty factoriel }">
    <p>
      Le factoriel de ce nombre est de ${ factoriel }
    </p>
</c:if>

   <%
   if(request.getAttribute("factoriel")!=null)
   {
	   int factoriel=(int)request.getAttribute("factoriel");
	   out.println("Le factoriel est egale a "+factoriel);
   } 
   %>
</body>
</html>