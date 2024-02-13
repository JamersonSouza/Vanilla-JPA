package tech.jamersondev.loja.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Loja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "lojaIdentifier")
	private UUID lojaIdentifier;
	private String nome;
	
	public Loja(UUID lojaIdentifier, String nome) {
		super();
		this.lojaIdentifier = lojaIdentifier;
		this.nome = nome;
	}
	
	public Loja() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UUID getLojaIdentifier() {
		return lojaIdentifier;
	}
	public void setLojaIdentifier(UUID lojaIdentifier) {
		this.lojaIdentifier = lojaIdentifier;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
