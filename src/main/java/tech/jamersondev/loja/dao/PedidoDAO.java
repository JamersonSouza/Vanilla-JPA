package tech.jamersondev.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import tech.jamersondev.loja.domain.Pedido;
import tech.jamersondev.loja.domain.RelatorioVendasDTO;

public class PedidoDAO {

	private EntityManager entityManager;

	public PedidoDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public void cadastrarPedido(List<Pedido> pedidos) {
		   for (Pedido pedido : pedidos) {
		        this.entityManager.persist(pedido);
		    }
	}
	
	public Pedido findPedido(Long id) {
		return this.entityManager.find(Pedido.class, id);
	}
	
	public List<Pedido> findAllPedidos() {
		String jpql = "SELECT p FROM Pedido p";
		return this.entityManager.createQuery(jpql, Pedido.class).getResultList();
	}
	
	public BigDecimal valorTotalVendido() {
		
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return this.entityManager.createQuery(jpql, BigDecimal.class).getSingleResult();
				
	}
	
	public List<RelatorioVendasDTO> relatorioVendas(){
		String jpql = "SELECT NEW tech.jamersondev.loja.domain.RelatorioVendasDTO(produto.nome, "
                + "SUM(itemPedido.quantidade),"
                + "MAX(pedido.dataPedido)) "
                + "FROM Pedido pedido "
                + "JOIN pedido.itemsPedido itemPedido "
                + "JOIN itemPedido.produto produto "
                + "GROUP BY produto.nome, itemPedido.quantidade "
                + "ORDER BY SUM(itemPedido.quantidade) DESC";

		return this.entityManager.createQuery(jpql, RelatorioVendasDTO.class).getResultList();
	}
	
	public Pedido buscarPedidoComCliente(Long id) {
		return this.entityManager.createQuery("SELECT p FROM Pedido  p JOIN FETCH p.cliente WHERE p.id = :id", Pedido.class)
				.setParameter("id", id)
				.getSingleResult();
	}
}
