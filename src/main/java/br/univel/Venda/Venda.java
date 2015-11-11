package br.univel.Venda;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Venda {
	
	private int idvenda;
	private String nomecliente;
	private Timestamp horavenda;
	private Timestamp conclusaovenda;
	private BigDecimal total;
	
	
	public int getIdvenda() {
		return idvenda;
	}
	public void setIdvenda(int idvenda) {
		this.idvenda = idvenda;
	}
	public String getNomecliente() {
		return nomecliente;
	}
	public void setNomecliente(String nomecliente) {
		this.nomecliente = nomecliente;
	}
	public Timestamp getHoravenda() {
		return horavenda;
	}
	public void setHoravenda(Timestamp horavenda) {
		this.horavenda = horavenda;
	}
	public Timestamp getConclusaovenda() {
		return conclusaovenda;
	}
	public void setConclusaovenda(Timestamp conclusaovenda) {
		this.conclusaovenda = conclusaovenda;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	

}
