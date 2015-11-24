package br.univel.Jasper;

import java.awt.Desktop;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import br.univel.Cliente.Cliente;
import br.univel.Conexao.Conexao;
import br.univel.Models.ModelCliente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperDesignViewer;
import net.sf.jasperreports.view.JasperViewer;

public class JasperReportCliente {

	Conexao con = new Conexao();

	private String arq = "C:\\Users\\luciano\\JaspersoftWorkspace\\MyReports\\Cliente.jasper";

	public JasperReportCliente() {
		
		
		JasperPrint jasperPrint = null;

		try {
			

			jasperPrint = JasperFillManager.fillReport(arq, null,con.getConnection());
			JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
			jasperViewer.setVisible(true);
			jasperViewer.setDefaultCloseOperation(jasperViewer.DISPOSE_ON_CLOSE);
			jasperViewer.setExtendedState(jasperViewer.MAXIMIZED_BOTH);
			
		} catch (JRException ex) {
			ex.printStackTrace();
		}
		
	
		new ModelCliente();
	}
	
	

}
