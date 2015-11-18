package br.univel.Categoria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.univel.Conexao.Conexao;
import br.univel.Models.ModelCategoria;

public class CategoriaDaoImp implements CategoriaDAO {

	Conexao conexao = new Conexao();
	
	@Override
	public void inserir(Categoria c) {
		String sql = "INSERT INTO categoriaproduto (nome) VALUES (?)";
		
		try (PreparedStatement ps = conexao.getConnection().prepareStatement(sql)) {
			ps.setString(1, c.getCategoria());
			
			ps.executeUpdate();

			ps.close();
			
			new ModelCategoria().fireTableDataChanged();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void atualizar(Categoria c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Categoria c) {
		
		String sql = "DELETE FROM categoriaproduto WHERE idusuario = ?";
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
			ps.setInt(1, c.getId());

			ps.executeUpdate();

			ps.close();
			
			new ModelCategoria().fireTableDataChanged();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Categoria buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria buscarPorExemplo(Categoria c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> listar() {
		
		Statement st = null;
		ResultSet result = null;

		String sql = "SELECT * FROM categoriaproduto";

		ArrayList<Categoria> lista = new ArrayList<>();
		Categoria c;
		
		try {
			try {
				st = conexao.getConnection().createStatement();
				result = st.executeQuery(sql);

				while (result.next()) {
					c = new Categoria();
					
					c.setId(result.getInt("idcategoriaproduto"));
					c.setCategoria(result.getString("nome"));
					
					lista.add(c);

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
