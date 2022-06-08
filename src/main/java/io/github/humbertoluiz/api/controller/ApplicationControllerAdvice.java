package io.github.humbertoluiz.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.humbertoluiz.exception.PedidoNaoEncontradoException;
import io.github.humbertoluiz.exception.RegraNegocioException;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(RegraNegocioException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors handleReRegraNegocioException( RegraNegocioException ex ) {
		String mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}
	
	@ExceptionHandler(PedidoNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrors handlePedidoNaoEncontradoException( PedidoNaoEncontradoException ex) {
		return new ApiErrors( ex.getMessage() );
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors handleMethodArgumentNotValidException( MethodArgumentNotValidException ex ) {
		List<String> errors = ex.getBindingResult().getAllErrors()
		.stream()
		.map( erro -> erro.getDefaultMessage())
		.collect(Collectors.toList());
		return new ApiErrors(errors);
		
	}
}
