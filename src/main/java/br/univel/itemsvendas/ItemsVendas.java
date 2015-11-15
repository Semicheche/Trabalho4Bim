package br.univel.itemsvendas;

import java.math.BigDecimal;

public class ItemsVendas {
	
	private int iditemsvendas;
	private int idvenda;
	private BigDecimal quantidade;
	private String nomeproduto;
	private BigDecimal custoproduto;
	private BigDecimal margemlucro;
	
	
	public BigDecimal getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getIditemsvendas() {
		return iditemsvendas;
	}
	public void setIditemsvendas(int iditemsvendas) {
		this.iditemsvendas = iditemsvendas;
	}
	public int getIdvenda() {
		return idvenda;
	}
	public void setIdvenda(int idvenda) {
		this.idvenda = idvenda;
	}
	public String getNomeproduto() {
		return nomeproduto;
	}
	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto;
	}
	public BigDecimal getCustoproduto() {
		return custoproduto;
	}
	public void setCustoproduto(BigDecimal custoproduto) {
		this.custoproduto = custoproduto;
	}
	public BigDecimal getMargemlucro() {
		return margemlucro;
	}
	public void setMargemlucro(BigDecimal margemlucro) {
		this.margemlucro = margemlucro;
	}

}
