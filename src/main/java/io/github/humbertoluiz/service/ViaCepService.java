<<<<<<< HEAD
//package io.github.humbertoluiz.service;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import io.github.humbertoluiz.domain.entity.Endereco;
//
///**
// * Client HTTP, criado via <b>OpenFeign</b>, para o consumo da API do
// * <b>ViaCEP</b>.
// * 
// * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud OpenFeign</a>
// * @see <a href="https://viacep.com.br">ViaCEP</a>
// * 
// * @author Beto
// *
// */
//
//@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
//public interface ViaCepService {
//
//	@GetMapping("/{cep}/json/")
//	Endereco consultarCep(@PathVariable("cep") String cep);
//}
=======
package io.github.humbertoluiz.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.humbertoluiz.domain.entity.Endereco;

/**
 * Client HTTP, criado via <b>OpenFeign</b>, para o consumo da API do
 * <b>ViaCEP</b>.
 * 
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud OpenFeign</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 * 
 * @author Beto
 *
 */

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

	@GetMapping("/{cep}/json/")
	Endereco consultarCep(@PathVariable("cep") String cep);
}
>>>>>>> 5ae35af1d740607db2bc7c21cc0d6a506a6f2920
