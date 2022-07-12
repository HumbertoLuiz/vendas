package io.github.humbertoluiz.rest.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.humbertoluiz.domain.entity.User;
import io.github.humbertoluiz.domain.repository.UserRepository;
import io.github.humbertoluiz.dto.CredenciaisDTO;
import io.github.humbertoluiz.dto.TokenDTO;
import io.github.humbertoluiz.security.SecurityConfig;
import io.github.humbertoluiz.security.jwt.JWTCreator;
import io.github.humbertoluiz.security.jwt.JWTObject;
import io.github.humbertoluiz.service.UserService;



@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
    @Autowired
    private UserService service;    
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserRepository repository;
    
    @PostMapping
    public void postUser(@RequestBody User user){
        service.createUser(user);
    }
    
    @PostMapping("/auth")
    public TokenDTO autenticar( @RequestBody CredenciaisDTO credenciaisDTO) {
    	User user = repository.findByUsername(credenciaisDTO.getUsername());
        if(user != null) {
            boolean passwordOk =  encoder.matches(credenciaisDTO.getPassword(), user.getPassword());
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + credenciaisDTO.getUsername());
            }
            //Estamos enviando um objeto Sessão para retornar mais informações do usuário
            TokenDTO sessao = new TokenDTO();
            sessao.setLogin(user.getUsername());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
            jwtObject.setRoles(user.getRoles());
            sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
            return sessao;
        }else {
            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }
}
