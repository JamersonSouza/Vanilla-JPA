package tech.jamersondev.loja.dao;

import java.math.BigDecimal;
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
	
	public List<Produto> findByNameLoja(String name) {
		String jpql = "SELECT p FROM Produto p WHERE p.loja.nome = :name";
		return this.entityManager.createQuery(jpql, Produto.class)
				.setParameter("name", name)
				.getResultList();
	}
	
	public BigDecimal findByPrecoProdutoComNome(String name) {
		String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :name";
		return this.entityManager.createQuery(jpql, BigDecimal.class)
				.setParameter("name", name)
				.getSingleResult();
	}
}
