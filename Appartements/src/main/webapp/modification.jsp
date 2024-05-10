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
  
	    <form method="post" id="form" action="modification" class="form-responsive" >
	   	<div class="col-sm-6">
	  		<label for="libelle" class="form-label">Libelle</label>
	  			<input type="text" name="libelle" required="required" id="libelle" class="form-control" value="${libelle }">
	  	</div>
	    <div class="col-sm-6">
	    	 <label for="nom">nomImmeuble</label>
	    	  <input type="text" name="nom" required="required" class="form-control" value="${nom }">
	    </div>
	    <div class="mb-3">
	    	<label for="type">Type</label>
	    	<select name="type" required="required">
	    		<option value="villa" selected="selected">Villa</option>
	    		<option value="terrain">Terrain</option>
	    		<option value="studio">Studio</option>
	            <option value="appartement">appartement</option>
	    	</select>
	    </div>
	    <div class="col-sm-6">
	    	<label for="superficie">Superficie</label>
	    		<input type="number" name="superficie" required="required" class="form-control">
	    	
	    </div>
	    <div class="col-sm-6">
	    	<label for="nombre">Nombre de Pieces</label>
	    	<input type="number" name="nombre"  class="form-control" onblur="document.getElementById('prix').focus();">
	    </div>
	    <div class="col-sm-6">
	    	<label for="prix">Prix</label>
	    	<input type="number" name="prix" required="required" id="prix" class="form-control" value="${prix}">
	    </div>
	    <div class="col-md-6">
	    	<label for="description">Description</label>
	    	<textarea name="description" cols="40" rows="10" placeholder="description" class="form-control"
	    	 value="${description }"></textarea>
	    </div>
	    <div class="col-sm-6">
	      <label for="adresse">Adresse</label>
	      <input type="text" name="adresse"  class="form-control">
	    </div>
	    <div class="col-sm-6">
	      <label for="quartier">Quartier</label>
	      <input type="text" name="quartier" class="form-control" value="${quartier }">
	    </div>
	    <div class="col-sm-6">
	      <label for="ville">Ville</label>
	      <input type="text" name="ville" class="form-control" value="${ville}">
	    </div>
	   	<div class="col-sm-8">
	   		<label for="submit"></label>
	   		<input type="submit" name="submit" value="Envoyer" id="submit"  class="btn btn-outline-success">
	   		<input type="reset" name="" value="Annuler" class="btn btn-outline-danger">
	   	</div>
	   </form>
    </div>
</body>
</html>