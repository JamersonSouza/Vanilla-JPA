package tech.jamersondev.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import tech.jamersondev.loja.domain.Cliente;

public class ClienteDAO {

	private EntityManager entityManager;

	public ClienteDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public void cadastrarCliente(List<Cliente> Clientes) {
		   for (Cliente cliente : Clientes) {
		        this.entityManager.persist(cliente);
		    }
	}
	
	public Cliente findCliente(Long id) {
		return this.entityManager.find(Cliente.class, id);
	}
	
	public List<Cliente> findAllClientes() {
		String jpql = "SELECT p FROM Cliente p";
		return this.entityManager.createQuery(jpql, Cliente.class).getResultList();
	}
	
}
