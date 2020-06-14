package com.redsocial.servicio;

import java.util.List;
import java.util.Optional;

import com.redsocial.entidad.Alumno;

public interface AlumnoServicio {

	public Alumno insertaActualizaAlumno(Alumno obj);
	public Optional<Alumno> buscarAlumnoPorId(int id);
	public void eliminaAlumno(int idAlumno);
	public List<Alumno> listaAlumno();

}
