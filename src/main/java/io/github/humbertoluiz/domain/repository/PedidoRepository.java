package io.github.humbertoluiz.domain.repository;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.github.humbertoluiz.domain.entity.Cliente;
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

>>>>>>> 5ae35af1d740607db2bc7c21cc0d6a506a6f2920
import io.github.humbertoluiz.domain.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

<<<<<<< HEAD
	List<Pedido> findByCliente( Cliente cliente );
	
	@Query(" select p from Pedido p left join fetch p.itens where p.id = :id ")
	Optional<Pedido> findByIdFetchItens( @Param("id") Long idPedido);
=======
>>>>>>> 5ae35af1d740607db2bc7c21cc0d6a506a6f2920
}
