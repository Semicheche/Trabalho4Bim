package br.univel.Vendas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public abstract class ModelCliente extends AbstractTableModel {
	
	ClienteDaoImpl cdao = new ClienteDaoImpl();
	
	List<Cliente> clientes = cdao.listar();
	
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
			return"Estado";
		case 6:
			return "Genero";
		default:
			return "email";
			
		}
		
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	
		Cliente c = cdao.listar().get(rowIndex);
		
		switch (columnIndex) {
	
		case 0:
			return c.getId();
		case 1:
			return c.getNome();
		case 2:
			return c.getEndereco();
		case 3:
			return c.getTelefone();
		case 4:
			return c.getCidade();
		case 5:
			return c.getEstado();
		case 6:
			return c.getGenero();
		default:
			return c.getEmail();
			
		}
	}

}
