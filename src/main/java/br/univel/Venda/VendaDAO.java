package br.univel.Venda;

import java.util.List;

public interface VendaDAO {
	
public void inserir(Venda v);
	
	public void atualizar(Venda v);
	
	public void excluir(Venda v);
	
	public Venda buscar(int id);
	
	public Venda buscarPorExemplo(Venda v);
	
	public List<Venda> listar();

}
