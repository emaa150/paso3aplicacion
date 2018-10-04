package com.alumnos;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;





public class ModeloAlumnos {

	/* VIENE DEL POOL DE CONEXIONES CREADO EN UN XML
	 * 
	 *   <Context>

	<Resource name="jdbc/Alumnos" auth="Container" type="javax.sql.DataSource"
	
				maxActive="15" maxIdle="3" maxWait="5000" 
				
				username="root" password=""
				
				driverClassName="com.mysql.jdbc.Driver"
				
				url="jdbc:mysql://localhost:3306/paso3_aplicacion">
	
	
	</Resource>

</Context>
	 * 
	 * 
	 * 
	
	*/
	
	private DataSource origenDatos;
	
	
	// CONSTRUCTOR PARA CREAR LA CONEXION
	
	public ModeloAlumnos(DataSource origenDatos){
		
		
		this.origenDatos=origenDatos;	
		
	}


	
	public void InsertarAlumno(Alumnos nuevoAlumno) throws Exception{
		
		Connection miConexion=null;
		
		PreparedStatement miStatement=null;
		
		PreparedStatement miStatement2=null;
		
		ResultSet miResultset=null;
		
		
		// CONEXION CON LA DDBB
		
		miConexion=origenDatos.getConnection();
		
	 // INSERTAR ALUMNO
		
		
		String sql="INSERT INTO persona (tipodoc, documento, nombre, apellido, fechanac) "+
		"VALUES (?,?,?,?,?)";
		
		miStatement=miConexion.prepareStatement(sql);
		
		
		// ESTABLECER PARAMETROS DEL ALUMNOS
		
		miStatement.setString(1, nuevoAlumno.getTipodoc());
		
		miStatement.setInt(2, nuevoAlumno.getNrodocumento());
		
		miStatement.setString(3, nuevoAlumno.getNombre());
		
		miStatement.setString(4, nuevoAlumno.getApellido());
		
		java.util.Date utilDate=nuevoAlumno.getFecnac();
		
		java.sql.Date fechaConvertida=new java.sql.Date(utilDate.getTime());
		
		miStatement.setDate(5, fechaConvertida);
		
	
		
		miStatement.execute();
		
	
		System.out.println("El alumno " + nuevoAlumno.getNombre() + " " + nuevoAlumno.getApellido() + " se registro con exito");
	
	
		
	
	
     	// OBTENGO EL IDENTIFICADOR DE LA PERSONA PARA INSERTARLO EN ALUMNO
			
		String sql2="SELECT * FROM persona WHERE documento=?";
			
			miStatement2=miConexion.prepareStatement(sql2);
			
			miStatement2.setInt(1, nuevoAlumno.getNrodocumento());
			
		
			miResultset=miStatement2.executeQuery();
			
			
			if(miResultset.next()) {
				
				int id_persona=miResultset.getInt("identificador");
				
				
				System.out.println("El id de persona generado es: "+id_persona);
			
			
				String sql3="INSERT INTO alumno (idpersona,legajo) VALUES (?,?)";
						
				miStatement=miConexion.prepareStatement(sql3);
						
						
				// ESTABLECER PARAMETROS DEL ALUMNO
						
				miStatement.setInt(1, id_persona);
				
				miStatement.setInt(2, nuevoAlumno.getLegajo());
						
						
				miStatement.execute();	
			
			}
	
	
	}



	public List<Alumnos> obtenerAlumnos() throws Exception {
		// TODO Auto-generated method stub
		
		
		List<Alumnos> alumnos=new ArrayList<>();
		
		
		Connection miConexion=null;
		
		Statement miStatement=null;
		
		ResultSet miResultset=null;
		
		miConexion=origenDatos.getConnection();
		
		
		String sql="SELECT persona.identificador, persona.tipodoc, persona.documento, persona.nombre, persona.apellido, alumno.identificador, alumno.legajo FROM persona " + 
				"INNER JOIN alumno ON alumno.idpersona=persona.identificador";
		
		
		miStatement=miConexion.createStatement();
		
		miResultset=miStatement.executeQuery(sql);
		
		
		while(miResultset.next()) {
			
		int id_persona=miResultset.getInt("identificador");
			
		String tipodoc=miResultset.getString("tipodoc");
		
		int nrodoc=miResultset.getInt("documento");
	
		String nombre=miResultset.getString("nombre");
		
		String apellido=miResultset.getString("apellido");
		
		int id_alumno=miResultset.getInt("alumno.identificador");
			
		int legajo=miResultset.getInt("legajo");
		
		
		Alumnos tempalu=new Alumnos (id_persona, id_alumno,nombre, apellido, tipodoc, nrodoc, legajo);
		
		alumnos.add(tempalu);			
			
			
		}
		
		
		return alumnos;
	}



