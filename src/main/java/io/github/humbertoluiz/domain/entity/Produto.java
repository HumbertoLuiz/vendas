package io.github.humbertoluiz.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "{campo.descricao.obrigatorio}")
	@Column(nullable = false)
	private String descricao;
	
	@NotNull(message = "{campo.preco.obrigatorio}")
	@Column(nullable = false)
	private BigDecimal preco;

	@Builder
	public Produto(String descricao, BigDecimal preco) {
		this.descricao = descricao;
		this.preco = preco;
	}
	
}
