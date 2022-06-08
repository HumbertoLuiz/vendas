package io.github.humbertoluiz.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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

import io.github.humbertoluiz.domain.entity.Cliente;
import io.github.humbertoluiz.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/{clienteId}")
	public Cliente buscarPorId(@PathVariable Long clienteId) {
		return clienteService.buscarPorId(clienteId);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente save( @RequestBody @Valid Cliente cliente ) {
		return clienteService.save(cliente);
	}

	@DeleteMapping("/{clienteId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete( @PathVariable Long clienteId ) {
		clienteService.delete(clienteId);
	}

	@PutMapping("/{clienteId}")
	public void update(@RequestBody @Valid Cliente cliente, @PathVariable Long clienteId) {
		clienteService.update(clienteId, cliente);
	}

	@GetMapping
	public Example<Cliente> buscarPorFiltro(Cliente filtro) {
		ExampleMatcher matcher = ExampleMatcher
				.matching()
				.withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		Example<Cliente> example = Example.of(filtro, matcher);
		return clienteService.buscarPorFiltro(example);
	}
	
//	@GetMapping
//	public Iterable<Cliente> buscarTodos() {
//		return clienteService.buscarTodos();
//	}

}
