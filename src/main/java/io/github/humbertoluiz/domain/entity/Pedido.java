package io.github.humbertoluiz.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
<<<<<<< HEAD
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
=======
>>>>>>> 5ae35af1d740607db2bc7c21cc0d6a506a6f2920
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

<<<<<<< HEAD
import io.github.humbertoluiz.domain.enums.StatusPedido;
import lombok.AllArgsConstructor;
=======
>>>>>>> 5ae35af1d740607db2bc7c21cc0d6a506a6f2920
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
<<<<<<< HEAD
@AllArgsConstructor
=======
>>>>>>> 5ae35af1d740607db2bc7c21cc0d6a506a6f2920
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
<<<<<<< HEAD
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@Column
=======
	@JoinColumn(name = "Cliente_id")
	private Cliente cliente;
	
>>>>>>> 5ae35af1d740607db2bc7c21cc0d6a506a6f2920
	private LocalDate dataPedido;
	
	@Column( name = "total", precision = 20, scale = 2 )
	private BigDecimal total;
	
<<<<<<< HEAD
	@Enumerated(EnumType.STRING)
	@Column
	private StatusPedido status;
	
=======
>>>>>>> 5ae35af1d740607db2bc7c21cc0d6a506a6f2920
	@OneToMany(mappedBy = "pedido")
	private Set<ItemPedido> itens;

	@Builder
	public Pedido(Cliente cliente, LocalDate dataPedido, BigDecimal total) {
		this.cliente = cliente;
		this.dataPedido = dataPedido;
		this.total = total;
	}
	
}
