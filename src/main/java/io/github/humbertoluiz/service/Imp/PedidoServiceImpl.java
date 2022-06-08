package io.github.humbertoluiz.service.Imp;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.humbertoluiz.domain.entity.Cliente;
import io.github.humbertoluiz.domain.entity.ItemPedido;
import io.github.humbertoluiz.domain.entity.Pedido;
import io.github.humbertoluiz.domain.entity.Produto;
import io.github.humbertoluiz.domain.enums.StatusPedido;
import io.github.humbertoluiz.domain.repository.ClienteRepository;
import io.github.humbertoluiz.domain.repository.ItemPedidoRepository;
import io.github.humbertoluiz.domain.repository.PedidoRepository;
import io.github.humbertoluiz.domain.repository.ProdutoRepository;
import io.github.humbertoluiz.dto.ItemPedidoDTO;
import io.github.humbertoluiz.dto.PedidoDTO;
import io.github.humbertoluiz.exception.PedidoNaoEncontradoException;
import io.github.humbertoluiz.exception.RegraNegocioException;
import io.github.humbertoluiz.service.PedidoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

	private final PedidoRepository pedidoRepository;
	private final ClienteRepository clienteRepository;
	private final ProdutoRepository produtoRepository;
	private final ItemPedidoRepository itemPedidoRepository;

    @Override
    @Transactional
    public Pedido salvar( PedidoDTO pedidoDTO ) {
        Long clienteId = pedidoDTO.getCliente();
        Cliente cliente = clienteRepository
                .findById(clienteId)
                .orElseThrow(() -> new RegraNegocioException("Código de cliente inválido."));

        Pedido pedido = new Pedido();
        pedido.setTotal(pedidoDTO.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.REALIZADO);


        Set<ItemPedido> itensPedido = converterItens(pedido, pedidoDTO.getItens());
        pedidoRepository.save(pedido);
        itemPedidoRepository.saveAll(itensPedido);
        pedido.setItens(itensPedido);
        return pedido;
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Long pedidoId) {
        return pedidoRepository.findByIdFetchItens(pedidoId);
    }

    private Set<ItemPedido> converterItens(Pedido pedido, Set<ItemPedidoDTO> itens){
        if(itens.isEmpty()){
            throw new RegraNegocioException("Não é possível realizar um pedido sem itens.");
        }

        return itens
                .stream()
                .map( pedidoDTO -> {
                    Long ProdutoId = pedidoDTO.getProduto();
                    Produto produto = produtoRepository
                            .findById(ProdutoId)
                            .orElseThrow(
                                    () -> new RegraNegocioException(
                                            "Código de produto inválido: "+ ProdutoId
                                    ));

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(pedidoDTO.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                }).collect(Collectors.toSet());

    }

	@Override
	@Transactional
	public void atualizaStatus(Long pedidoId, StatusPedido statusPedido) {
		pedidoRepository.findById(pedidoId)
		.map( pedido -> {
			pedido.setStatus(statusPedido);
			return pedidoRepository.save(pedido);
		}).orElseThrow( () -> new PedidoNaoEncontradoException());
		
	}
}
