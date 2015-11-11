package br.univel.Venda;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.univel.Vendas.Conexao;

public class VendaDaoImp implements VendaDAO {
	
	Conexao conexao = new Conexao();

	@Override
	public void inserir(Venda v) {
		String sql = "INSERT INTO VENDA ( nomecliente, horavenda, conclusaovenda, totoal) VALUES (?, ?, ?, ?)";
		
		try (PreparedStatement ps = conexao.getConnection().prepareStatement(sql)) {
			ps.setString(1, v.getNomecliente());
			ps.setTimestamp(2, v.getHoravenda());
			ps.setTimestamp(3, v.getConclusaovenda());
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
		// TODO Auto-generated method stub
		return null;
	}

}
