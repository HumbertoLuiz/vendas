package io.github.humbertoluiz.domain.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "{campo.nome.obrigatorio}")
	@Column(nullable = false, length = 100)
	private String nome;
	
	@NotBlank(message = "{campo.cpf.obrigatorio}")
	@CPF(message = "{campo.cpf.invalido}")
	@Column(nullable = false, length = 11)
	private String cpf;
	
	@JsonIgnore
	@OneToMany( mappedBy = "cliente", fetch = FetchType.LAZY  )
	private Set<Pedido> pedidos;

	@ManyToOne
	private Endereco endereco;

	@Builder
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	

	
}
