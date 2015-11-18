package br.univel.Models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.univel.Categoria.Categoria;
import br.univel.Categoria.CategoriaDaoImp;

public class ModelCategoria extends AbstractTableModel {
	
	CategoriaDaoImp cdao = new CategoriaDaoImp();

	public ArrayList<Categoria> lista;
	
	public ModelCategoria() {
		lista = (ArrayList<Categoria>) cdao.listar();
	}
	
	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "ID";
		case 1:
			return "Nome";
		default:
			return "Ouve algun Erro";
		}
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Categoria c = lista.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			return c.getId();
		case 1:
			return c.getCategoria();
		default:
			return "Ouve algun erro";
		}
	}
	

}
