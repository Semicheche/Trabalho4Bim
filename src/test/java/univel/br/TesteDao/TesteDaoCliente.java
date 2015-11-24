package univel.br.TesteDao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.univel.Cliente.Cliente;
import br.univel.Cliente.ClienteDaoImpl;
import br.univel.Conexao.Conexao;

public class TesteDaoCliente extends Cliente {
	private static Conexao con;
	private static ClienteDaoImpl cdao;
	PreparedStatement ps;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		con = new Conexao();
		cdao = new ClienteDaoImpl();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInserir() {

		String sql = "INSERT INTO CLIENTE ( NOME, FONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			
			ps = con.getConnection().prepareStatement(sql);

			assertNotNull(ps.executeUpdate());
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}

	@Ignore
	@Test
	public void testAtualizar() {
		fail("Not yet implemented");
	}

	@Test
	public void testExcluir() {
		
		String sql = "DELETE FROM CLIENTE WHERE IDCLIENTE = ?";
		
		try {
			
			ps = con.getConnection().prepareStatement(sql);
			
			assertNotNull(ps.executeUpdate());
			
		} catch (SQLException e) {

			e.printStackTrace();
		
		}
		
	}

	@Test
	public void testListar() {
		assertNotNull(cdao.listar());
	}

}
