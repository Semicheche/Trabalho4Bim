package br.univel.itemsvendas;

import java.util.List;

public interface ItemsVendasDAO {
	
public void inserir(ItemsVendas itemv );

	
	public void atualizar(ItemsVendas itemv);
	
	public void excluir(ItemsVendas itemv);
	
	public ItemsVendas buscar(int id);
	
	public ItemsVendas buscarPorExemplo(ItemsVendas itemv);
	
	public List<ItemsVendas> listar();


}
