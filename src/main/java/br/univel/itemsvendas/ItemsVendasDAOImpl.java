package br.univel.itemsvendas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.univel.Vendas.Conexao;
import br.univel.Vendas.Produto;
import br.univel.Vendas.Unidade;

public class ItemsVendasDAOImpl implements ItemsVendasDAO {

	Conexao conexao = new Conexao();
	
	@Override
	public void inserir(ItemsVendas itemv) {
		
		String sql = "INSERT INTO itemsvenda (venda_idvenda, nomeproduto, custoproduto, margemlucro, quantidade) VALUES (?, ?, ?, ?, ?)";
		
		try (PreparedStatement ps = conexao.getConnection().prepareStatement(sql)) {
			ps.setInt(1, itemv.getIdvenda());
			ps.setString(2, itemv.getNomeproduto());
			ps.setBigDecimal(3, itemv.getCustoproduto());
			ps.setBigDecimal(4, itemv.getMargemlucro());
			ps.setBigDecimal(5,itemv.getQuantidade());

			ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	@Override
	public void atualizar(ItemsVendas itemv) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(ItemsVendas itemv) {
		// TODO Auto-generated method stub

	}

	@Override
	public ItemsVendas buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemsVendas buscarPorExemplo(ItemsVendas itemv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemsVendas> listar() {
		Statement st = null;
		ResultSet result = null;

		String sql = "SELECT * FROM itemsvenda";

		ArrayList<ItemsVendas> lista = new ArrayList<>();
		ItemsVendas iv;
		
		try {
			try {
				st = conexao.getConnection().createStatement();
				result = st.executeQuery(sql);

				while (result.next()) {
					iv = new ItemsVendas();
					
					iv.setIditemsvendas(result.getInt("iditemsvenda"));
					iv.setIdvenda(result.getInt("venda_idvenda"));
					iv.setNomeproduto(result.getString("nomeproduto"));
					iv.setCustoproduto(result.getBigDecimal("custoproduto"));
					iv.setMargemlucro(result.getBigDecimal("margemlucro"));
					iv.setQuantidade(result.getBigDecimal("quantidade"));	
					
					
					lista.add(iv);

				}

			} finally {
				if (st != null)
					st.close();
					
				if (result != null)
					result.close();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
		}

}
