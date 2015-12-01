package br.univel.Models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.univel.itemsvendas.ItemsVendas;

public class ModeItemsVendas extends AbstractTableModel {

	public ArrayList<ItemsVendas> lista;
	
	public ModeItemsVendas() {
		lista = new ArrayList<ItemsVendas>();
		fireTableStructureChanged();
	}
	
	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
			return 3;
	}
	
	@Override
	public String getColumnName(int column) {
		
		switch (column) {
		
		case 0:
			return "Descricao";
		case 1:
			return "Valor";
		case 2:
			return "quantidade";
		default:
			return "Ouve algum Erro!";
			
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		ItemsVendas i = lista.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			return i.getNomeproduto();
		case 1:
			return i.getCustoproduto();
		case 2:
			return i.getQuantidade();
		default:
			return "Ouve algun Erro";
		}
	}

}
