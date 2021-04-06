package com.develcode.teste.domain.service;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develcode.teste.domain.model.Usuario;
import com.develcode.teste.domain.repository.UsuarioRepository;




@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario salvar(@Valid Usuario usuario) {		
		return usuarioRepository.save(usuario);
	}

}
