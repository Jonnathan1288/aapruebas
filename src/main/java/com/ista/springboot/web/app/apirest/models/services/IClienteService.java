package com.ista.springboot.web.app.apirest.models.services;

import java.util.List;

import com.ista.springboot.web.app.apirest.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Cliente save(Cliente cliente);
	
	public Cliente actualizar(Cliente cliente);
	
	public Cliente findById(Long id);
	
	public void delete(Long id);
	
	public List<Cliente> busqueda_like(String id, String ap);
	
}
