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
   <div class="container col-sm-12">
       <div class="mx-auto cols-sm-6">
          <Strong>${nom }</strong>
	       <br>${libelle }
	       <br>Superificie: ${ superficie } m2
	       <br>type: ${type}
	       <br>Nombre piece: ${nombre }
	       <br>Localisation: ${ville }
	       <br><strong class="text-danger">${prix } FCFA</strong></br>
       </div>
       <textarea rows="8" class="form-control">${description }</textarea>
   </div>
   <div class="container col-sm-12 mx-auto">
     <a href="reservation">
       <button class="btn btn-success col-sm-6" id="reservation">Reserver</button>
     </a>
   </div>
   <script src="users.js"></script>
</body>
</html>