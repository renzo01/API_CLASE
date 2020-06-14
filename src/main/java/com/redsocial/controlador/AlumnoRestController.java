package com.redsocial.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redsocial.entidad.Alumno;
import com.redsocial.servicio.AlumnoServicio;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/servicio/alumno")
public class AlumnoRestController {

	@Autowired
	private AlumnoServicio servicio;

    @GetMapping()
    public ResponseEntity<List<Alumno>> listaAlumno() {
        return ResponseEntity.ok(servicio.listaAlumno());
    }

    @PostMapping
    public ResponseEntity<Alumno> registrar( @RequestBody Alumno obj) {
        return ResponseEntity.ok(servicio.insertaActualizaAlumno(obj));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> buscarPorId(@PathVariable int id) {
        Optional<Alumno> alumno = servicio.buscarAlumnoPorId(id);
        if (!alumno.isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }else {
        	return ResponseEntity.ok(alumno.get());	
        }
    }

    @PutMapping()
    public ResponseEntity<Alumno> actualiza(@RequestBody Alumno alumno) {
        if (!servicio.buscarAlumnoPorId(alumno.getIdAlumno()).isPresent()) {
            log.error("Id " + alumno.getIdAlumno() + " is not existed");
            return ResponseEntity.badRequest().build();
        }else {
        	return ResponseEntity.ok(servicio.insertaActualizaAlumno(alumno));	
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Alumno> elimina(@PathVariable int id) {
        if (!servicio.buscarAlumnoPorId(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }else {
        	return ResponseEntity.ok().build();	
        }
    }
	
}