	public Alumnos obtenerDatosDelAlumno(int id_persona, int id_alumno) throws Exception {
		// TODO Auto-generated method stub
		
	// TODO Auto-generated method stub
		
		Alumnos obtenerAlumno=null;
		
		Connection miConexion=null;
		
		PreparedStatement miStatement=null;
		
		ResultSet miResultset=null;
		
		int idalumno=id_alumno;
		
		int idpersona=id_persona;
		
		
		miConexion=origenDatos.getConnection();
		
		
		String sql="SELECT persona.identificador, persona.tipodoc, persona.documento, persona.nombre, persona.apellido, persona.fechanac, alumno.identificador, alumno.legajo FROM persona " + 
				"INNER JOIN alumno ON alumno.idpersona=persona.identificador WHERE persona.identificador=? and alumno.identificador=?";
		
	
		
		miStatement=miConexion.prepareStatement(sql);
		
		
		miStatement.setInt(1, idpersona);
		
		miStatement.setInt(2, idalumno);
		
		miResultset=miStatement.executeQuery();
		
		
			
			while(miResultset.next()) {
				

					
				String tipodoc=miResultset.getString("tipodoc");
				
				int doc=miResultset.getInt("documento");
			
				String nombre=miResultset.getString("nombre");
				
				String apellido=miResultset.getString("apellido");
				
				
				Date fechanac=miResultset.getDate("fechanac");
				
				int legajo=miResultset.getInt("legajo");
				
				
			   obtenerAlumno=new Alumnos (idpersona, idalumno,nombre, apellido, tipodoc, doc,fechanac, legajo);
		
			}	
		
		
		
		return obtenerAlumno;
		
		

	}



	public void ActualizarDatosDelAlumno(Alumnos alumnoActualizado) throws Exception {
		
		Connection miConexion=null;
		
		PreparedStatement miStatement=null;
		
		PreparedStatement miStatement2=null;
		
		miConexion=origenDatos.getConnection();
		
		
		String sql="UPDATE persona SET tipodoc=?, documento=?, nombre=?, apellido=?, fechanac=? WHERE identificador=?";
		
		String sql2="UPDATE alumno SET legajo=? WHERE idpersona=?";
		
		
		miStatement=miConexion.prepareStatement(sql);
		
		miStatement2=miConexion.prepareStatement(sql2);
		
		
        miStatement.setString(1, alumnoActualizado.getTipodoc());
		
		miStatement.setInt(2, alumnoActualizado.getNrodocumento());
		
		miStatement.setString(3, alumnoActualizado.getNombre());
		
		miStatement.setString(4, alumnoActualizado.getApellido());
		
		java.util.Date utilDate=alumnoActualizado.getFecnac();
		
		java.sql.Date fechaConvertida=new java.sql.Date(utilDate.getTime());
		
		miStatement.setDate(5, fechaConvertida);
		
		miStatement.setInt(6, alumnoActualizado.getId_persona());
		
		
		// ACTUALIZO LEGAJO
		
		miStatement2.setInt(1, alumnoActualizado.getLegajo());
		
		miStatement2.setInt(2, alumnoActualizado.getId_persona());
		
	System.out.println("alu "+alumnoActualizado.getId_alumno());
	
	System.out.println("perso "+alumnoActualizado.getId_persona());
		
		
		miStatement.execute();
		miStatement2.execute();
		
		
	}



	public List<Alumnos> obtenerMaterias(int alumno_id) throws Exception {
		
      List<Alumnos> materias=new ArrayList<>();
		
		
		Connection miConexion=null;
		
		Statement miStatement=null;
		
		ResultSet miResultset=null;
		
		miConexion=origenDatos.getConnection();
		
		int id_alumno=alumno_id;
		
		
		String sql="SELECT identificador, iddocente, nombre, descripcion FROM curso";
		
		
		miStatement=miConexion.createStatement();
		
		miResultset=miStatement.executeQuery(sql);
		
		
		while(miResultset.next()) {
			
		int id_curso=miResultset.getInt("identificador");
		
		int id_docente=miResultset.getInt("iddocente");
			
		String nombrecurso=miResultset.getString("nombre");
		
		String desc_curso=miResultset.getString("descripcion");
		

		
		Alumnos tempMaterias=new Alumnos (id_curso, id_alumno, id_docente,nombrecurso, desc_curso);
		
		
		materias.add(tempMaterias);			
			
			
		}
		
		
		
		return materias;
	}



	public void InscribirMateriaAlumno(Alumnos guardarMateria) throws Exception {
		
		
        Connection miConexion=null;
		
		PreparedStatement miStatement=null;
			
		
		// CONEXION CON LA DDBB
		
		miConexion=origenDatos.getConnection();
		
		// COMPROBAR SI EL ALUMNO EXISTE
		
		
		String sql="INSERT INTO inscripciones_curso (idalumno, idcurso, fechainscripcion) "+
		"VALUES (?,?,?)";
		
		miStatement=miConexion.prepareStatement(sql);
		
		
		// ESTABLECER PARAMETROS DEL ALUMNOS
		
		miStatement.setInt(1, guardarMateria.getId_alumno());
		
		miStatement.setInt(2, guardarMateria.getId_curso());
		

		java.util.Date utilDate=guardarMateria.getFecnac();
		
		java.sql.Date fechaConvertida=new java.sql.Date(utilDate.getTime());
		
		miStatement.setDate(3,fechaConvertida);
		
	
		
		miStatement.execute();
		
	
	
		
		
	}



