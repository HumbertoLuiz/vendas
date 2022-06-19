//package io.github.humbertoluiz.service.Impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import io.github.humbertoluiz.domain.entity.Usuario;
//import io.github.humbertoluiz.domain.repository.UsuarioRepository;
//import io.github.humbertoluiz.exception.SenhaInvalidaException;
//import io.github.humbertoluiz.service.UsuarioService;
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {
//
//
//    private final PasswordEncoder encoder;
//    
//
//    private final UsuarioRepository usuarioRepository;
//    
//    @Transactional
//    public Usuario salvar(Usuario usuario){
//
//        String senhaCriptografada = usuario.getPassword();
//        //criptografando antes de salvar no banco
//        usuario.setPassword(encoder.encode(senhaCriptografada));
//    	
//    	return usuarioRepository.save(usuario);
//    }
//     
//    public UserDetails autenticar( Usuario usuario ) {
//    	UserDetails user = loadUserByUsername(usuario.getUsername());
//    	boolean senhasBatem = encoder.matches(usuario.getPassword(), user.getPassword());
//		
//    	if(senhasBatem) {
//			return user;
//		}
//    	
//		throw new SenhaInvalidaException();
//    }
//    
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		Usuario usuario = usuarioRepository
//				.findByUsername(username)
//				.orElseThrow( () ->
//				new UsernameNotFoundException("Usuário não encontrado na base de dados."));
//			
//			String [] roles = usuario.isAdmin() ?
//					new String [] {"ADMIN", "USER"} : new String [] {"USER"};
//		
//			return User
//					.builder()
//					.username(usuario.getUsername())
//					.password(usuario.getPassword())
//					.roles(roles)
//					.build();
//		}
//	
//}
