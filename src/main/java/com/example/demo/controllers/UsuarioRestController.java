package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Usuario;
import com.example.demo.models.services.IUsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {

	@Autowired //inyeccion de dependencias 		
	private IUsuarioService usuarioService;
	
	//Listar todo los cliente
	@GetMapping("/usuarios")
	public List<Usuario> index(){
		return usuarioService.findAll();
	}
	
	//Buscar por id
	@GetMapping("/usuarios/{id}")
	public Usuario show(@PathVariable Long id) {
		
		return usuarioService.findById(id);
		
	}
	
	//Guardar
	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) {
		
		return usuarioService.save(usuario);
	}
	
	//Editar 
	@PutMapping("/usuarios/{id}")
	public Usuario update(@RequestBody Usuario user, @PathVariable Long id) {
		Usuario usuarioActual = usuarioService.findById(id);
		usuarioActual.setNombre(user.getNombre());
		usuarioActual.setClave(user.getClave());
		usuarioActual.setEmail(user.getEmail());
		usuarioActual.setEstado(user.getEstado());
		return usuarioService.save(usuarioActual);
		
	}
	
	//Eliminar un cliente
	@DeleteMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		usuarioService.delete(id);
	}
}
