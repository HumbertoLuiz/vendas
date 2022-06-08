package io.github.humbertoluiz.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.github.humbertoluiz.domain.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id ")
	Cliente findClienteFetchPedidos( @Param("id") Integer id );

	
}
