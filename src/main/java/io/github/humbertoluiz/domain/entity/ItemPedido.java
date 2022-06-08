package io.github.humbertoluiz.domain.entity;

import java.io.Serializable;
<<<<<<< HEAD

import javax.persistence.Column;
=======
>>>>>>> 5ae35af1d740607db2bc7c21cc0d6a506a6f2920
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
<<<<<<< HEAD

=======
>>>>>>> 5ae35af1d740607db2bc7c21cc0d6a506a6f2920
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
<<<<<<< HEAD
	@Column
=======
>>>>>>> 5ae35af1d740607db2bc7c21cc0d6a506a6f2920
	private Integer quantidade;

	@Builder
	public ItemPedido(Pedido pedido, Produto produto, Integer quantidade) {
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
	}

}
