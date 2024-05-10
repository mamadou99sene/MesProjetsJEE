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
    <div class="container-fluid">
        <div class="col-sm-4 mx-auto "  style="display:inline-flex; border:1px solid black; margin:2%;">
            <a href="users_details?id=${id }">
              <span>${nom_app }</span>
              <span class="text-white bg-success row">type: ${ type}</span>
              <span class="text-white bg-success row">Localisation: ${ ville}</span>
              <span class="text-danger row">${ prix} FCFA</span>
           </a>
        </div>
    </div>
</body>
</html>