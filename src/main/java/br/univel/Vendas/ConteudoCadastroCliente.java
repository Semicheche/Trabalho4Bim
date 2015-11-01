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
import java.awt.FlowLayout;
import javax.swing.JButton;

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
	private JTextField txtid;
	private JTextField txtnome;
	private JTextField txttelefone;
	private JTextField txtendereco;
	private JComboBox comboBoxuf;
	private JTextField txtcidade;
	private JComboBox comboBoxgenero;
	private JScrollPane scrollPane;
	private JTable tablecliente;
	private JPasswordField passUsuario;
	private JLabel lblSenha;
	private JCheckBox chckbxClienteEUsuario;
	private JPanel panel;
	private JButton btnsalvar;
	private JButton btncancelar;
	private JButton btneditar;
	private JLabel lblEmail;
	private JTextField txtemail;
	
	
	

	/**
	 * 
	 *Create the panel.
	 */
	
	public ConteudoCadastroCliente() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		chckbxClienteEUsuario = new JCheckBox("Cliente e Usuario");
		chckbxClienteEUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ativaUsuario();
			}
		});
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		btneditar = new JButton("Editar");
		panel.add(btneditar);
		
		btncancelar = new JButton("Cancelar");
		btncancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		panel.add(btncancelar);
		
		btnsalvar = new JButton("Salvar");
		btnsalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		panel.add(btnsalvar);
		GridBagConstraints gbc_chckbxClienteEUsuario = new GridBagConstraints();
		gbc_chckbxClienteEUsuario.anchor = GridBagConstraints.EAST;
		gbc_chckbxClienteEUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxClienteEUsuario.gridx = 3;
		gbc_chckbxClienteEUsuario.gridy = 1;
		add(chckbxClienteEUsuario, gbc_chckbxClienteEUsuario);
		
		lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.WEST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 2;
		add(lblId, gbc_lblId);
		
		txtid = new JTextField();
		txtid.setEnabled(false);
		txtid.setEditable(false);
		GridBagConstraints gbc_txtid = new GridBagConstraints();
		gbc_txtid.insets = new Insets(0, 0, 5, 5);
		gbc_txtid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtid.gridx = 1;
		gbc_txtid.gridy = 2;
		add(txtid, gbc_txtid);
		txtid.setColumns(10);
		
		lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 2;
		gbc_lblNome.gridy = 2;
		add(lblNome, gbc_lblNome);
		
		txtnome = new JTextField();
		GridBagConstraints gbc_txtnome = new GridBagConstraints();
		gbc_txtnome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnome.insets = new Insets(0, 0, 5, 0);
		gbc_txtnome.gridx = 3;
		gbc_txtnome.gridy = 2;
		add(txtnome, gbc_txtnome);
		txtnome.setColumns(10);
		
		lblTlefone = new JLabel("Telefone");
		GridBagConstraints gbc_lblTlefone = new GridBagConstraints();
		gbc_lblTlefone.anchor = GridBagConstraints.WEST;
		gbc_lblTlefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTlefone.gridx = 0;
		gbc_lblTlefone.gridy = 3;
		add(lblTlefone, gbc_lblTlefone);
		
		txttelefone = new JTextField();
		GridBagConstraints gbc_txttelefone = new GridBagConstraints();
		gbc_txttelefone.insets = new Insets(0, 0, 5, 5);
		gbc_txttelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txttelefone.gridx = 1;
		gbc_txttelefone.gridy = 3;
		add(txttelefone, gbc_txttelefone);
		txttelefone.setColumns(10);
		
		lblEndereo = new JLabel("Endere\u00E7o");
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.anchor = GridBagConstraints.EAST;
		gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereo.gridx = 2;
		gbc_lblEndereo.gridy = 3;
		add(lblEndereo, gbc_lblEndereo);
		
		txtendereco = new JTextField();
		GridBagConstraints gbc_txtendereco = new GridBagConstraints();
		gbc_txtendereco.anchor = GridBagConstraints.NORTH;
		gbc_txtendereco.insets = new Insets(0, 0, 5, 0);
		gbc_txtendereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtendereco.gridx = 3;
		gbc_txtendereco.gridy = 3;
		add(txtendereco, gbc_txtendereco);
		txtendereco.setColumns(10);
		
		lblCidade = new JLabel("Cidade");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.WEST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 4;
		add(lblCidade, gbc_lblCidade);
		
		txtcidade = new JTextField();
		GridBagConstraints gbc_txtcidade = new GridBagConstraints();
		gbc_txtcidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtcidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcidade.gridx = 1;
		gbc_txtcidade.gridy = 4;
		add(txtcidade, gbc_txtcidade);
		txtcidade.setColumns(10);
		
		lblGenero = new JLabel("Genero");
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.anchor = GridBagConstraints.EAST;
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.gridx = 2;
		gbc_lblGenero.gridy = 4;
		add(lblGenero, gbc_lblGenero);
		
		comboBoxgenero = new JComboBox(Genero.values());
		GridBagConstraints gbc_comboBoxgenero = new GridBagConstraints();
		gbc_comboBoxgenero.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxgenero.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxgenero.gridx = 3;
		gbc_comboBoxgenero.gridy = 4;
		add(comboBoxgenero, gbc_comboBoxgenero);
		
		lblUf = new JLabel("UF");
		GridBagConstraints gbc_lblUf = new GridBagConstraints();
		gbc_lblUf.anchor = GridBagConstraints.EAST;
		gbc_lblUf.insets = new Insets(0, 0, 5, 5);
		gbc_lblUf.gridx = 0;
		gbc_lblUf.gridy = 5;
		add(lblUf, gbc_lblUf);
		
		comboBoxuf = new JComboBox(Estado.values());
		GridBagConstraints gbc_comboBoxuf = new GridBagConstraints();
		gbc_comboBoxuf.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxuf.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxuf.gridx = 1;
		gbc_comboBoxuf.gridy = 5;
		add(comboBoxuf, gbc_comboBoxuf);
		
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
		gbc_lblSenha.gridy = 5;
		add(lblSenha, gbc_lblSenha);
		
		passUsuario = new JPasswordField();
		passUsuario.setEnabled(false);
		passUsuario.setEditable(false);
		GridBagConstraints gbc_passUsuario = new GridBagConstraints();
		gbc_passUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_passUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_passUsuario.gridx = 3;
		gbc_passUsuario.gridy = 5;
		add(passUsuario, gbc_passUsuario);
		
		lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 6;
		add(lblEmail, gbc_lblEmail);
		
		txtemail = new JTextField();
		GridBagConstraints gbc_txtemail = new GridBagConstraints();
		gbc_txtemail.gridwidth = 2;
		gbc_txtemail.insets = new Insets(0, 0, 5, 5);
		gbc_txtemail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtemail.gridx = 1;
		gbc_txtemail.gridy = 6;
		add(txtemail, gbc_txtemail);
		txtemail.setColumns(10);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 8;
		add(scrollPane, gbc_scrollPane);
		
		tablecliente = new JTable(model);
		scrollPane.setViewportView(tablecliente);
		
		
		
		}

	protected void salvar() {
		Cliente c = new Cliente();
		ClienteDaoImpl dao = new ClienteDaoImpl();
		
		//txtid.setText(String.valueOf(dao.listar().get(0).getId()));
		c.setNome(txtnome.getText());
		c.setEndereco(txtendereco.getText());
		c.setCidade(txtcidade.getText());
		c.setTelefone(txttelefone.getText());
		c.setEmail(txtemail.getText());
		c.setEstado((Estado) comboBoxuf.getSelectedItem());
		c.setGenero((Genero) comboBoxgenero.getSelectedItem());
		
		dao.inserir(c);
		
		cancelar();
		
	}

	private void cancelar() {
		txtid.setText("");
		txtnome.setText("");
		txtendereco.setText("");
		txtcidade.setText("");
		txtemail.setText("");
		txttelefone.setText("");
		
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
