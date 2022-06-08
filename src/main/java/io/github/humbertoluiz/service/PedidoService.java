package io.github.humbertoluiz.service;

import java.util.Optional;

import io.github.humbertoluiz.domain.entity.Pedido;
import io.github.humbertoluiz.domain.enums.StatusPedido;
import io.github.humbertoluiz.dto.PedidoDTO;

public interface PedidoService {

	Pedido salvar( PedidoDTO pedidoDTO );
	
	Optional<Pedido> obterPedidoCompleto( Long pedidoId );
	
	void atualizaStatus( Long pedidoId, StatusPedido statusPedido );
}
