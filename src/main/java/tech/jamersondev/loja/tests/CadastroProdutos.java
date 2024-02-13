package tech.jamersondev.loja.tests;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import tech.jamersondev.loja.dao.LojaDAO;
import tech.jamersondev.loja.dao.ProdutoDAO;
import tech.jamersondev.loja.domain.Loja;
import tech.jamersondev.loja.domain.Produto;
import tech.jamersondev.loja.enums.CategoriaProdutosEnum;
import tech.jamersondev.loja.util.JPAUtil;

public class CadastroProdutos {

	public static void main(String[] args) {
		
		cadastrarProduto();
		findProduto();
		findAllProdutos();
	}

	private static void findAllProdutos() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
		List<Produto> getAllProdutos = produtoDAO.findAllProdutos();
		getAllProdutos.forEach(p -> {System.out.println(p.getNome());});
	}

	private static void findProduto() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
		Produto p1 = produtoDAO.findProduto(1l);
		System.out.println(p1);
	}

	private static void cadastrarProduto() {
		Loja loja = new Loja(UUID.randomUUID(), "Magazine Luiza");
		
		Produto celular = new Produto(UUID.randomUUID(), "Xiaomi",
				"Redmi note 12", new BigDecimal("800"), CategoriaProdutosEnum.CELULAR,
				loja);
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		LojaDAO lojaDAO = new LojaDAO(entityManager);
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
		
		entityManager.getTransaction().begin();
		lojaDAO.cadastrarLoja(loja);
		produtoDAO.cadastrarProduto(celular);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
