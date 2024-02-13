package tech.jamersondev.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import tech.jamersondev.loja.domain.Produto;

public class ProdutoDAO {

	private EntityManager entityManager;

	public ProdutoDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public void cadastrarProduto(List<Produto> prod) {
		   for (Produto produto : prod) {
		        this.entityManager.persist(produto);
		    }
	}
	
	public Produto findProduto(Long id) {
		return this.entityManager.find(Produto.class, id);
	}
	
	public List<Produto> findAllProdutos() {
		String jpql = "SELECT p FROM Produto p";
		return this.entityManager.createQuery(jpql, Produto.class).getResultList();
	}
	
	public List<Produto> findByNameProduto(String name) {
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :name";
		return this.entityManager.createQuery(jpql, Produto.class)
				.setParameter("name", name)
				.getResultList();
	}
	
}
