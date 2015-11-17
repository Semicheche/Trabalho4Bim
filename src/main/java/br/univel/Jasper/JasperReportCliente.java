package br.univel.Jasper;

import java.util.HashMap;
import java.util.Map;

import br.univel.Vendas.Cliente;
import br.univel.Vendas.Conexao;
import br.univel.Vendas.ModelCliente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class JasperReportCliente {

	Conexao con = new Conexao();

	private String arq = "C:\\Users\\luciano\\JaspersoftWorkspace\\MyReports\\Cliente.jasper";

	public JasperReportCliente() {
		JasperPrint jasperPrint = null;

		try {
			

			jasperPrint = JasperFillManager.fillReport(arq, null,
					con.getConnection());
			JasperViewer jasperViewer = new JasperViewer(jasperPrint);
			jasperViewer.setVisible(true);
		} catch (JRException ex) {
			ex.printStackTrace();
		}
		
		new ModelCliente();
	}
	
	

}
