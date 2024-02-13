package tech.jamersondev.loja.domain;

import java.time.LocalDate;

public class RelatorioVendasDTO {

	private String nomeProduto;
	private Long quantidadeVendida;
	private LocalDate dataUltimaVenda;
	
	public RelatorioVendasDTO(String nomeProduto, Long quantidadeVendida, LocalDate dataUltimaVenda) {
		super();
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.dataUltimaVenda = dataUltimaVenda;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public Long getQuantidadeVendida() {
		return quantidadeVendida;
	}
	public void setQuantidadeVendida(Long quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}
	public LocalDate getDataUltimaVenda() {
		return dataUltimaVenda;
	}
	public void setDataUltimaVenda(LocalDate dataUltimaVenda) {
		this.dataUltimaVenda = dataUltimaVenda;
	}
	@Override
	public String toString() {
		return "RelatorioVendasDTO [nomeProduto=" + nomeProduto + ", quantidadeVendida=" + quantidadeVendida
				+ ", dataUltimaVenda=" + dataUltimaVenda + "]";
	}
	
	
	
	
}
