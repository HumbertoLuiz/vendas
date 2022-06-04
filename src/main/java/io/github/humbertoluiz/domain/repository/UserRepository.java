//package io.github.humbertoluiz.domain.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import io.github.humbertoluiz.domain.entity.User;
//
//public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.username= (:username)")
//    public User findByUsername(@Param("username") String username);
//
//    boolean existsByUsername(String username);
//}
