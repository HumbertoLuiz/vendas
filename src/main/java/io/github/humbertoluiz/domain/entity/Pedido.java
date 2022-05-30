package io.github.humbertoluiz.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
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
	@JoinColumn(name = "Cliente_id")
	private Cliente cliente;
	
	private LocalDate dataPedido;
	
	@Column( name = "total", precision = 20, scale = 2 )
	private BigDecimal total;
	
	@OneToMany(mappedBy = "pedido")
	private Set<ItemPedido> itens;

	@Builder
	public Pedido(Cliente cliente, LocalDate dataPedido, BigDecimal total) {
		this.cliente = cliente;
		this.dataPedido = dataPedido;
		this.total = total;
	}
	
}
