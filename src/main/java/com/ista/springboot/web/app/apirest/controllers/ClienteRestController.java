package com.ista.springboot.web.app.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ista.springboot.web.app.apirest.models.entity.Cliente;
import com.ista.springboot.web.app.apirest.models.services.IClienteService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;
	
	//Listar clientes------VALIDO
	@GetMapping("/clientes")
	public List<Cliente> indext(){
		return clienteService.findAll();
	}	
	
	//Crear un cliente-------VALIDO
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente insertar (@RequestBody Cliente cli){
		return clienteService.save(cli);
	}
	
	//Eliminar cliente--------VALIDO
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.delete(id);
	}
	
	//Buscar los clientes por el id-------VALIDO
	@GetMapping("/clientes/{id}")
	public Cliente buscar (@PathVariable Long id){
		return clienteService.findById(id);
		
	}
	
	//VALIDO
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente actualizar(@RequestBody Cliente cli, @PathVariable Long id) {
		Cliente clienteActual = clienteService.findById(id);
		clienteActual.setApellido(cli.getApellido());
		clienteActual.setNombre(cli.getNombre());
		clienteActual.setEmail(cli.getEmail());
		return clienteService.actualizar(clienteActual);
	}
	
	@GetMapping(value = "/clientes/like/{id}")
	public ResponseEntity<List<?>> findByConteoDeDetalles(@PathVariable("id") String id) {
		return ResponseEntity.ok(clienteService.busqueda_like(id, id));
	}
}
