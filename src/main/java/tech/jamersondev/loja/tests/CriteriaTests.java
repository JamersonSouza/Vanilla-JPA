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

public class CriteriaTests {

	public static void main(String[] args) {
		cadastrarProduto();
		
		findDynamicUsandoCriteriaBuilder();
		
	}

	private static void findDynamicUsandoCriteriaBuilder() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
		List<Produto> findDynamicProdutosComCriteria = produtoDAO.findDynamicProdutosComCriteria("Xiaomi", null, null);
		System.out.println(findDynamicProdutosComCriteria);
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
