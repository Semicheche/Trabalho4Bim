package br.univel.itemsvendas;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.univel.Vendas.Conexao;

public class ItemsVendasDAOImpl implements ItemsVendasDAO {

	Conexao conexao = new Conexao();
	
	@Override
	public void inserir(ItemsVendas itemv) {
		
		String sql = "INSERT INTO CLIENTE ( venda_idvenda, nomeproduto, custoproduto, margemlucro) VALUES (?, ?, ?)";
		
		try (PreparedStatement ps = conexao.getConnection().prepareStatement(sql)) {
			ps.setInt(1, itemv.getIdvenda());
			ps.setString(2, itemv.getNomeproduto());
			ps.setBigDecimal(3, itemv.getCustoproduto());
			ps.setBigDecimal(4, itemv.getMargemlucro());

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
		// TODO Auto-generated method stub
		return null;
	}

}
