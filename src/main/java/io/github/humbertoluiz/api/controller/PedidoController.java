package io.github.humbertoluiz.api.controller;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.humbertoluiz.domain.entity.ItemPedido;
import io.github.humbertoluiz.domain.entity.Pedido;
import io.github.humbertoluiz.domain.enums.StatusPedido;
import io.github.humbertoluiz.dto.AtualizacaoStatusPedidoDTO;
import io.github.humbertoluiz.dto.InformacaoItemPedidoDTO;
import io.github.humbertoluiz.dto.InformacoesPedidoDTO;
import io.github.humbertoluiz.dto.PedidoDTO;
import io.github.humbertoluiz.service.PedidoService;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Long save(@RequestBody @Valid PedidoDTO pedidoDTO) {
		Pedido pedido = pedidoService.salvar(pedidoDTO);
		return pedido.getId();
	}
	
    @GetMapping("{pedidoId}")
    public InformacoesPedidoDTO getById( @PathVariable Long pedidoId ){
        return pedidoService
                .obterPedidoCompleto(pedidoId)
                .map( p -> converter(p) )
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado."));
    }
    
    @PatchMapping("/{pedidoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus( @PathVariable Long pedidoId,
    							@RequestBody AtualizacaoStatusPedidoDTO pedidoDTO) {
    	String novoStatus = pedidoDTO.getNovoStatus();
    	pedidoService.atualizaStatus(pedidoId, StatusPedido.valueOf(novoStatus));
    }

    private InformacoesPedidoDTO converter( Pedido pedido ){
        return InformacoesPedidoDTO
                .builder()
                .codigo(pedido.getId())
                .dataPedido(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .cpf(pedido.getCliente().getCpf())
                .nomeCliente(pedido.getCliente().getNome())
                .total(pedido.getTotal())
                .status(pedido.getStatus().name())
                .itens(converter(pedido.getItens()))
                .build();
    }

	private Set<InformacaoItemPedidoDTO> converter( Set<ItemPedido> itens ){
		if(CollectionUtils.isEmpty(itens)){
			return Collections.emptySet();
	    }
	    return itens.stream().map(
	            item -> InformacaoItemPedidoDTO
	                       .builder().descricaoProduto(item.getProduto().getDescricao())
	                       .precoUnitario(item.getProduto().getPreco())
	                       .quantidade(item.getQuantidade())
	                       .build()
	    ).collect(Collectors.toSet());
	}
}












