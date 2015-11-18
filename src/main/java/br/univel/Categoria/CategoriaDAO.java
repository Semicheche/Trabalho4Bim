package br.univel.Categoria;

import java.util.List;

public interface CategoriaDAO {
	
	public void inserir(Categoria c);
	
	public void atualizar(Categoria c);
	
	public void excluir(Categoria c);
	
	public Categoria buscar(int id);
	
	public Categoria buscarPorExemplo(Categoria c);
	
	public List<Categoria> listar();

}
