package br.univel.Vendas;

import java.awt.List;


import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModelProduto extends AbstractTableModel {
	
	ProdutoDaoImp pdao = new ProdutoDaoImp();
	
	ArrayList<Produto> lista;
	
	public ModelProduto() {
		lista = (ArrayList<Produto>) pdao.listar();
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		
		return 8;
	}

	@Override
	public String getColumnName(int column) {
		
		switch (column) {
			case 0:
				return "ID";
			case 1:
				return "Categoria";
			case 2:
				return "Nome";
			case 3:
				return "Codigo de Barras";
			case 4:
				return "Descrição";
			case 5:
				return "Unidade";
			case 6:
				return "Custo";
			case 7:
				return "Lucro";
			default:
				return "ouve um Erro";
		}
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Produto p = lista.get(rowIndex);
		
		switch (columnIndex) {
			case 0:
				return p.getId();
			case 1:
				return p.getCategoria();
			case 2:
				return p.getNome();
			case 3:
				return p.getCodigodebarras();
			case 4:
				return p.getDescricao();
			case 5:
				return p.getUnidade();
			case 6:
				return p.getCusto();
			case 7:
				return p.getMargemdelucro();
			default:
				return "ouve um Erro";
	}
	}

}
