package io.github.humbertoluiz.domain.entity;

import java.io.Serializable;
import java.util.Set;
<<<<<<< HEAD
=======

>>>>>>> 5ae35af1d740607db2bc7c21cc0d6a506a6f2920
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

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
	
	@NotBlank
	@Column(nullable = false)
	private String nome;
	
	@NotBlank
	@Column(nullable = false, length = 11)
	private String cpf;
	
	@JsonIgnore
	@OneToMany( mappedBy = "cliente", fetch = FetchType.LAZY  )
	private Set<Pedido> pedidos;

<<<<<<< HEAD
//	@ManyToOne
//	private Endereco endereco;
=======
	@ManyToOne
	private Endereco endereco;
>>>>>>> 5ae35af1d740607db2bc7c21cc0d6a506a6f2920

	@Builder
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	

	
}
