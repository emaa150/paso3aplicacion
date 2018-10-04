package com.alumnos;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorAlumnos
 */
@WebServlet("/ControladorAlumnos")
public class ControladorAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private ModeloAlumnos modeloAlumnos;
	
	@Resource (name="jdbc/Alumnos")
	
	private DataSource miPool;
	
	
	
       
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			
			modeloAlumnos=new ModeloAlumnos(miPool);
			
	
			
		}catch(Exception e) {
			
			throw new ServletException(e);
			
			
		}
		
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorAlumnos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		//LEER EL PARAMETRO HIDDEN DEL FORMULARIO
		
		String elComando=request.getParameter("instruccion");
		
		// SI EL PARAMETRO NO SE ENVIA , LISTAR LOS ALUMNOS
		
		if(elComando==null) elComando="listar";
		
		
		// REDIRIGIR EL FLUJO DE EJECUCION AL METODO CORRESPONDIENTE
		
		
		switch (elComando){
		
		//ESTE METODO INSERTA UN NUEVO ALUMNO
			
		case "insertaralumno":
			
			try {
				agregarAlumnos(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			break;
			
		case "listar":
			
        	try {
				obtenerAlumnos(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			break;	
			
        case "cargaralumno":
			
        	try {
				cargarDatosAlumno(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			break;		
			
			
        case "actualizaralumno":
			
        	try {
				ActualizarDatosAlumno(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
         case "listaralumateria":
			
        	try {
				ListarAlumnosMateria(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
			
         case "cargarmaterias":
 			
         	try {
 				cargarMaterias(request, response);
 			} catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 			break;		
 			
         case "guardarinscripcionmateria":
  			
          	try {
  				guardarInscripcionMateria(request, response);
  			} catch (Exception e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  			break;	
  			
  			
         case "obtenercursos":
   			
           	try {
   				obtenerDatosdeCurso(request, response);
   			} catch (Exception e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
   			break;	
   			
         case "obtenerdatosdecurso":
    			
            	try {
    				obtenerLosParametrosdelCursoSeleccionado(request, response);
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			break;	
    			
         
         case "obtenerAlumnosEstadoAcad":
 			
         	try {
         		obtenerAlumnosParaEstadoAcademico(request, response);
 			} catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 			break;	
 			
         case "obtenerDatosEA":
  			
          	try {
          		DatosEstadoAcademicoAlumno(request, response);
  			} catch (Exception e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  			break;	
			
		}	
		
	}
	
	
	private void DatosEstadoAcademicoAlumno(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		
		int alumno_id=Integer.parseInt(request.getParameter("id_alumno"));
		
		List<Alumnos> datosEA;
	
	
		
		datosEA=modeloAlumnos.obtenerDatosEstadoAcademico(alumno_id);
	
		
	   
		request.setAttribute("DATOS_ESTADO_ACADEMICO", datosEA);
	
		
		
	    RequestDispatcher miDispatcher=request.getRequestDispatcher("/home_consulta_ea.jsp");
		
		
		miDispatcher.forward(request, response);
		
		
		
		
		
	}

	private void obtenerAlumnosParaEstadoAcademico(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		List<Alumnos> alumnos;
		
		alumnos=modeloAlumnos.obtenerAlumnos();
		
		request.setAttribute("LISTA_ALUMNOS", alumnos);
		
		
		RequestDispatcher miDispatcher=request.getRequestDispatcher("/home_planilla3.jsp");
		
		
		miDispatcher.forward(request, response);
		
		
		
		
		
		
	}

	private void obtenerLosParametrosdelCursoSeleccionado(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		int id_curso=Integer.parseInt(request.getParameter("id_curso"));
		
		int id_docente=Integer.parseInt(request.getParameter("docente_id"));
		
		

		
		   List<Alumnos> cosulta;
		   
			  
		   cosulta=modeloAlumnos.obtenerLosParametrosDelCurso(id_curso, id_docente);
			
			request.setAttribute("CONSULTA_CURSO", cosulta);
			
			
			
			RequestDispatcher miDispatcher=request.getRequestDispatcher("/home_consulta_curso.jsp");
			
			
			miDispatcher.forward(request, response);
		
	
	
	
	}

	private void obtenerDatosdeCurso(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		     List<Alumnos> materias;
			
		    int alumno_id=0;
		     
		     materias=modeloAlumnos.obtenerMaterias(alumno_id);
			
			request.setAttribute("LISTA_MATERIAS", materias);
			
			
			
			RequestDispatcher miDispatcher=request.getRequestDispatcher("/home_cursos.jsp");
			
			
			miDispatcher.forward(request, response);
		
		
		
		
		
	}

	private void guardarInscripcionMateria(HttpServletRequest request, HttpServletResponse response) throws Exception {


		int alumno_id=Integer.parseInt(request.getParameter("id_alumno"));
		
		int curso_id=Integer.parseInt(request.getParameter("id_curso"));
		
		
		SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fecha = null;
		
		fecha = formatofecha.parse(request.getParameter("fecha_hoy"));
		
	
	
		Alumnos GuardarMateria=new Alumnos(alumno_id,fecha ,curso_id);
			
		
			
				
		modeloAlumnos.InscribirMateriaAlumno(GuardarMateria);
				
				
		 response.sendRedirect("home_principal.jsp"); 
			
	
	}

	private void cargarMaterias(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	
		int alumno_id=Integer.parseInt(request.getParameter("alumno_id"));
		
		
		    List<Alumnos> materias;
			
		    materias=modeloAlumnos.obtenerMaterias(alumno_id);
			
			request.setAttribute("LISTA_MATERIAS", materias);
			
			request.setAttribute("alumnoid", alumno_id);
			
			
			RequestDispatcher miDispatcher=request.getRequestDispatcher("/home_materias.jsp");
			
			
			miDispatcher.forward(request, response);
		
	
		
		
	}

	private void ListarAlumnosMateria(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		
         List<Alumnos> alumnos;
		
		alumnos=modeloAlumnos.obtenerAlumnos();
		
		
		request.setAttribute("LISTA_ALUMNOS", alumnos);
		
	
		
		
		RequestDispatcher miDispatcher=request.getRequestDispatcher("/home_planilla2.jsp");
		
		
		miDispatcher.forward(request, response);
		
		
		
		
	}

	private void ActualizarDatosAlumno(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
	    int persona_id=Integer.parseInt(request.getParameter("id_persona"));
		
		int alumno_id=Integer.parseInt(request.getParameter("id_alumno"));
		
        String Nombre=request.getParameter("nombre");
		
		String Apellido=request.getParameter("apellido");
		
		int nrodoc=Integer.parseInt(request.getParameter("nro_documento"));
		
		int legajo=Integer.parseInt(request.getParameter("legajo"));
		
		String tipodoc=request.getParameter("tipodoc");
		
		SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fechanac = null;
		
	
		fechanac = formatofecha.parse(request.getParameter("fecha_nac"));
	
		
		Alumnos AlumnoActualizado=new Alumnos(persona_id, alumno_id, Nombre, Apellido, tipodoc, nrodoc, fechanac, legajo);
		
		
		modeloAlumnos.ActualizarDatosDelAlumno(AlumnoActualizado);
		
		
		
	
			obtenerAlumnos(request, response);
	
		
		
	}

	private void cargarDatosAlumno(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		int id_persona=Integer.parseInt(request.getParameter("id_persona"));
		
		int id_alumno=Integer.parseInt(request.getParameter("id_alumno"));
		
		
		Alumnos obtenerAlumno=modeloAlumnos.obtenerDatosDelAlumno(id_persona,id_alumno);
		
		request.setAttribute("AlumnoActualizar", obtenerAlumno);
		
		
       RequestDispatcher miDispatcher=request.getRequestDispatcher("/home_modif_alumno.jsp");
		
		
		miDispatcher.forward(request, response);
		
		
	}

	private void obtenerAlumnos(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		
		
		List<Alumnos> alumnos;
		
		alumnos=modeloAlumnos.obtenerAlumnos();
		
		request.setAttribute("LISTA_ALUMNOS", alumnos);
		
		
		RequestDispatcher miDispatcher=request.getRequestDispatcher("/home_planilla.jsp");
		
		
		miDispatcher.forward(request, response);
		
		
			
		
	}

	private void agregarAlumnos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		// LEER LAS VARIABLES QUE VIENEN DEL FORMULARIO
		
		
		String Nombre=request.getParameter("nombre");
		
		String Apellido=request.getParameter("apellido");
		
		int nrodoc=Integer.parseInt(request.getParameter("nro_documento"));
		
		int legajo=Integer.parseInt(request.getParameter("legajo"));
		
		String tipodoc=request.getParameter("tipodoc");
		
		SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fechanac = null;
	
		fechanac = formatofecha.parse(request.getParameter("fecha_nac"));
	
		
	
		// CREAR UN OBJETO DEL TIPO ALUMNOS
		
		Alumnos NuevoAlumno=new Alumnos(Nombre, Apellido, tipodoc, nrodoc, fechanac, legajo);
		
		// ENVIAR EL OBJETO AL MODELO ALUMNOS Y DESPUES INSERTAR EL ALUMNO EN LA BASE DE DATOS
		
		
		modeloAlumnos.InsertarAlumno(NuevoAlumno);
		
	
		
	     response.sendRedirect("home_principal.jsp");
	
	
	}

	
	
}

