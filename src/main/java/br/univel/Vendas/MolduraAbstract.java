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
import javax.xml.ws.Action;
import java.awt.Color;
import java.awt.Font;

public abstract class MolduraAbstract extends JPanel {
	private JPanel panel;
	private JButton btnfechar;

	
	/**
	 * @author Luciano Semicheche - 29/10/2015 19:24:34
	 * Create the panel.
	 */
	protected abstract void configuraConteudo();
	
	public void setCloseAction(ActionListener action){
		btnfechar.addActionListener(action);
	}
	
	public MolduraAbstract() {
		setForeground(new Color(0, 0, 0));
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setName("");
		panel.setMinimumSize(new Dimension(10, 100));
		panel.setBackground(SystemColor.inactiveCaption);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panel, BorderLayout.NORTH);
		
		btnfechar = new JButton("X");
		btnfechar.setFont(new Font("Square721 BT", Font.BOLD, 11));
		btnfechar.setBackground(Color.WHITE);
		panel.add(btnfechar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setMinimumSize(new Dimension(10, 100));
		panel_1.setBackground(SystemColor.inactiveCaption);
		add(panel_1, BorderLayout.SOUTH);
		
		configuraConteudo();
		
		
	}

}
