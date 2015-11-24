package br.univel.Jasper;

import java.util.HashMap;
import java.util.Map;

import br.univel.Cliente.Cliente;
import br.univel.Conexao.Conexao;
import br.univel.Models.ModelCliente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class JasperReportProduto {

	Conexao con = new Conexao();

	private String arq = "C:\\Users\\luciano\\JaspersoftWorkspace\\MyReports\\Produto.jasper";

	public JasperReportProduto() {
		JasperPrint jasperPrint = null;

		try {
			

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("Relatorio: ", Cliente.class.getName());
			

			jasperPrint = JasperFillManager.fillReport(arq, null,
					con.getConnection());
			JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
			jasperViewer.setDefaultCloseOperation(jasperViewer.DISPOSE_ON_CLOSE);
			jasperViewer.setExtendedState(jasperViewer.MAXIMIZED_BOTH);
			jasperViewer.setVisible(true);
		} catch (JRException ex) {
			ex.printStackTrace();
		}
		
		new ModelCliente();
	}
	
	

}
