package br.univel.Vendas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ClienteDaoImpl implements ClienteDao {
	
	Conexao conexao = new Conexao();

	@Override
	public void inserir(Cliente c) {
		String sql = "INSERT INTO CLIENTE ( NOME, FONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement ps = conexao.getConnection().prepareStatement(sql)) {
			ps.setString(1, c.getNome());
			ps.setString(3, c.getTelefone());
			ps.setString(2, c.getEndereco());
			ps.setString(4, c.getCidade());
			ps.setString(5, c.getEstado().toString());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getGenero().toString());
			

			ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void atualizar(Cliente c) {
		String sql = "UPDATE CLIENTE SET NOME = ?, TELEFONE = ?, ENDERECO = ?, CIDADE = ?, ESTADO = ?, EMAIL = ?, GENERO = ? WHERE ID = ? ";
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setString(3, c.getTelefone());
			ps.setString(2, c.getEndereco());
			ps.setString(4, c.getCidade());
			ps.setString(5, c.getEstado().toString());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getGenero().toString());
			ps.setInt(8, c.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void excluir(Cliente c) {
		String sql = "DELETE * FROM CLIENTE WHRERE ID = ?";
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
			ps.setInt(1, c.getId());

			ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Cliente buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscarPorExemplo(Cliente c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listar() {
		Statement st = null;
		ResultSet result = null;

		String sql = "SELECT * FROM CLIENTE";

		ArrayList<Cliente> lista = new ArrayList<>();
		
		Cliente c = new Cliente();
		
		try {
			try {
				st = conexao.getConnection().createStatement();
				result = st.executeQuery(sql);

				while (result.next()) {

					c.setNome(result.getString("nome"));
					c.setTelefone(result.getString("fone"));
					c.setEndereco(result.getString("endereco"));
					c.setCidade(result.getString("cidade"));
					c.setEstado((Estado) result.getObject("estado"));
					c.setEmail(result.getString("email"));
					c.setGenero((Genero) result.getObject("genero"));
					
					lista.add(c);

				}

			} finally {
				if (st != null)
					st.close();
					
				if (result != null)
					result.close();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
}
