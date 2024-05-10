<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="stylePage.css">
</head>
<body>
Votre adresse IP est ${adreeseIP}

session de l'utilisateur ${session }
<%
String prenom=(String)request.getAttribute("prenom");
double solde=(double)request.getAttribute("solde");
out.println("bienvenu(e) "+prenom+" votre solde est de "+solde+" FCFA");
%>
Prenom: ${prenom}, Solde: ${solde}
</body>
</html>