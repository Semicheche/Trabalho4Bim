package br.univel.Vendas;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProdutoDaoImp implements ProdutoDAO {
	
	Conexao conexao = new Conexao();

	@Override
	public void inserir(Produto p) {
		String sql = "INSERT INTO PRODUTO ( CATEGORIAPRODUTO_IDCATEGORIAPRODUTO, NOME, CODIGOBARRA, DESCRICAO, UNIDADE, CUSTO, LUCRO) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement ps = conexao.getConnection().prepareStatement(sql)) {
			ps.setString(1, p.getCategoria().toString());
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
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Produto p) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cliente buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscarPorExemplo(Produto p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
