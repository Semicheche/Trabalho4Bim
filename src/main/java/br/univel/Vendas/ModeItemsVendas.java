package br.univel.Vendas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.univel.itemsvendas.ItemsVendas;

public class ModeItemsVendas extends AbstractTableModel {

	ArrayList<ItemsVendas> lista = new ArrayList<>();

	
	public ModeItemsVendas() {
		
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
			return "Descricao";
		case 1:
			return "Valor";
		default:
			return "Ouve algun Erro";
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		fireTableStructureChanged();
		
		switch (columnIndex) {
		case 0:
			return lista.get(rowIndex).getNomeproduto();
		case 1:
			return lista.get(rowIndex).getCustoproduto();
		default:
			return "Ouve algun Erro";
		}
	}

}
