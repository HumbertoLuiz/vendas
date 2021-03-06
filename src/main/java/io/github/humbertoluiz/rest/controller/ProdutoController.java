package io.github.humbertoluiz.rest.controller;

import java.util.List;

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
import org.springframework.web.server.ResponseStatusException;

import io.github.humbertoluiz.domain.entity.Produto;
import io.github.humbertoluiz.domain.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/{produtoId}")
	public Produto getProdutoById( @PathVariable Long produtoId ) {
		return produtoRepository.findById(produtoId)
			.orElseThrow( () ->
			new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado."));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto save( @RequestBody @Valid Produto produto ) {
		return produtoRepository.save(produto);
	}
	
	@PutMapping("/{produtoId}")
	public void update(@RequestBody @Valid Produto produto, @PathVariable Long produtoId) {
		produtoRepository.findById(produtoId)
			.map(produtoExistente -> {
			produto.setId(produtoExistente.getId());
			produtoRepository.save(produto);
			return produtoExistente;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
	}
	
	@DeleteMapping("/{produtoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete( @PathVariable Long produtoId ) {
		produtoRepository.findById(produtoId)
		.map( p -> {
			produtoRepository.delete(p);
			return Void.TYPE;
		}).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado."));
	}
	
	@GetMapping
	public List<Produto> find(Produto filtro) {
		ExampleMatcher matcher = ExampleMatcher
				.matching()
				.withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		Example<Produto> example = Example.of(filtro, matcher);
		return produtoRepository.findAll(example);
	}

}
