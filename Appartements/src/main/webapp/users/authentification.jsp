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
  <div class="container">
   	  <form action="authentification" method="post" class="form justify-content-center"  class="aligncenter">
   	  <div class="mb-3">
   	  	 <label class="form-label"></label>
   	  	 <input type="text" name="login" class="form-control" placeholder="Entrer votre login" class="col-sm-6"/>
   	  </div>
   	   <div class="mb-3">
   	  	 <label class="form-label"></label>
   	  	 <input type="password" name="password" class="form-control" placeholder="Entrer votre mot de passe" class="col-sm-6">
   	  </div>
   	   <div class="mb-3">
   	  	 <label class="form-label"></label>
   	  	 <input type="submit" name="" value="Se connecter" class="btn btn-outline-success">
   	  	 <a href="inscription"  type="button" class="btn btn-outline-primary">Creer compte</a>
   	  </div>
   </form>
   </div>
</body>
</html>