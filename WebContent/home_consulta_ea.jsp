 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" http-equiv="Content-Type" content="text/html; charset=ISO-8859-1; device-width; initial-scale=1; shrink-to-fit=no">
<title>Consulta Estado Academico</title>

   
    <link rel="stylesheet" href="css/bootstrap.min.css">
      <link rel="stylesheet" href="css/login_css.css" id="bootstrap-css">

    <style>

   
    .tamañobton{
    
    width: 100px;
    
    height: 40px;
    
    
    } 
         
  </style>

</head>
<body>


          <nav  class="navbar navbar-inverse bg-inverse navbar-toggleable-sm sticky-top">
           <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button> 

      
          <div class="collapse navbar-collapse" id="navbarSupportedContent" >
         
          <div class="navbar-nav mr-auto ml-auto text-center">
             
          <a class="nav-item nav-link m-2" href="home_principal.jsp">
          HOME</a>
    
         <li class="nav-item dropdown">
        
          <a class="dropdown">
        
          <a class="nav-link m-2 dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          ALUMNO  </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
        
          <a class="dropdown-item" href="home_alta.jsp">Registrar Alumno</a>
          <a class="dropdown-item" href="ControladorAlumnos">Editar Alumno</a>
          
          
          
           <form action="ControladorAlumnos" method="get" id="form"> 
            
           <input type="hidden" name="instruccion" value="listaralumateria">
         
        
          <a class="dropdown-item" href="#" onclick="javascript:document.getElementById('form').submit(); return false;">Inscripcion a Materia</a>
     
          </form>  
           
       
          </li> </a>
           
         	    
           <li class="nav-item dropdown">
        
          <a class="dropdown">
        
          <a class="nav-link m-2 dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          REPORTES  </a>
         <div class="dropdown-menu" aria-labelledby="navbarDropdown">
       
        
          <form action="ControladorAlumnos" method="get" id="form2"> 
            
           <input type="hidden" name="instruccion" value="obtenerAlumnosEstadoAcad">
         
        
          <a class="dropdown-item" href="#" onclick="javascript:document.getElementById('form2').submit(); return false;">Estado Academico</a>
     
          </form>  
         
         
          
          <form action="ControladorAlumnos" method="get" id="form1"> 
            
           <input type="hidden" name="instruccion" value="obtenercursos">
         
        
          <a class="dropdown-item" href="#" onclick="javascript:document.getElementById('form1').submit(); return false;">Cursos</a>
     
          </form>  
  

           </li> </a>
         
           </div>
        
           </div>
    
           </nav>

        <section class="container mt-5">

  
          
          <h4>Datos Estado Academico</h4>
 
                         
              <table class="table table-bordered table-dark table-hover">
                <thead>
                  <tr class="bg-warning">
                   
               
                     <th scope="col">CURSO</th>
                     <th scope="col">CARRERA</th>
                     <th scope="col">PROMEDIO</th>
                
                    
                  </tr>
                </thead>
                
              <c:forEach var="datosestado" items="${DATOS_ESTADO_ACADEMICO}">  
                 
 
              
                <tbody>
                  <tr >
                
                    
                    <td class="color-td">${datosestado.nombrecurso}</td>
                    <td class="color-td">${datosestado.nombrecarrera}</td>
                    <td class="color-td">${datosestado.promedio}</td>
                   
                  
    
                
                  </tr>
               
                 
     
	 </tbody>
	</c:forEach> 
	
	</table>
	
	 <input name"btn_volver" type="button" class="btn btn-secondary mb-5 mt-4" value="Volver" onclick="history.back()">
        </section>
    

           


    <!-- jQuery first, then Tether, then Bootstrap JS. -->
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</body>
</html>