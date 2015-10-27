package br.univel.Vendas;

import java.math.BigDecimal;

public class Produto {
	
	private int id;
	private int codigodebarras;
	private Categoria categoria;
	private String descricao;
	private Unidade unidade;
	private BigDecimal custo;
	private BigDecimal margemdelucro;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCodigodebarras() {
		return codigodebarras;
	}
	public void setCodigodebarras(int codigodebarras) {
		this.codigodebarras = codigodebarras;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	

}
