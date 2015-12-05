package br.univel.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.Conexao.Conexao;
import br.univel.Enum.Estado;
import br.univel.Enum.Genero;
import br.univel.Models.ModelCliente;

/**
 * 
 * @author Luciano Semicheche - 02/11/2015 21:28:03
 *
 */

public class ClienteDaoImpl implements ClienteDao {
	
	Conexao conexao = new Conexao();

	@Override
	public void inserir(Cliente c) {
		
		
		String sql = "INSERT INTO CLIENTE ( NOME, FONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement ps = conexao.getConnection().prepareStatement(sql)) {
			
			ps.setString(1, c.getNome());
			ps.setString(2, c.getTelefone());
			ps.setString(3, c.getEndereco());
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
		
		String sql = "UPDATE cliente SET nome = ?, fone = ?, endereco = ?, cidade = ?, estado = ?, email = ?, genero = ? WHERE idcliente = ? ";
		
		try {
			
			PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getTelefone());
			ps.setString(3, c.getEndereco());
			ps.setString(4, c.getCidade());
			ps.setString(5, c.getEstado().toString());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getGenero().toString());
			ps.setInt(8, c.getId());
			
			ps.executeUpdate();
			
			ps.close();
						
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar o item\n ERRO:"+e);
		}

	}

	@Override
	public void excluir(Cliente c) {
		String sql = "DELETE FROM CLIENTE WHERE IDCLIENTE = ?";
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
			ps.setInt(1, c.getId());

			ps.executeUpdate();

			ps.close();

		new ModelCliente().fireTableDataChanged();
		
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

		String sql = "SELECT * FROM cliente";

		ArrayList<Cliente> lista = new ArrayList<>();
		Cliente c;
		
		try {
			try {
				st = conexao.getConnection().createStatement();
				result = st.executeQuery(sql);

				while (result.next()) {
					c = new Cliente();
					
					c.setId(result.getInt("idcliente"));
					c.setNome(result.getString("nome"));
					c.setTelefone(result.getString("fone"));
					c.setEndereco(result.getString("endereco"));
					c.setCidade(result.getString("cidade"));
					c.setEstado(Estado.valueOf(result.getString("estado")));	
					c.setEmail(result.getString("email"));
					c.setGenero(Genero.valueOf(result.getString("genero")));	
										
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
