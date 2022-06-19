//package io.github.humbertoluiz.rest.controller;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;
//
//import io.github.humbertoluiz.domain.entity.Usuario;
//import io.github.humbertoluiz.dto.CredenciaisDTO;
//import io.github.humbertoluiz.dto.TokenDTO;
//import io.github.humbertoluiz.exception.SenhaInvalidaException;
//import io.github.humbertoluiz.security.jwt.JwtService;
//import io.github.humbertoluiz.service.UsuarioService;
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/usuarios")
//public class UsuarioController {
//	
//    private final UsuarioService usuarioService;
//    private final JwtService jwtService;
//    
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Usuario salvar(@RequestBody @Valid Usuario usuario){
//        return usuarioService.salvar(usuario);
//    }
//    
//    @PostMapping("/auth")
//    public TokenDTO autenticar( @RequestBody CredenciaisDTO credenciaisDTO) {
//    	try {
//			Usuario usuario = Usuario
//					.builder()
//					.username(credenciaisDTO.getUsername())
//					.password(credenciaisDTO.getPassword())
//					.build();
//					
//			UserDetails usuarioAutenticado = usuarioService.autenticar(usuario);
//			String token = jwtService.gerarToken( usuario);
//			return new TokenDTO(usuario.getUsername(), token);
//			
//		} catch (UsernameNotFoundException | SenhaInvalidaException e) {
//			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
//		}
//    }
//}
