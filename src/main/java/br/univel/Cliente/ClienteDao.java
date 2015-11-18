package br.univel.Cliente;

import java.util.List;

/**
 * @author Luciano Semicheche - 02/11/2015 21:27:38
 * 
 *
 */

public interface ClienteDao {
	
	public void inserir(Cliente c);
	
	public void atualizar(Cliente c);
	
	public void excluir(Cliente c);
	
	public Cliente buscar(int id);
	
	public Cliente buscarPorExemplo(Cliente c);
	
	public List<Cliente> listar();

}
