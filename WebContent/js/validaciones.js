function validar() {  /*
	var nomape, legajo, email, curso, materia, notauno, notados, notatres, notacuatro, notacinco;
	nomape = document.getElementById("nomape").value;
	legajo = document.getElementById("legajo").value;
	email = document.getElementById("email").value;
	curso = document.getElementById("curso").value;
	materia = document.getElementById("materia").value;
	notauno = document.getElementById("notauno").value;
	notados = document.getElementById("notados").value;
	notatres = document.getElementById("notatres").value;
	notacuatro = document.getElementById("notacuatro").value;
	notacinco = document.getElementById("notacinco").value;
	
	//Expresión que permite usar el formato de email textoonumeros@texto.texto
	expresionEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
	
	//Expresión que permite usar formato numérico en el legajo
	expresionNumeros = /^([0-9])*$/;
	
	//Expresión que permite usar el formato de número decimal en las notas de los alumnos
	expresionDecimal = /^\d*\.?\d*$/;
	
	if(nomape === "" || legajo === "" || email === "" || curso === "0" || materia === "0" || notauno === "" || notados === "" || notatres === "" || notacuatro === "" || notacinco === ""){
		alert("Todos los campos son obligatorios");
		return false;
	}
	else if(nomape.length>80) {
		alert("El nombre es muy largo");
		return false;
		}
	else if(legajo.length>10) {
		alert("El legajo es muy largo");
		return false;
		}
	else if(email.length>60) {
		alert("El email es muy largo");
		return false;
		}
	
	//Formato de email:
	else if(!expresionEmail.test(email)) {
		alert("El email ingresado no tiene el formato correcto");
		return false;
	}
	
	//Permite solamente ingresar números en el legajo:
	else if(!/^([0-9])*$/.test(legajo)) {
		alert("El legajo debe ser numérico");
		return false;
	}
	
	//No permitir notas menores a 1 y mayores que 10
	else if(notauno<1 || notauno>10) {
	alert("Ingrese notas entre 1 y 10");
	return false;
	}
	
	else if(notados<1 || notados>10) {
	alert("Ingrese notas entre 1 y 10");
	return false;
	}
	
	else if(notatres<1 || notatres>10) {
	alert("Ingrese notas entre 1 y 10");
	return false;
	}
	
	else if(notacuatro<1 || notacuatro>10) {
	alert("Ingrese notas entre 1 y 10");
	return false;
	}
	
	else if(notacinco<1 || notacinco>10) {
	alert("Ingrese notas entre 1 y 10");
	return false;
	}
	
	//Valida que se ingrese un número decimal en las notas
	else if(!expresionDecimal.test(notauno)) {
	alert("La nota debe ser numerica");
	return false;
	}
	
	else if(!expresionDecimal.test(notados)) {
	alert("La nota debe ser numerica");
	return false;
	}
	
	else if(!expresionDecimal.test(notatres)) {
	alert("La nota debe ser numerica");
	return false;
	}
	
	else if(!expresionDecimal.test(notacuatro)) {
	alert("La nota debe ser numerica");
	return false;
	}
	
	else if(!expresionDecimal.test(notacinco)) {
	alert("La nota debe ser numerica");
	return false;
	}
}    */

/*  function legajo(leg){
	$.get("/archivo?legajo=" + leg,function(data){
		if(data.status != "ok"){
			alert("el legajo " + leg + " ya existe");
			//$("#id_input").val("");
			return false;
		}else{
			return true;
		}
		
	},'json');  
	
}   */
	

	var clave, clave2;
	clave = document.getElementById("clave").value;
	clave2 = document.getElementById("clave2").value;


	if(clave === "" || clave2 === ""){
		alert("Todos los campos son obligatorios");
		return false;
	}
	else if(clave!=clave2) {
		alert("La clave no coincide");
		return false;
		}



}