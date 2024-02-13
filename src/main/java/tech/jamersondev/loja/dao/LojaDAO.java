package tech.jamersondev.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import tech.jamersondev.loja.domain.Loja;

public class LojaDAO {

	private EntityManager entityManager;

	public LojaDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public void cadastrarLoja(List<Loja> loja) {
		for(Loja lj : loja) {
			this.entityManager.persist(lj);
		}
	}
	
	public void atualizarLoja(Loja loja) {
		this.entityManager.merge(loja);
	}
	
	public void removerLoja(Loja loja) {
		this.entityManager.remove(loja);
	}
	
	
}
