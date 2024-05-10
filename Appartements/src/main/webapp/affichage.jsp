<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="bootstrap.css">
<link rel="stylesheet" type="text/css" href="style.css">
 <script type="text/javascript" src="essai.js"></script>
<title>Insert title here</title>
</head>
<body>
    <div class="container">
       <div class="container table-responsive mx-auto">
           <table class="table table-bordered table-striped">
		     <!--  <thead>
		         <tr>
		           <th>libelle</th>
		           <th>nom</th>
		           <th>prix</th>
		           <th>ville</th>
		           <th>quartier</th>
		           <th>details</th>
		         </tr>
		      </thead>  -->
		      <tbody>
		        <tr>
		           <td>${libelle}</td>
		           <td>${nom}</td>
		           <td>${prix} FCFA</td>
		           <td>${ville}</td>
		           <td>${quartier}</td>
		            <td>
		                <a href="details?id=${id}" id="detail">
		                   <button class="btn btn-outline-success">details</button>
		                </a>
		                <a href="modification?id=${id }" onclick="return confirmer();">
		                  <button class="btn btn-primary">modifier</button>
		                </a>
		                <a href="suppression?id=${id }">
		                   <button class="btn btn-outline-danger">supprimer</button>
		                </a>
		            </td>
		        </tr>
		      </tbody>
    </table>
       </div>
    </div>
    <script type="text/javascript">
    </script>
</body>
</html>