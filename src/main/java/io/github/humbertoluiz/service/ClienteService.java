package io.github.humbertoluiz.service;

import org.springframework.data.domain.Example;

import io.github.humbertoluiz.domain.entity.Cliente;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 * 
 * @author Beto
 *
 */

public interface ClienteService {

//	Iterable<Cliente> buscarTodos();
	
	Cliente buscarPorId(Long clienteId);

	Cliente save(Cliente cliente);

	void update(Long clienteId, Cliente cliente);

	void delete(Long clienteId);

	Example<Cliente> buscarPorFiltro(Example<Cliente> example);



}