package br.univel.Produto;

import java.util.List;

import br.univel.Cliente.Cliente;

public interface ProdutoDAO {
	

	public void inserir(Produto p);
	
	public void atualizar(Produto p);
	
	public void excluir(Produto p);
	
	public Cliente buscar(int id);
	
	public Cliente buscarPorExemplo(Produto p);
	
	public List<Produto> listar();

}
