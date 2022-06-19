//package io.github.humbertoluiz.domain.repository;
//
//import java.util.Optional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import io.github.humbertoluiz.domain.entity.Usuario;
//
//public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
//	
//    boolean existsByUsername(String username);
//	
//	Optional<Usuario> findByUsername(String username);
//}
