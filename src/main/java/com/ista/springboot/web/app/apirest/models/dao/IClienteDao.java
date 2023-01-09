package com.ista.springboot.web.app.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ista.springboot.web.app.apirest.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente,Long> {
	//select * from producto where CAST(idproducto AS TEXT) LIKE '" + texto + "%' or lower(nombre) like '" + texto + "%'"

	@Query(value = "select * from railway.clientes where nombre like ?% or apellido like ?%",
			nativeQuery = true
	)
	List<Cliente> busquedaLikeC(String id, String ape);
}
