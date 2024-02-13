package tech.jamersondev.loja.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import tech.jamersondev.loja.enums.CategoriaProdutosEnum;

@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "produtoIdentifier")
	private UUID prodIdentifier;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private LocalDate dataCadastro = LocalDate.now();
	@Enumerated(EnumType.STRING)
	private CategoriaProdutosEnum categoria;
	@ManyToOne
	private Loja loja;
	
	
	
	public Produto(UUID prodIdentifier, String nome, String descricao, BigDecimal preco, CategoriaProdutosEnum categoria, Loja loja) {
		super();
		this.prodIdentifier = prodIdentifier;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
		this.loja = loja;
	}
	
	public Produto() {
	
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UUID getProdIdentifier() {
		return prodIdentifier;
	}
	public void setProdIdentifier(UUID prodIdentifier) {
		this.prodIdentifier = prodIdentifier;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public CategoriaProdutosEnum getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProdutosEnum categoria) {
		this.categoria = categoria;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", prodIdentifier=" + prodIdentifier + ", nome=" + nome + ", descricao="
				+ descricao + ", preco=" + preco + ", dataCadastro=" + dataCadastro + ", categoria=" + categoria
				+ ", loja=" + loja + "]";
	}
	
	
}
