package br.univel.Views;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.BorderLayout;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.security.MessageDigest;
import java.util.ArrayList;

import javax.swing.JButton;

import br.univel.Cliente.Cliente;
import br.univel.Cliente.ClienteDaoImpl;
import br.univel.Enum.Estado;
import br.univel.Enum.Genero;
import br.univel.Models.ModelCliente;
import br.univel.Usuario.Usuario;
import br.univel.Usuario.UsuarioDaoImpl;

public class ConteudoCadastroCliente extends JPanel {

	ModelCliente model = new ModelCliente() {
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
	private JButton btncadastrar;
	private JButton btncancelar;
	private JLabel lblEmail;
	private JTextField txtemail;
	private char[] senha;
	private JButton btnExcluir;

	/**
	 * @author Luciano Semicheche - 02/11/2015 21:26:55 Create the panel.
	 */

	public ConteudoCadastroCliente() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 6;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		panel.add(btnExcluir);

		btncancelar = new JButton("Cancelar");
		btncancelar.setEnabled(false);
		btncancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		panel.add(btncancelar);

		btncadastrar = new JButton("Salvar");
		btncadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		panel.add(btncadastrar);

		lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.WEST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);

		txtid = new JTextField();
		txtid.setEnabled(false);
		txtid.setEditable(false);
		GridBagConstraints gbc_txtid = new GridBagConstraints();
		gbc_txtid.gridwidth = 2;
		gbc_txtid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtid.insets = new Insets(0, 0, 5, 5);
		gbc_txtid.gridx = 1;
		gbc_txtid.gridy = 1;
		add(txtid, gbc_txtid);
		txtid.setColumns(10);

		lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 2;
		add(lblNome, gbc_lblNome);

		txtnome = new JTextField();
		GridBagConstraints gbc_txtnome = new GridBagConstraints();
		gbc_txtnome.gridwidth = 5;
		gbc_txtnome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnome.insets = new Insets(0, 0, 5, 0);
		gbc_txtnome.gridx = 1;
		gbc_txtnome.gridy = 2;
		add(txtnome, gbc_txtnome);
		txtnome.setColumns(10);

		lblEndereo = new JLabel("Endere\u00E7o");
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.anchor = GridBagConstraints.EAST;
		gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereo.gridx = 0;
		gbc_lblEndereo.gridy = 3;
		add(lblEndereo, gbc_lblEndereo);

		txtendereco = new JTextField();
		GridBagConstraints gbc_txtendereco = new GridBagConstraints();
		gbc_txtendereco.gridwidth = 5;
		gbc_txtendereco.anchor = GridBagConstraints.NORTH;
		gbc_txtendereco.insets = new Insets(0, 0, 5, 0);
		gbc_txtendereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtendereco.gridx = 1;
		gbc_txtendereco.gridy = 3;
		add(txtendereco, gbc_txtendereco);
		txtendereco.setColumns(10);

		lblTlefone = new JLabel("Telefone");
		GridBagConstraints gbc_lblTlefone = new GridBagConstraints();
		gbc_lblTlefone.anchor = GridBagConstraints.WEST;
		gbc_lblTlefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTlefone.gridx = 0;
		gbc_lblTlefone.gridy = 4;
		add(lblTlefone, gbc_lblTlefone);

		txttelefone = new JTextField();
		GridBagConstraints gbc_txttelefone = new GridBagConstraints();
		gbc_txttelefone.gridwidth = 5;
		gbc_txttelefone.insets = new Insets(0, 0, 5, 0);
		gbc_txttelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txttelefone.gridx = 1;
		gbc_txttelefone.gridy = 4;
		add(txttelefone, gbc_txttelefone);
		txttelefone.setColumns(10);

		lblCidade = new JLabel("Cidade");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 5;
		add(lblCidade, gbc_lblCidade);

