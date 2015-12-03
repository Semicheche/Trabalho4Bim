package br.univel.Jasper;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import br.univel.Cliente.Cliente;
import br.univel.Conexao.Conexao;
import br.univel.Models.ModelCliente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class JasperReportProduto {

	Conexao con = new Conexao();
	
	private static final String OUT_PDF = "Produto.pdf";

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
			
			 int valor =	JOptionPane.showConfirmDialog(null, "DESEJA SALVAR O RELATORIO PARA PDF!\n A aplicação vai para abrir com o visualizador"	+ " padrão.", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION);
				
				if(JOptionPane.YES_OPTION == valor){
						JasperExportManager.exportReportToPdfFile(jasperPrint, OUT_PDF);
						Desktop.getDesktop().open(new File(OUT_PDF));
					}
					
			
		} catch (JRException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new ModelCliente();
	}
	
	

}
