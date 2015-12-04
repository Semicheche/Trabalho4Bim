package br.univel.TelaPrincipal;

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


import br.univel.Cliente.Cliente;
import br.univel.Cliente.ClienteDaoImpl;
import br.univel.Usuario.Usuario;
import br.univel.Usuario.UsuarioDaoImpl;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;

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
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 1;
		gbc_separator_1.gridy = 2;
		add(separator_1, gbc_separator_1);
				
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(PainelLogin.class.getResource("/icon/keys-icon.png")));
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 3;
				gbc_label.gridy = 3;
				add(label, gbc_label);
		
				JLabel lblNewLabel = new JLabel("Usuario e Senha");
				lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
				lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.gridwidth = 2;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 4;
				gbc_lblNewLabel.gridy = 3;
				add(lblNewLabel, gbc_lblNewLabel);
		
		JSeparator separator_2 = new JSeparator();
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.insets = new Insets(0, 0, 5, 0);
		gbc_separator_2.gridx = 7;
		gbc_separator_2.gridy = 3;
		add(separator_2, gbc_separator_2);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 5;
		gbc_separator.gridy = 4;
		add(separator, gbc_separator);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.anchor = GridBagConstraints.EAST;
		gbc_lblLogin.gridx = 3;
		gbc_lblLogin.gridy = 5;
		add(lblLogin, gbc_lblLogin);

		txtlogin = new JTextField();
		GridBagConstraints gbc_txtlogin = new GridBagConstraints();
		gbc_txtlogin.gridwidth = 2;
		gbc_txtlogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtlogin.insets = new Insets(0, 0, 5, 5);
		gbc_txtlogin.gridx = 4;
		gbc_txtlogin.gridy = 5;
		add(txtlogin, gbc_txtlogin);
		txtlogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 3;
		gbc_lblSenha.gridy = 6;
		add(lblSenha, gbc_lblSenha);

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 4;
		gbc_passwordField.gridy = 6;
		add(passwordField, gbc_passwordField);

		btnentrar = new JButton("Entrar");
		btnentrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnentrar = new GridBagConstraints();
		gbc_btnentrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnentrar.gridwidth = 3;
		gbc_btnentrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnentrar.gridx = 3;
		gbc_btnentrar.gridy = 7;
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
				boolean login = false;
		
			
			//////////////////////////////////
			//busca no banco tabela Cliente
			//////////////////////////////////
			for (int i = 0; i < cdao.listar().size(); i++) {
				if (txtlogin.getText().trim()
						.equals(cdao.listar().get(i).getNome()))
					c.setNome(cdao.listar().get(i).getNome());
			}
			
			////////////////////////////////////////
			//busca no banco as senhas dos usuarios
			/////////////////////////////////////////
			for (int i = 0; i < udao.listar().size(); i++) {
				if (new String(passwordField.getPassword()).equals(udao
						.listar().get(i).getSenha())) {
					u.setSenha(udao.listar().get(i).getSenha());
				}
			}

			/////////////////////////////////////
			// faz a verificação do usuario
			////////////////////////////////////
			if (txtlogin.getText().trim().equals(c.getNome())
					&& new String(passwordField.getPassword()).equals(u
							.getSenha())) {
				acaoOk.run();
				login = false;
			} else {
				login = true;
			}
			
			/////////////////////////
			//	login administrador
			//////////////////////////
			if(txtlogin.getText().trim().equals("admin") && new String(passwordField.getPassword()).equals("admin")){
				acaoOk.run();
				login = false;
			}else{
			if (login)
				JOptionPane.showMessageDialog(PainelLogin.this,
						"Usuário e/ou senha inválidos!\n Verifique e tente novamente");
			}
			}

		});

	}

}