		txtcidade = new JTextField();
		GridBagConstraints gbc_txtcidade = new GridBagConstraints();
		gbc_txtcidade.gridwidth = 5;
		gbc_txtcidade.insets = new Insets(0, 0, 5, 0);
		gbc_txtcidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcidade.gridx = 1;
		gbc_txtcidade.gridy = 5;
		add(txtcidade, gbc_txtcidade);
		txtcidade.setColumns(10);

		lblGenero = new JLabel("Genero");
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.anchor = GridBagConstraints.EAST;
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.gridx = 0;
		gbc_lblGenero.gridy = 6;
		add(lblGenero, gbc_lblGenero);

		comboBoxgenero = new JComboBox(Genero.values());
		comboBoxgenero.setSelectedIndex(-1);
		GridBagConstraints gbc_comboBoxgenero = new GridBagConstraints();
		gbc_comboBoxgenero.gridwidth = 2;
		gbc_comboBoxgenero.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxgenero.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxgenero.gridx = 1;
		gbc_comboBoxgenero.gridy = 6;
		add(comboBoxgenero, gbc_comboBoxgenero);

		lblUf = new JLabel("UF");
		GridBagConstraints gbc_lblUf = new GridBagConstraints();
		gbc_lblUf.anchor = GridBagConstraints.EAST;
		gbc_lblUf.insets = new Insets(0, 0, 5, 5);
		gbc_lblUf.gridx = 0;
		gbc_lblUf.gridy = 7;
		add(lblUf, gbc_lblUf);

		comboBoxuf = new JComboBox(Estado.values());
		comboBoxuf.setSelectedIndex(-1);
		GridBagConstraints gbc_comboBoxuf = new GridBagConstraints();
		gbc_comboBoxuf.gridwidth = 2;
		gbc_comboBoxuf.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxuf.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxuf.gridx = 1;
		gbc_comboBoxuf.gridy = 7;
		add(comboBoxuf, gbc_comboBoxuf);

		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 8;
		add(lblEmail, gbc_lblEmail);

		txtemail = new JTextField();
		GridBagConstraints gbc_txtemail = new GridBagConstraints();
		gbc_txtemail.gridwidth = 5;
		gbc_txtemail.insets = new Insets(0, 0, 5, 0);
		gbc_txtemail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtemail.gridx = 1;
		gbc_txtemail.gridy = 8;
		add(txtemail, gbc_txtemail);
		txtemail.setColumns(10);

		lblSenha = new JLabel("Senha");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 9;
		add(lblSenha, gbc_lblSenha);

