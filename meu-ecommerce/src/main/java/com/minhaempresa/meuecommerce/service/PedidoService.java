package com.minhaempresa.meuecommerce.service;

import com.minhaempresa.meuecommerce.dto.NovoPedidoRequest;
import com.minhaempresa.meuecommerce.model.Pedido;
import com.minhaempresa.meuecommerce.model.ProdutoCarrinho;
import com.minhaempresa.meuecommerce.model.ProdutoPedido;
import com.minhaempresa.meuecommerce.model.StatusPedido;
import com.minhaempresa.meuecommerce.repository.CarrinhoRepository;
import com.minhaempresa.meuecommerce.repository.PedidoRepository;
import com.minhaempresa.meuecommerce.utils.CloneUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private FraudeService fraudeService;

    @Autowired
    private EstoqueService estoqueService;

    @Autowired
    private CloneUtils cloneUtils;

    @Transactional
    public Pedido criarNovoPedido(NovoPedidoRequest novoPedido) {
        var carrinho = carrinhoRepository.findById(novoPedido.idCarrinho()).orElseThrow(() -> new IllegalArgumentException("Carrinho não encontrado"));

        if(carrinho.getProdutos().size() <= 0) throw new RuntimeException("Carrinho vazio");

        var valorTotal = carrinho.getProdutos().stream().mapToDouble(produto -> produto.getValor()).sum();
        Pedido pedido = new Pedido();
        pedido.setCliente(carrinho.getCliente());
        pedido.setProdutos(carrinho.getProdutos().stream().map(produtoCarrinho -> this.produtoCarrinhoToProdutoPedido(produtoCarrinho, pedido)).toList());
        pedido.setDataPedido(LocalDate.now());
        pedido.setStatus(StatusPedido.PROCESSANDO);
        pedido.setValorTotal(valorTotal);
        pedidoRepository.save(pedido);


        if(fraudeService.verificarPossivelFraude(pedido)) {
            pedido.setStatus(StatusPedido.FRAUDE);
            throw new RuntimeException("Compra é uma fraude");
        }

        if(!estoqueService.reservaEstoque(pedido)) {
            pedido.setStatus(StatusPedido.CANCELADO);
            throw new RuntimeException("Estoque insuficiente");
        }

        var pagamento = pagamentoService.efetuarPagamento(novoPedido.pagamento());

        if(!pagamento.getAutorizado()) {
            estoqueService.rollbackEstoque(pedido);
            pedido.setStatus(StatusPedido.NAO_AUTORIZADO);
            throw new RuntimeException("Pagamento não autorizado");
        }

        pedido.setStatus(StatusPedido.EM_SEPARACAO);
        return pedido;
    }

    private ProdutoPedido produtoCarrinhoToProdutoPedido(ProdutoCarrinho produtoCarrinho, Pedido pedido) {
        ProdutoPedido produtoPedido = new ProdutoPedido();
        produtoPedido.setProduto(produtoCarrinho.getProduto());
        produtoPedido.setQuantidade(produtoCarrinho.getQuantidade());
        produtoPedido.setValor(produtoCarrinho.getValor());
        produtoPedido.setPedido(pedido);
        return produtoPedido;
    }

    public Pedido buscarPorId(String id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido atualizarPedido(Pedido pedidoDto, String id) throws InvocationTargetException, IllegalAccessException {
        var pedido = pedidoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
        cloneUtils.copyProperties(pedido, pedidoDto);
        System.out.println(pedido.getStatus());
        pedidoRepository.save(pedido);
        return pedido;
    }
}
