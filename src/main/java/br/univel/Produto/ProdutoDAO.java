package br.univel.Produto;

import java.util.List;

public interface ProdutoDAO {
	

	public void inserir(Produto p);
	
	public void atualizar(Produto p);
	
	public void excluir(Produto p);
	
	public Produto buscar(int id);
	
	public Produto buscarPorExemplo(Produto p);
	
	public List<Produto> listar();

}
