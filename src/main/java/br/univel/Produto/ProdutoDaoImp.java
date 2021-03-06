package br.univel.Produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.univel.Cliente.Cliente;
import br.univel.Conexao.Conexao;
import br.univel.Enum.Unidade;
import br.univel.Models.ModelProduto;

public class ProdutoDaoImp implements ProdutoDAO {
	
	
	
	Conexao conexao = new Conexao();

	@Override
	public void inserir(Produto p) {
		String sql = "INSERT INTO produto (CATEGORIAPRODUTO_IDCATEGORIAPRODUTO, NOME, CODIGOBARRA, DESCRICAO, UNIDADE, CUSTO, LUCRO) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement ps = conexao.getConnection().prepareStatement(sql)) {
			ps.setInt(1, p.getCategoria());
			ps.setString(2, p.getNome());
			ps.setInt(3, p.getCodigodebarras());
			ps.setString(4, p.getDescricao());
			ps.setString(5, p.getUnidade().toString());
			ps.setBigDecimal(6, p.getCusto());
			ps.setBigDecimal(7, p.getMargemdelucro());
			

			ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Produto p) {
		String sql = "UPDATE PRODUTO SET CATEGORIAPRODUTO_IDCATEGORIAPRODUTO = ?, NOME = ?, CODIGOBARRA = ?, DESCRICAO = ?, UNIDADE = ?, CUSTO = ?, LUCRO = ? WHERE IDPRODUTO = ?";
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
			ps.setInt(1, p.getCategoria());
			ps.setString(2, p.getNome());
			ps.setInt(3, p.getCodigodebarras());
			ps.setString(4, p.getDescricao());
			ps.setString(5, p.getUnidade().toString());
			ps.setBigDecimal(6, p.getCusto());
			ps.setBigDecimal(7, p.getMargemdelucro());
			ps.setInt(8, p.getId());
			
			ps.executeUpdate();
			
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void excluir(Produto p) {
		
		String sql = "DELETE FROM PRODUTO WHERE idproduto = ? ";
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
			ps.setInt(1, p.getId());

			ps.executeUpdate();
			
			ps.close();
			new ModelProduto();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Produto buscar(int id) {
		Statement st = null;
		ResultSet result = null;

		String sql = "SELECT idproduto FROM produto";

		Produto p = null;
		
		
		try {
			try {
				st = conexao.getConnection().createStatement();
				result = st.executeQuery(sql);

				while (result.next()) {
					p = new Produto();
					
					p.setId(result.getInt("idproduto"));
									
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
		return p;
	}

	@Override
	public Produto buscarPorExemplo(Produto p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> listar() {
		Statement st = null;
		ResultSet result = null;

		String sql = "SELECT * FROM produto";

		ArrayList<Produto> lista = new ArrayList<>();
		Produto p;
		
		try {
			try {
				st = conexao.getConnection().createStatement();
				result = st.executeQuery(sql);

				while (result.next()) {
					p = new Produto();
					
					p.setId(result.getInt("idproduto"));
					p.setCategoria(result.getInt("categoriaproduto_idcategoriaproduto"));
					p.setNome(result.getString("nome"));
					p.setCodigodebarras(result.getInt("codigobarra"));
					p.setDescricao(result.getString("descricao"));
					p.setUnidade(Unidade.valueOf(result.getString("unidade")));	
					p.setCusto((result.getBigDecimal("custo")));
					p.setMargemdelucro(result.getBigDecimal("lucro"));	
					
					
					lista.add(p);

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
