package io.github.humbertoluiz.dto;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.constraints.NotNull;

import io.github.humbertoluiz.validation.NotEmptyList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {
    "cliente":1,
    "total": 100,
    "itens": [
        {
            "produto": 1,
            "quantidade": 10
        }
    ]
}
 * 
 * @author Beto
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
	
	@NotNull(message = "{campo.codigo-cliente.obrigatorio}")	
    private Long cliente;
	
	@NotNull(message = "{campo.total-pedido.obrigatorio}")		
    private BigDecimal total;
    
	@NotEmptyList(message = "{campo.items-pedido.obrigatorio}")
    private Set<ItemPedidoDTO> itens;
}
