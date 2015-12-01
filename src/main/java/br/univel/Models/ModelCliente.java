package br.univel.Models;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.Cliente.Cliente;
import br.univel.Cliente.ClienteDaoImpl;

/**
 * 
 * @author Luciano Semicheche - 02/11/2015 21:27:12
 *
 */
public class ModelCliente extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ClienteDaoImpl cdao = new ClienteDaoImpl();
	
	protected List<Cliente> lista;
	
	public ModelCliente() {
		lista = cdao.listar();
		fireTableDataChanged();
	}
	
	@Override
	public int getRowCount() {
		return lista.size();
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
		case 7:
			return "email";
		default:
			return "Ouve algun erro";
			
		}
		
	}

	@Override
	public Object getValueAt(int row, int col) {
	
		Cliente c = (Cliente) cdao.listar().get(row);
		
		switch (col) {
	
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
		case 7:
			return c.getEmail();
		default:
			return "Ouve algun erro";
			
		}
	}

}
