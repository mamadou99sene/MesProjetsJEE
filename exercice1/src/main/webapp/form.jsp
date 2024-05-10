<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link>
</head>
<body>
     <c:if test="${ ! empty att.getResultat() }">
     <p>
        <c:out value=" ${att.getResultat()}" />
     </p>
     </c:if>
    
    <form method ="post" action = "form" >
    <p>
      LOGIN <input type ="text" name = "log">
    </p> 
     <p>Password <input type ="password" name = "pass">
     </p>
      <p> <input type ="submit" name = "Envoyer" value = "Envoyer">
      </p>
    </form>
</body>
</html>