<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import  = "java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="StyleIndex.css">
<script type="text/javascript" src="fichierjs.js"></script>
</head>
<body>
  <c:out value="${ cookie }" />
  
<p id="dj">	 	</p>
       <script> type="text/javascript">
		 	
      </script>
      
        
    <form action="#" method="post">
  	<p>
  		<label></label>
  		 <input type="text" name="numero" required="required" placeholder="NUMERO" id="numero"  >
  		 <span id="manquant"></span>
  	</p>
  	
  	<p>
  		<label></label>
  		<input type="submit" name="submit" value="Se connecter" id="submit">
  		<input type="reset" name="" value="Annuler">
  	</p>
  </form>
<script type="text/javascript">

</script>
</body>
</html>