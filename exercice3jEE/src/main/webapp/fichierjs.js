/**
 * 
 */
 var date=new Date();
		 	var j=date.getDate();
		 	var m=date.getMonth();
		 	var jj=date.getDay();
		 	var a=date.getFullYear();
		 	var dc= j+"/ "+m+"/ "+a;
		 	var p=document.querySelector('#dj');
		 	p.style.fontWeight="bold";
		    p.style.textAlign="center";
		 	p.style.fontSize="30px";
		 	
		 	var jss=["Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","samedi"];
		 	var mois=["janvier","fevrier","mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","Decembre"];

		 	var js=jss[jj];
            //alert(js);
		 	var ms=mois[m];
		 	d=js+ " le "+j+" "+ms+" "+a;
		 	p.innerHTML=d;
		 	
		 	
		 	var envoi=document.getElementById("submit");
var numero=document.getElementById("numero");
var manq=document.getElementById("manquant");
 envoi.addEventListener("click",function(e)
		 {
	        if(numero.validity.valueMissing)
	        	{
	        	  e.prenventDefault();
	        	  manq.textContent="Saisir le numero de compte";
	        	  manq.style.color='red';
	        	  manq.style.fontWeight='bold';
	        	  manq.style.fontStyle='italic';
	        	}
		 },
		 false);