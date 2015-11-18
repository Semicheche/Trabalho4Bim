package br.univel.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Luciano Semicheche - 02/11/2015 21:28:25
 *
 */
public class Conexao {
	
	private Connection con;
	
	public Connection getConnection(){
		
		if(con == null)
			try {
				abrirConexao();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return con;
		
	}
	
	private void abrirConexao() throws SQLException {
		String url = "jdbc:postgresql://127.0.0.1:5432/trabalho4bimjava";
		String user = "postgres";
		String pass = "postgres";
		con = DriverManager.getConnection(url, user, pass);
	}

}
