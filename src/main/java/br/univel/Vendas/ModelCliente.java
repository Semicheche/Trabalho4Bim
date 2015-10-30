package br.univel.Vendas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public abstract class ModelCliente extends AbstractTableModel {

	List<Cliente> clientes = new ArrayList<>();
	
	@Override
	public int getRowCount() {
		
		return clientes.size();
	}

	@Override
	public int getColumnCount() {
		
		return 7;
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "ID";
		case 1:
			return "Nome";
		case 2:
			return "Endereço";
		case 3:
			return "Telefone";
		case 4:
			return "Cidade";
		case 5:
			return "UF";
		case 6:
			return "Genero";
		default:
			return "Houve algun erro";
			
		}
		
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
