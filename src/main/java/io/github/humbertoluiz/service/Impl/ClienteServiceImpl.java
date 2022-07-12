package io.github.humbertoluiz.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.github.humbertoluiz.domain.entity.Cliente;
import io.github.humbertoluiz.domain.entity.Endereco;
//import io.github.humbertoluiz.domain.entity.Endereco;
import io.github.humbertoluiz.domain.repository.ClienteRepository;
import io.github.humbertoluiz.domain.repository.EnderecoRepository;
//import io.github.humbertoluiz.domain.repository.EnderecoRepository;
import io.github.humbertoluiz.service.ClienteService;
import io.github.humbertoluiz.service.ViaCepService;
//import io.github.humbertoluiz.service.ViaCepService;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * 
 * @author Beto
 *
 */

@Service
public class ClienteServiceImpl implements ClienteService {

	// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long clienteId) {
		// Buscar Cliente por ID.
		Optional<Cliente> cliente = Optional.ofNullable(clienteRepository.findById(clienteId)
			.orElseThrow(() ->
			new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")));
		return cliente.get();
	}

	@Override
	public Cliente save(Cliente cliente) {
		return salvarClienteComCep(cliente);
	}

	@Override
	public void update(Long clienteId, Cliente cliente) {
		// Buscar Cliente por ID, caso exista:
		clienteRepository.findById(clienteId)
		.map(clienteExistente -> {
		cliente.setId(clienteExistente.getId());
		salvarClienteComCep(cliente);
		return clienteExistente;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
	}

	@Override
	public void delete(Long clienteId) {
		// Deletar Cliente por ID.
		clienteRepository
		.findById(clienteId)
		.map( cliente -> {
			clienteRepository.delete(cliente);
			return Void.TYPE;
		}).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
	}

	private Cliente salvarClienteComCep(Cliente cliente) {
		
		// Verificar se o Endereco do Cliente já existe (pelo CEP).
		String cep = ((Endereco) cliente.getEndereco()).getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		// Inserir Cliente, vinculando o Endereco (novo ou existente).
		clienteRepository.save(cliente);
		return cliente;
	}

	@Override
	public Example<Cliente> buscarPorFiltro(Example<Cliente> example) {
		clienteRepository.findAll();
		return null;
	}

}