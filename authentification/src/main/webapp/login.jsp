<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='style.css'/>
</head>
<body>
	
   <form method ="post" action = "login" >
   <% if(request.getAttribute("error")!=null)
	{
		String message=(String)request.getAttribute("error");
		out.println(message);
	}
		%>
    <p>
       <label for="login">Email</label>
       <input type ="text" name = "email" id="email" placeholder="votre email">
    </p> 
     <p>
     <label for="password">Password</label>
      <input type ="password" name = "password" id="password" placeholder="votre mot de passe">
     </p>
      <p> 
      <input type ="submit" name = "envoyer" value = "Envoyer">
      <input type ="reset" name = "annuler" value = "Annuler">
      </p>
    </form>
</body>
</html>