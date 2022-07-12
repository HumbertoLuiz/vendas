package io.github.humbertoluiz.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Os atributos desse modelo foram gerados automaticamente pelo site
 * jsonschema2pojo.org. Para isso, usamos o JSON de retorno da API do ViaCEP.
 * 
 * @see <a href="https://www.jsonschema2pojo.org">jsonschema2pojo.org</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 *  
 * @author Beto
 *
 */

@Builder
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Endereco {

	@EqualsAndHashCode.Include
	@Id
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private String ibge;
	private String gia;
	private String ddd;
	private String siafi;	
	

	@Builder
	public Endereco(String cep, String logradouro, String complemento, String bairro, String localidade,
			String uf, String ibge, String gia, String ddd, String siafi) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.ibge = ibge;
		this.gia = gia;
		this.ddd = ddd;
		this.siafi = siafi;
	}

}
