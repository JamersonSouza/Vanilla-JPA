package tech.jamersondev.loja.tests;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import tech.jamersondev.loja.dao.ClienteDAO;
import tech.jamersondev.loja.dao.LojaDAO;
import tech.jamersondev.loja.dao.PedidoDAO;
import tech.jamersondev.loja.dao.ProdutoDAO;
import tech.jamersondev.loja.domain.Cliente;
import tech.jamersondev.loja.domain.ItemPedido;
import tech.jamersondev.loja.domain.Loja;
import tech.jamersondev.loja.domain.Pedido;
import tech.jamersondev.loja.domain.Produto;
import tech.jamersondev.loja.domain.RelatorioVendasDTO;
import tech.jamersondev.loja.enums.CategoriaProdutosEnum;
import tech.jamersondev.loja.util.JPAUtil;

public class CadastroPedidos {
	
		public static void main(String[] args) {
			cadastrarProduto();
			
			NovoPedido();
			findPedidoComCliente();
		}

		private static void findPedidoComCliente() {
			EntityManager entityManager = JPAUtil.getEntityManager();
			PedidoDAO pedidodao = new PedidoDAO(entityManager);
			Pedido pedido = pedidodao.buscarPedidoComCliente(1l);
			entityManager.close();
			System.out.println("nome do cliente após conexão fechada: "+ pedido.getCliente().getNome());
		}

		private static void NovoPedido() {
			EntityManager entityManager = JPAUtil.getEntityManager();
			ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
			Produto produto = produtoDAO.findProduto(1l);
			
			Cliente cliente = new Cliente(UUID.randomUUID(), "Jamerson", "123.456.789-10");
			Cliente cliente2 = new Cliente(UUID.randomUUID(), "Nathalia", "123.456.789-10");
			Pedido pedido1 = new Pedido(cliente);
			Pedido pedido2 = new Pedido(cliente2);
			pedido1.adicionarItem(new ItemPedido(10, pedido1, produto));
			pedido2.adicionarItem(new ItemPedido(12, pedido1, produto));
			
			entityManager.getTransaction().begin();
			
			PedidoDAO pedidoDAO = new PedidoDAO(entityManager);
			pedidoDAO.cadastrarPedido(List.of(pedido1, pedido2));
			
			ClienteDAO clienteDAO = new ClienteDAO(entityManager);
			clienteDAO.cadastrarCliente(List.of(cliente, cliente2));
			
			entityManager.getTransaction().commit();
			
			BigDecimal totalVendido = pedidoDAO.valorTotalVendido();
			System.out.println("Valor total vendido foi: " + totalVendido);
			
			List<RelatorioVendasDTO> relatorio = pedidoDAO.relatorioVendas();
			relatorio.forEach(System.out::println);
		}
		
		private static void cadastrarProduto() {
			Loja loja = new Loja(UUID.randomUUID(), "Magazine Luiza");
			Loja loja2 = new Loja(UUID.randomUUID(), "Kabum");
			Loja loja3 = new Loja(UUID.randomUUID(), "Casas bahia");
			
			Produto celular = new Produto(UUID.randomUUID(), "Xiaomi",
					"Redmi note 12", new BigDecimal("1000"), CategoriaProdutosEnum.CELULAR,
					loja2);
			
			Produto celular2 = new Produto(UUID.randomUUID(), "Samsung",
					"A12", new BigDecimal("1300"), CategoriaProdutosEnum.CELULAR,
					loja);
			
			Produto celular3 = new Produto(UUID.randomUUID(), "Asus",
					"Zenfone", new BigDecimal("790"), CategoriaProdutosEnum.CELULAR,
					loja3);
			
			EntityManager entityManager = JPAUtil.getEntityManager();
			LojaDAO lojaDAO = new LojaDAO(entityManager);
			ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
			
			entityManager.getTransaction().begin();
			lojaDAO.cadastrarLoja(List.of(loja, loja2, loja3));
			produtoDAO.cadastrarProduto(List.of(celular, celular2, celular3));
			entityManager.getTransaction().commit();
			entityManager.close();
		}

}
