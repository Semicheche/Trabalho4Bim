package br.univel.Vendas;

import java.math.BigDecimal;

/**
 * 
 * @author Luciano Semicheche - 02/11/2015 21:30:03
 *
 */
public class Produto {
	
	private int id;
	private int codigodebarras;
	private String nome;
	private Categoria categoria;
	private String descricao;
	private Unidade unidade;
	private BigDecimal custo;
	private BigDecimal margemdelucro;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
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
	public BigDecimal getCusto() {
		return custo;
	}
	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}
	public BigDecimal getMargemdelucro() {
		return margemdelucro;
	}
	public void setMargemdelucro(BigDecimal margemdelucro) {
		this.margemdelucro = margemdelucro;
	}
	
	

}
