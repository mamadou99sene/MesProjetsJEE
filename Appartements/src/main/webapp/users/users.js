var reservation=document.getElementById("reservation");
reservation.addEventListener("click",function(e)
{
	reservation.textContent="Reservation effectuéé";
    reservation.style.color="red";
    reservation.style.fontSize="18px";
    reservation.style.fontWeight="bold";
},false);