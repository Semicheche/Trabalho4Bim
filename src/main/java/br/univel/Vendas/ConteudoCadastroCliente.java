package br.univel.Vendas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConteudoCadastroCliente extends JPanel {
	
	ModelCliente model = new ModelCliente(){
	};
	private JLabel lblId;
	private JLabel lblNome;
	private JLabel lblTlefone;
	private JLabel lblEndereo;
	private JLabel lblCidade;
	private JLabel lblUf;
	private JLabel lblGenero;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBox_1;
	private JTextField textField_4;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private JTable tablecliente;
	private JPasswordField passUsuario;
	private JLabel lblSenha;
	private JCheckBox chckbxClienteEUsuario;
	
	

	/**
	 * 
	 *Create the panel.
	 */
	
	public ConteudoCadastroCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		chckbxClienteEUsuario = new JCheckBox("Cliente e Usuario");
		chckbxClienteEUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ativaUsuario();
			}
		});
		GridBagConstraints gbc_chckbxClienteEUsuario = new GridBagConstraints();
		gbc_chckbxClienteEUsuario.anchor = GridBagConstraints.EAST;
		gbc_chckbxClienteEUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxClienteEUsuario.gridx = 3;
		gbc_chckbxClienteEUsuario.gridy = 0;
		add(chckbxClienteEUsuario, gbc_chckbxClienteEUsuario);
		
		lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.WEST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 2;
		gbc_lblNome.gridy = 1;
		add(lblNome, gbc_lblNome);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 1;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblTlefone = new JLabel("Telefone");
		GridBagConstraints gbc_lblTlefone = new GridBagConstraints();
		gbc_lblTlefone.anchor = GridBagConstraints.WEST;
		gbc_lblTlefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTlefone.gridx = 0;
		gbc_lblTlefone.gridy = 2;
		add(lblTlefone, gbc_lblTlefone);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		lblEndereo = new JLabel("Endere\u00E7o");
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.anchor = GridBagConstraints.EAST;
		gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereo.gridx = 2;
		gbc_lblEndereo.gridy = 2;
		add(lblEndereo, gbc_lblEndereo);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 2;
		add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		lblCidade = new JLabel("Cidade");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.WEST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 3;
		add(lblCidade, gbc_lblCidade);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 3;
		add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		lblGenero = new JLabel("Genero");
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.anchor = GridBagConstraints.EAST;
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.gridx = 2;
		gbc_lblGenero.gridy = 3;
		add(lblGenero, gbc_lblGenero);
		
		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 3;
		add(comboBox, gbc_comboBox);
		
		lblUf = new JLabel("UF");
		GridBagConstraints gbc_lblUf = new GridBagConstraints();
		gbc_lblUf.anchor = GridBagConstraints.EAST;
		gbc_lblUf.insets = new Insets(0, 0, 5, 5);
		gbc_lblUf.gridx = 0;
		gbc_lblUf.gridy = 4;
		add(lblUf, gbc_lblUf);
		
		comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 4;
		add(comboBox_1, gbc_comboBox_1);
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Editar();
				
			}
		});
		
		lblSenha = new JLabel("Senha");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.gridx = 2;
		gbc_lblSenha.gridy = 4;
		add(lblSenha, gbc_lblSenha);
		
		passUsuario = new JPasswordField();
		passUsuario.setEnabled(false);
		passUsuario.setEditable(false);
		GridBagConstraints gbc_passUsuario = new GridBagConstraints();
		gbc_passUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_passUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_passUsuario.gridx = 3;
		gbc_passUsuario.gridy = 4;
		add(passUsuario, gbc_passUsuario);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 5;
		add(scrollPane, gbc_scrollPane);
		
		tablecliente = new JTable(model);
		scrollPane.setViewportView(tablecliente);
		
		
		
		}

	protected void ativaUsuario() {
		if(chckbxClienteEUsuario.isSelected()){
			passUsuario.setEditable(true);
			passUsuario.setEnabled(true);
		}else{
			passUsuario.setEditable(false);
			passUsuario.setEnabled(false);
		}
		
	}

	protected void Editar() {
		
		
	}

}
