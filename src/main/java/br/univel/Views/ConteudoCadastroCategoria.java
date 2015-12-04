package br.univel.Views;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.univel.Categoria.Categoria;
import br.univel.Categoria.CategoriaDaoImp;
import br.univel.Models.ModelCategoria;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class ConteudoCadastroCategoria extends JPanel {
	private JTextField txtcategoria;
	private JTable table;
	
	ModelCategoria model = new ModelCategoria();

	/**
	 * Create the panel.
	 */
	public ConteudoCadastroCategoria() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.setIcon(new ImageIcon(ConteudoCadastroCategoria.class.getResource("/icon/Delete.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirCategoria();
			}
		});
		panel.add(btnNewButton);
		
		JButton btncancelar = new JButton("Cancelar");
		btncancelar.setIcon(new ImageIcon(ConteudoCadastroCategoria.class.getResource("/icon/close.png")));
		btncancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtcategoria.setText("");
			}
		});
		panel.add(btncancelar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(ConteudoCadastroCategoria.class.getResource("/icon/Save.png")));
		panel.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblCadastro = new JLabel("Categoria");
		GridBagConstraints gbc_lblCadastro = new GridBagConstraints();
		gbc_lblCadastro.insets = new Insets(0, 0, 5, 5);
		gbc_lblCadastro.anchor = GridBagConstraints.EAST;
		gbc_lblCadastro.gridx = 0;
		gbc_lblCadastro.gridy = 1;
		panel_1.add(lblCadastro, gbc_lblCadastro);
		
		txtcategoria = new JTextField();
		GridBagConstraints gbc_txtcategoria = new GridBagConstraints();
		gbc_txtcategoria.insets = new Insets(0, 0, 5, 0);
		gbc_txtcategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcategoria.gridx = 1;
		gbc_txtcategoria.gridy = 1;
		panel_1.add(txtcategoria, gbc_txtcategoria);
		txtcategoria.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editar();
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(model);
		model.fireTableDataChanged();

	}

	protected void excluirCategoria() {
		CategoriaDaoImp cdao = new CategoriaDaoImp();
		Categoria c = new Categoria();
		c.setId(cdao.listar().get(table.getSelectedRow()).getId());
		model.fireTableDataChanged();
		txtcategoria.setText("");
	}

	protected void editar() {
		
		txtcategoria.setText(model.lista.get(table.getSelectedRow()).getCategoria());
		
	}

	protected void cadastrar() {
		
		CategoriaDaoImp cdao = new CategoriaDaoImp();
		Categoria c = new Categoria();
		
		c.setCategoria(txtcategoria.getText());
		
		cdao.inserir(c);
		txtcategoria.setText("");
	}

}
