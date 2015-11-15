package br.univel.Venda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.univel.Vendas.Conexao;
import br.univel.itemsvendas.ItemsVendas;

public class VendaDaoImp implements VendaDAO {
	
	Conexao conexao = new Conexao();

	@Override
	public void inserir(Venda v) {
		String sql = "INSERT INTO VENDA ( nomecliente, horavenda, alteracaovenda, total) VALUES (?, ?, ?, ?)";
		
		try (PreparedStatement ps = conexao.getConnection().prepareStatement(sql)) {
			ps.setString(1, v.getNomecliente());
			ps.setTimestamp(2, v.getHoravenda());
			ps.setTimestamp(3, v.getAlteracaovenda());
			ps.setBigDecimal(4, v.getTotal());	

			ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	@Override
	public void atualizar(Venda v) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Venda v) {
		// TODO Auto-generated method stub

	}

	@Override
	public Venda buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venda buscarPorExemplo(Venda v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venda> listar() {
		Statement st = null;
		ResultSet result = null;

		String sql = "SELECT * FROM venda";

		ArrayList<Venda> lista = new ArrayList<>();
		Venda v;
		
		try {
			try {
				st = conexao.getConnection().createStatement();
				result = st.executeQuery(sql);

				while (result.next()) {
					v = new Venda();
					
					v.setIdvenda(result.getInt("idvenda"));
					v.setNomecliente(result.getString("nomecliente"));
					v.setAlteracaovenda(result.getTimestamp("alteracaovenda"));
					v.setHoravenda(result.getTimestamp("horavenda"));
					v.setTotal(result.getBigDecimal("total"));
					
					
					lista.add(v);

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
