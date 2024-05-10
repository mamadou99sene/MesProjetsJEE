<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    
        <form action="recherche" method="post" >
	     <div class="mb-3">
	       
	         <input type="text" name="rechercher" placeholder="rechercher votre appartement ici" required="required" class="form-control">
	          <span id="manquant"></span>
	   
	     </div>
	     <div>

	         <input type="submit" name="submit" value="Rechercher" id="submit" class="btn btn-success">

	     </div>
	  </form>
    </div>
    
</body>
</html>