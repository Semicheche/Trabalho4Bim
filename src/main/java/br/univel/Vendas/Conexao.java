package br.univel.Vendas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
