package tech.jamersondev.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import tech.jamersondev.loja.domain.Pedido;

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
	
}
