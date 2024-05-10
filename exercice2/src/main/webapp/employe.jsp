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
  <form method ="post" action = "employe" >
    <p>
      <label>Prenom</label>  <input type ="text" name = "prenom">
    </p> 
     <p><label>Nom</label> <input type ="text" name = "nom">
     </p>
     <p><label>Sexe</label> <input type ="text" name = "sexe">
     </p>
     <p><label>Adresse</label> <input type ="text" name = "adresse">
     </p>
     <p><label>Pays</label> <input type ="text" name = "pays">
     </p>
      <p> <input type ="submit" name = "ajouter" value = "Ajouter" id="ajouter">
      <input type ="submit" name = "modifier" value = "Modifier" id="modifier">
      <input type ="submit" name = "afficher" value = "Afficher" id="afficher">
      </p>
      
    </form>
</body>
</html>