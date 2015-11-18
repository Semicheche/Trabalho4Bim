package br.univel.Vendas;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.CompoundBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.Font;
import java.net.PasswordAuthentication;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import org.jfree.chart.renderer.xy.ClusteredXYBarRenderer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Luciano Semicheche - 02/11/2015 21:28:48
 *
 */

public class PainelLogin extends JPanel {
	private JTextField txtlogin;
	private JButton btnentrar;
	private JPasswordField passwordField;
	private String senhaBD;
	UsuarioDaoImpl u = new UsuarioDaoImpl();

	ArrayList<Usuario> usuario = (ArrayList<Usuario>) u.listar();

	/**
	 * Create the panel.
	 */
	public PainelLogin() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Entre com seu usuario");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 11;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 3;
		gbc_separator.gridy = 2;
		add(separator, gbc_separator);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.anchor = GridBagConstraints.EAST;
		gbc_lblLogin.gridx = 2;
		gbc_lblLogin.gridy = 3;
		add(lblLogin, gbc_lblLogin);

		txtlogin = new JTextField();
		GridBagConstraints gbc_txtlogin = new GridBagConstraints();
		gbc_txtlogin.anchor = GridBagConstraints.WEST;
		gbc_txtlogin.insets = new Insets(0, 0, 5, 5);
		gbc_txtlogin.gridx = 3;
		gbc_txtlogin.gridy = 3;
		add(txtlogin, gbc_txtlogin);
		txtlogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 2;
		gbc_lblSenha.gridy = 4;
		add(lblSenha, gbc_lblSenha);

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 4;
		add(passwordField, gbc_passwordField);

		btnentrar = new JButton("Entrar");
		btnentrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnentrar = new GridBagConstraints();
		gbc_btnentrar.anchor = GridBagConstraints.WEST;
		gbc_btnentrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnentrar.gridwidth = 4;
		gbc_btnentrar.gridx = 3;
		gbc_btnentrar.gridy = 5;
		add(btnentrar, gbc_btnentrar);

	}

	public PainelLogin(Runnable acaoOk) {
		this();
		ClienteDaoImpl cdao = new ClienteDaoImpl();
		UsuarioDaoImpl udao = new UsuarioDaoImpl();
		Cliente c = new Cliente();
		Usuario u = new Usuario();

		btnentrar.addActionListener(e -> {
			synchronized (cdao) {
			}
			for (int i = 0; i < cdao.listar().size(); i++) {
				if (txtlogin.getText().trim()
						.equals(cdao.listar().get(i).getNome()))
					c.setNome(cdao.listar().get(i).getNome());
			}

			for (int i = 0; i < udao.listar().size(); i++) {
				if (new String(passwordField.getPassword()).equals(udao
						.listar().get(i).getSenha())) {
					u.setSenha(udao.listar().get(i).getSenha());
				}
			}

			boolean login = false;

			if (txtlogin.getText().trim().equals(c.getNome())
					&& new String(passwordField.getPassword()).equals(u
							.getSenha())) {
				acaoOk.run();
				login = false;
			} else {
				login = true;
			}

			if (login)
				JOptionPane.showMessageDialog(PainelLogin.this,
						"Usuário e/ou senha inválidos!");

		});

	}

}
