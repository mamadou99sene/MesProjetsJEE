<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="bootstrap.css">
</head>
<body>
     <div class="container mt-2 text-white bg-dark border rounded-pill">
         <p>
            Reservation numero ${numero}: effectuée par le client ${ prenom_user } ${nom_user }
             <br>reservé: ${heure }
             
         </p>
         
     </div>
     <div class="container">
        <a href="tel: ${telephone_user }" class="btn btn-outline-success">Appeler ${prenom_user }</a>
     </div>
</body>
</html>