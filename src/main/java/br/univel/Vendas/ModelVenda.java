package br.univel.Vendas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.univel.Venda.Venda;

public class ModelVenda extends AbstractTableModel {
	
	ArrayList<Venda> lista;
	public ModelVenda() {
		
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
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		
		switch (columnIndex) {
		case 0:
			return lista.get(rowIndex);

		}
		return columnIndex;
	}

}
