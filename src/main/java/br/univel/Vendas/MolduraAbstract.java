package br.univel.Vendas;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public abstract class MolduraAbstract extends JPanel {
	private JPanel panel;
	private JButton btnfechar;

	/**
	 * Create the panel.
	 */
	protected abstract void configuraConteudo();
	
	public void setCloseAction(ActionListener action){
		btnfechar.addActionListener(action);
	}
	
	public MolduraAbstract() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setName("");
		panel.setMinimumSize(new Dimension(10, 100));
		panel.setBackground(SystemColor.inactiveCaption);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panel, BorderLayout.NORTH);
		
		btnfechar = new JButton("X");
		panel.add(btnfechar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setMinimumSize(new Dimension(10, 100));
		panel_1.setBackground(SystemColor.inactiveCaption);
		add(panel_1, BorderLayout.SOUTH);
		
		configuraConteudo();
		
		
	}

}