	public List<Alumnos> obtenerLosParametrosDelCurso(int id_curso, int id_docente) throws Exception {
		// TODO Auto-generated method stub
		
		
		
	      List<Alumnos> parametrosMateria=new ArrayList<>();
			
			
			Connection miConexion=null;
			
			PreparedStatement miStatement=null;
			
			ResultSet miResultset=null;
		
			int curso_id=id_curso;
			
			int docente_id=id_docente;

			
			
			miConexion=origenDatos.getConnection();
			
			
			String sql="SELECT curso.nombre,docente.nombre, docente.apellido, persona.nombre, persona.apellido, inscripciones_curso.fechainscripcion " + 
					"FROM inscripciones_curso INNER JOIN alumno ON alumno.identificador=inscripciones_curso.idalumno " + 
					"INNER JOIN persona ON persona.identificador=alumno.idpersona " + 
					"INNER JOIN curso ON curso.identificador=inscripciones_curso.idcurso " + 
					"INNER JOIN docente ON docente.identificador=curso.iddocente " + 
					"WHERE curso.identificador=? AND docente.identificador=?";
			
			
			miStatement=miConexion.prepareStatement(sql);
			
			
			miStatement.setInt(1, curso_id);
			
			miStatement.setInt(2, docente_id);
			
			miResultset=miStatement.executeQuery();
			
			
			
			while(miResultset.next()) {
				
	
			String nombrecurso=miResultset.getString("curso.nombre");
			
			String nombre_docente=miResultset.getString("docente.nombre");
			
			String apellido_docente=miResultset.getString("docente.apellido");
			
			String nombre_alumno=miResultset.getString("persona.nombre");
			
			String apellido_alumno=miResultset.getString("persona.apellido");
			
			Date fecha_inscripcionmateria=miResultset.getDate("inscripciones_curso.fechainscripcion");

			
			
			
			Alumnos tempMaterias=new Alumnos (nombre_alumno,apellido_alumno ,nombrecurso, nombre_docente, apellido_docente, fecha_inscripcionmateria);
			
			
			parametrosMateria.add(tempMaterias);			
				
				
			}
			
			
			
			return parametrosMateria;
		
		
			
	}



	public List<Alumnos> obtenerDatosEstadoAcademico(int alumno_id) throws Exception {
		
		  
		List<Alumnos> datosEstadoAcademico=new ArrayList<>();
			
				
		    Connection miConexion=null;
			
			PreparedStatement miStatement=null;
			
			ResultSet miResultset=null;
		
  
			
			
			int id_alumno=alumno_id;
			
		
			miConexion=origenDatos.getConnection();
			
			
			String sql="SELECT curso.nombre, carrera.nombre, ((nota.nota1+nota.nota2+nota.nota3)/3) AS 'promedio' FROM persona " + 
					"INNER JOIN alumno ON alumno.idpersona=persona.identificador " + 
					"INNER JOIN inscripciones_curso ON inscripciones_curso.idalumno=alumno.identificador " + 
					"INNER JOIN curso ON curso.identificador=inscripciones_curso.idcurso " + 
					"INNER JOIN inscripciones_carrera ON inscripciones_carrera.idalumno=alumno.identificador " + 
					"INNER JOIN carrera ON carrera.identificador=inscripciones_carrera.idcarrera " + 
					"INNER JOIN nota ON nota.idcurso=curso.identificador " +
					"WHERE alumno.identificador=? AND inscripciones_curso.idalumno=? AND inscripciones_carrera.idalumno=? AND nota.idalumno=?";
					
			
			
			miStatement=miConexion.prepareStatement(sql);
			
			
			miStatement.setInt(1, id_alumno);
			
			miStatement.setInt(2, id_alumno);
			
			miStatement.setInt(3, id_alumno);
			
			miStatement.setInt(4, id_alumno);
		
			
			miResultset=miStatement.executeQuery();
			
			
			
			while(miResultset.next()) {
				
			
			String nombrecurso=miResultset.getString("curso.nombre");
			
		    String nombrecarrera=miResultset.getString("carrera.nombre");

		    Double promedio=miResultset.getDouble("promedio");
			
			
			
			Alumnos tempdatos=new Alumnos (nombrecurso, nombrecarrera, promedio);
			
			
			datosEstadoAcademico.add(tempdatos);			
				
				
			}
			
			
			
	return datosEstadoAcademico;
		

	}



	
	
	
}	
	