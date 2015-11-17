package br.univel.Vendas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.CharacterAction;

public class UsuarioDaoImpl implements UsuarioDao {

	Conexao conexao = new Conexao();
	
	@Override
	public void inserir(Usuario u) {
String sql = "INSERT INTO USUARIO (cliente_idcliente, senha) VALUES (?, ?)";
		
		try (PreparedStatement ps = conexao.getConnection().prepareStatement(sql)) {
			ps.setInt(1, u.getId_cliente());
			ps.setString(2, u.getSenha().toString());
			
			ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void atualizar(Usuario u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Usuario u) {
		String sql = "DELETE FROM usuario WHERE idusuario = ?";
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
			ps.setInt(1, u.getId());

			ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Usuario buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarPorExemplo(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listar() {
		Statement st = null;
		ResultSet result = null;

		String sql = "SELECT * FROM usuario";

		ArrayList<Usuario> lista = new ArrayList<>();
		Usuario u;
		
		try {
			try {
				st = conexao.getConnection().createStatement();
				result = st.executeQuery(sql);

				while (result.next()) {
					u = new Usuario();
					
					u.setId(result.getInt("idusuario"));
					u.setId_cliente(result.getInt("cliente_idcliente"));
					u.setSenha(result.getString("senha"));
					
					lista.add(u);

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
