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
    <form action="authentification" method="post">
      <div class="mb-3">
        <input type="text" name="login" class="form-control" placeholder="login">
      </div>
      <div class="mb-3">
        <input type="password" name="password" class="form-control" placeholder="mot de passe">
      </div>
      <div class="mb-3">
        <input type="submit" value="Se connecter" class="btn btn-outline-success">
      </div>
    </form>
  </div>
</body>
</html>