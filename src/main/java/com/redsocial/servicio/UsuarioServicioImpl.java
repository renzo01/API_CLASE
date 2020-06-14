package com.redsocial.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocial.entidad.Usuario;
import com.redsocial.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

	@Autowired
	private UsuarioRepositorio repositorio; 
	
	@Override
	public Usuario insertaActualizaUsuario(Usuario obj) {
		return repositorio.save(obj);
	}

	@Override
	public Optional<Usuario> buscarUsuarioPorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public void eliminaUsuario(int idUsuario) {
		repositorio.deleteById(idUsuario);
	}

	@Override
	public List<Usuario> listaUsuario() {
		return repositorio.findAll();
	}

	

}


