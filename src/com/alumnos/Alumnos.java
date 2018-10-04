package com.alumnos;

import java.util.Date;

public class Alumnos {

	private int id_persona;
	
	private int id_alumno;
	
	private String nombre;
	
	private String apellido;
	
	private String tipodoc;
	
	private int nrodocumento;
	
	private Date fecnac;
	
	private int legajo;
	
	private int id_curso;
	
	private int id_docente;
	
    private String nombrecurso;
	
	private String desc_curso;
	
	private String nombre_docente;
	
	private String apellido_docente;
	
	private Date fecha_insc_asignatura;
	
	private Double promedio;
	
	private String nombrecarrera;
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTipodoc() {
		return tipodoc;
	}

	public void setTipodoc(String tipodoc) {
		this.tipodoc = tipodoc;
	}

	public int getNrodocumento() {
		return nrodocumento;
	}

	public void setNrodocumento(int nrodocumento) {
		this.nrodocumento = nrodocumento;
	}

	public Date getFecnac() {
		return fecnac;
	}

	public void setFecnac(Date fecnac) {
		this.fecnac = fecnac;
	}

	
	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	
	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	public int getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}
	

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public int getId_docente() {
		return id_docente;
	}

	public void setId_docente(int id_docente) {
		this.id_docente = id_docente;
	}

	public String getNombrecurso() {
		return nombrecurso;
	}

	public void setNombrecurso(String nombrecurso) {
		this.nombrecurso = nombrecurso;
	}

	public String getDesc_curso() {
		return desc_curso;
	}

	public void setDesc_curso(String desc_curso) {
		this.desc_curso = desc_curso;
	}

	
	public String getNombre_docente() {
		return nombre_docente;
	}

	public void setNombre_docente(String nombre_docente) {
		this.nombre_docente = nombre_docente;
	}

	public String getApellido_docente() {
		return apellido_docente;
	}

	public void setApellido_docente(String apellido_docente) {
		this.apellido_docente = apellido_docente;
	}

	public Date getFecha_insc_asignatura() {
		return fecha_insc_asignatura;
	}

	public void setFecha_insc_asignatura(Date fecha_insc_asignatura) {
		this.fecha_insc_asignatura = fecha_insc_asignatura;
	}

	public Double getPromedio() {
		return promedio;
	}

	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}

	public String getNombrecarrera() {
		return nombrecarrera;
	}

	public void setNombrecarrera(String nombrecarrera) {
		this.nombrecarrera = nombrecarrera;
	}

	public Alumnos(String nombre, String apellido, String tipodoc, int nrodocumento, Date fecnac, int legajo) {
	
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipodoc = tipodoc;
		this.nrodocumento = nrodocumento;
		this.fecnac = fecnac;
		this.legajo = legajo;
	}

	public Alumnos(int id_persona, int id_alumno, String nombre, String apellido, String tipodoc, int nrodocumento,
			Date fecnac, int legajo) {

		this.id_persona = id_persona;
		this.id_alumno = id_alumno;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipodoc = tipodoc;
		this.nrodocumento = nrodocumento;
		this.fecnac = fecnac;
		this.legajo = legajo;
	}
	

	public Alumnos(int id_persona, int id_alumno, String nombre, String apellido, String tipodoc, int nrodocumento, int legajo) {

		this.id_persona = id_persona;
		this.id_alumno = id_alumno;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipodoc = tipodoc;
		this.nrodocumento = nrodocumento;
		this.legajo = legajo;
	}

	public Alumnos(int id_curso,int id_alumno, int id_docente, String nombrecurso, String desc_curso) {
		
		this.id_curso = id_curso;
		this.id_alumno = id_alumno;
		this.id_docente = id_docente;
		this.nombrecurso = nombrecurso;
		this.desc_curso = desc_curso;
	}

	public Alumnos(int id_alumno, Date fecnac, int id_curso) {
	
		this.id_alumno = id_alumno;
		this.fecnac = fecnac;
		this.id_curso = id_curso;
	}

	public Alumnos(String nombre, String apellido, String nombrecurso, String nombre_docente, String apellido_docente,
			Date fecha_insc_asignatura) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombrecurso = nombrecurso;
		this.nombre_docente = nombre_docente;
		this.apellido_docente = apellido_docente;
		this.fecha_insc_asignatura = fecha_insc_asignatura;
	}

	public Alumnos(String nombrecurso, String nombrecarrera, Double promedio) {
		
	
		this.nombrecurso = nombrecurso;
		this.nombrecarrera = nombrecarrera;
		this.promedio = promedio;
	}
	
	
	

}
