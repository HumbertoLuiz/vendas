package io.github.humbertoluiz.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import io.github.humbertoluiz.domain.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
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
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@Column
	private LocalDate dataPedido;
	
	@Column( name = "total", precision = 20, scale = 2 )
	private BigDecimal total;
	
	@Enumerated(EnumType.STRING)
	@Column
	private StatusPedido status;
	
	@OneToMany(mappedBy = "pedido")
	private Set<ItemPedido> itens;

	@Builder
	public Pedido(Cliente cliente, LocalDate dataPedido, BigDecimal total) {
		this.cliente = cliente;
		this.dataPedido = dataPedido;
		this.total = total;
	}
	
}
