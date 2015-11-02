package br.univel.Vendas;

import java.util.List;

public interface ProdutoDAO {
	

	public void inserir(Produto p);
	
	public void atualizar(Produto p);
	
	public void excluir(Produto p);
	
	public Cliente buscar(int id);
	
	public Cliente buscarPorExemplo(Produto p);
	
	public List<Produto> listar();

}
