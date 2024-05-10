<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="bootstrap.css">
<link rel="stylesheet" type="text/css" href="styleIndex.css">
</head>
<body>
   <div class="container">
      <form class="form mt-3 pt-2" action="inscription" method="post">
        <div class="mb-3">
           <label></label>
           <input type="text" name="prenom" placeholder="prenom" class="form-control-sm col-sm-6">
        </div>
        <div class="mb-3">
           <label></label>
           <input type="text" name="nom" placeholder="NOM" class="form-control-sm col-sm-6">
        </div>
        <div class="mb-3">
           <label></label>
           <input type="tel" name="telephone" placeholder="telephone" class="form-control-sm col-sm-6">
        </div>
        <div class="mb-3">
           <label></label>
           <input type="text" name="login" placeholder="login" class="form-control-sm col-sm-6">
        </div>
        <div class="mb-3">
           <label></label>
           <input type="password" name="password" placeholder="password" class="form-control-sm col-sm-6">
        </div>
        <div class="mb-3">
           <label></label>
           <input type="submit" class="btn btn-outline-success" value="Enregistrer">
            <input type="reset" class="btn btn-outline-danger" value="Effacer">
        </div>
      </form>
   </div>
</body>
</html>