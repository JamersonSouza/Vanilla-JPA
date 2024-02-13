package tech.jamersondev.loja.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "clienteIdentifier")
	private UUID clienteIdentifier;
	private String nome;
	private String cpf;
	

	public Cliente(UUID clienteIdentifier, String nome, String cpf) {
		this.clienteIdentifier = clienteIdentifier;
		this.nome = nome;
		this.cpf = cpf;
	}

	public Cliente() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getClienteIdentifier() {
		return clienteIdentifier;
	}

	public void setClienteIdentifier(UUID clienteIdentifier) {
		this.clienteIdentifier = clienteIdentifier;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
