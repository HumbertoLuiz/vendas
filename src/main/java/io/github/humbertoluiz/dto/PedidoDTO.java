package io.github.humbertoluiz.dto;

import java.math.BigDecimal;
import java.util.Set;

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
    private Long cliente;
    private BigDecimal total;
    private Set<ItemPedidoDTO> itens;
}
