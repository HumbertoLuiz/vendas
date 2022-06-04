//package io.github.humbertoluiz.api.controller;
//
//import java.util.Date;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import io.github.humbertoluiz.domain.entity.User;
//import io.github.humbertoluiz.domain.repository.UserRepository;
//import io.github.humbertoluiz.dto.Login;
//import io.github.humbertoluiz.dto.Sessao;
//import io.github.humbertoluiz.security.JWTCreator;
//import io.github.humbertoluiz.security.JWTObject;
//import io.github.humbertoluiz.security.SecurityConfig;
//@RestController
//public class LoginController {
//    @Autowired
//    private PasswordEncoder encoder;
//    @Autowired
//    private UserRepository repository;
//
//    @PostMapping("/login")
//    public Sessao logar(@RequestBody Login login){
//        User user = repository.findByUsername(login.getUsername());
//        if(user!=null) {
//            boolean passwordOk =  encoder.matches(login.getPassword(), user.getPassword());
//            if (!passwordOk) {
//                throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
//            }
//            //Estamos enviando um objeto Sessão para retornar mais informações do usuário
//            Sessao sessao = new Sessao();
//            sessao.setLogin(user.getUsername());
//
//            JWTObject jwtObject = new JWTObject();
//            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
//            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
//            jwtObject.setRoles(user.getRoles());
//            sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
//            return sessao;
//        }else {
//            throw new RuntimeException("Erro ao tentar fazer login");
//        }
//    }
//}
