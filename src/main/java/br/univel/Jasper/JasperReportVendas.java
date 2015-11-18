package br.univel.Jasper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import br.univel.Conexao.Conexao;
import br.univel.Models.ModelCliente;

public class JasperReportVendas {
	
	Conexao con = new Conexao();

	private String arq = "C:\\Users\\luciano\\JaspersoftWorkspace\\MyReports\\Venda.jasper";

	public JasperReportVendas() {
		JasperPrint jasperPrint = null;

		try {
			

			jasperPrint = JasperFillManager.fillReport(arq, null,
					con.getConnection());
			JasperViewer jasperViewer = new JasperViewer(jasperPrint, false	);
			jasperViewer.setDefaultCloseOperation(jasperViewer.DISPOSE_ON_CLOSE);
			jasperViewer.setVisible(true);
		} catch (JRException ex) {
			ex.printStackTrace();
		}
		
		new ModelCliente();
	}
}