		chckbxClienteEUsuario = new JCheckBox("Usuario");
		chckbxClienteEUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ativaUsuario();
			}
		});

		passUsuario = new JPasswordField();
		passUsuario.setEnabled(false);
		passUsuario.setEditable(false);
		GridBagConstraints gbc_passUsuario = new GridBagConstraints();
		gbc_passUsuario.gridwidth = 4;
		gbc_passUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_passUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_passUsuario.gridx = 1;
		gbc_passUsuario.gridy = 9;
		add(passUsuario, gbc_passUsuario);
		GridBagConstraints gbc_chckbxClienteEUsuario = new GridBagConstraints();
		gbc_chckbxClienteEUsuario.anchor = GridBagConstraints.WEST;
		gbc_chckbxClienteEUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxClienteEUsuario.gridx = 5;
		gbc_chckbxClienteEUsuario.gridy = 9;
		add(chckbxClienteEUsuario, gbc_chckbxClienteEUsuario);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 12;
		add(scrollPane, gbc_scrollPane);

		tablecliente = new JTable(model);
		tablecliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ativabotao();
			}
		});
		scrollPane.setViewportView(tablecliente);
		model.fireTableDataChanged();

	}

	protected void ativabotao() {
		btncancelar.setEnabled(true);
		btnExcluir.setEnabled(true);
		Editar();
	}

	protected void excluir() {
		
		UsuarioDaoImpl udao = new UsuarioDaoImpl();
		for (int i = 0; i < udao.listar().size(); i++) {
			int id_cliente = udao.listar().get(i).getId_cliente();

			if (id_cliente != Integer.valueOf(txtid.getText())) {
				Cliente c = new Cliente();
				ClienteDaoImpl cdao = new ClienteDaoImpl();

				c.setId(Integer.valueOf(txtid.getText()));
				cdao.excluir(c);

				model.fireTableDataChanged();
			
			}else{
				int opcao = JOptionPane.showConfirmDialog(null, "O Cliente nao pode ser excluido por que ele e um Usuario \n DESEJA REALMENTE EXLCUIR CLIENTE E USUARIO? ", "ATENÇÂO", JOptionPane.YES_NO_CANCEL_OPTION);
				
				if (opcao == JOptionPane.YES_OPTION) {
					
					Usuario u = new Usuario();
					u.setId(id_cliente);
					udao.excluir(u);
					
					
					Cliente c = new Cliente();
					ClienteDaoImpl cdao = new ClienteDaoImpl();

					c.setId(Integer.valueOf(txtid.getText()));
					cdao.excluir(c);

					model.fireTableDataChanged();
				}else{
					
				}
				
				
			}

		}
		desabilitaBotao();
	}

	protected void salvar() {
		Cliente c = new Cliente();
		ClienteDaoImpl cdao = new ClienteDaoImpl();

		if (!cdao.listar().isEmpty())
			txtid.setText(String.valueOf(cdao.listar().get(0).getId()));
		
		c.setId(Integer.valueOf(txtid.getText()));
		c.setNome(txtnome.getText());
		c.setTelefone(txttelefone.getText());
		c.setEndereco(txtendereco.getText());
		c.setCidade(txtcidade.getText());
		c.setEstado((Estado) comboBoxuf.getSelectedItem());
		c.setEmail(txtemail.getText());
		c.setGenero((Genero) comboBoxgenero.getSelectedItem());
		
		model.fireTableDataChanged();
		
		
		if(c.getId() == 0){
			cdao.inserir(c);
		}else{
			cdao.atualizar(c);

			desabilitaBotao();

			if (chckbxClienteEUsuario.isSelected()) {
				Usuario usuario = new Usuario();
				UsuarioDaoImpl udao = new UsuarioDaoImpl();
				

				usuario.setSenha(new String(passUsuario.getPassword()));
				usuario.setId_cliente(Integer.valueOf(txtid.getText()));
				udao.inserir(usuario);
			}
			
		}
		cancelar();

	}

	private void cancelar() {
		txtid.setText("");
		txtnome.setText("");
		txtendereco.setText("");
		txtcidade.setText("");
		txtemail.setText("");
		txttelefone.setText("");
		comboBoxgenero.setSelectedIndex(-1);
		comboBoxuf.setSelectedIndex(-1);
		btncadastrar.setEnabled(true);
		desabilitaBotao();
		

	}

	private void desabilitaBotao() {
		btncancelar.setEnabled(false);
		btnExcluir.setEnabled(false);
		
	}

	protected void ativaUsuario() {

		if (chckbxClienteEUsuario.isSelected()) {
			passUsuario.setEditable(true);
			passUsuario.setEnabled(true);
		} else {
			passUsuario.setEditable(false);
			passUsuario.setEnabled(false);
		}

	}

	protected void Editar() {

		ClienteDaoImpl cdao = new ClienteDaoImpl();
		int linha = tablecliente.getSelectedRow();

		ArrayList<Cliente> lista = (ArrayList<Cliente>) cdao.listar();

		txtid.setText(String.valueOf(lista.get(linha).getId()));
		txtnome.setText(lista.get(linha).getNome());
		txttelefone.setText(lista.get(linha).getTelefone());
		txtendereco.setText(lista.get(linha).getEndereco());
		txtcidade.setText(lista.get(linha).getCidade());
		comboBoxuf.setSelectedItem(lista.get(linha).getEstado());
		txtemail.setText(lista.get(linha).getEmail());
		comboBoxgenero.setSelectedItem(lista.get(linha).getGenero());

	}

}
