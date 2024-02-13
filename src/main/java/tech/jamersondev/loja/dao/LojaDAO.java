package tech.jamersondev.loja.dao;

import javax.persistence.EntityManager;

import tech.jamersondev.loja.domain.Loja;

public class LojaDAO {

	private EntityManager entityManager;

	public LojaDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public void cadastrarLoja(Loja loja) {
		this.entityManager.persist(loja);
	}
	
	public void atualizarLoja(Loja loja) {
		this.entityManager.merge(loja);
	}
	
	public void removerLoja(Loja loja) {
		this.entityManager.remove(loja);
	}
	
	
}
