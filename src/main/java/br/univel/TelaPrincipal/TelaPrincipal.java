package br.univel.TelaPrincipal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTabbedPane;

import br.univel.Vendas.BlockPanel;
import br.univel.Vendas.PainelLogin;
import br.univel.Vendas.TelaCadastroCategoria;
import br.univel.Vendas.TelaCadastroCliente;
import br.univel.Vendas.TelaCadastroProduto;
import br.univel.Vendas.TelaCadastroVenda;

public class TelaPrincipal extends JFrame {

	/**
	 * @author Luciano Semicheche - 02/11/2015 21:29:00
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private BlockPanel glass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {

		blockParaLogin();

		setTitle("Menu Principal\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 498);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Cadastro");
		menuBar.add(mnNewMenu);

		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaProduto();
			}
		});
		mnNewMenu.add(mntmProduto);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCliente();
			}
		});
		mnNewMenu.add(mntmCliente);
		
		JMenuItem mntmBloquear = new JMenuItem("Bloquear");
		mntmBloquear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				block();
			}
		});
		
		JMenuItem mntmCategoria = new JMenuItem("Categoria");
		mntmCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelacategoria();
			}
		});
		mnNewMenu.add(mntmCategoria);
		mnNewMenu.add(mntmBloquear);
		
		JMenu mnVenda = new JMenu("Venda");
		menuBar.add(mnVenda);
		
		JMenuItem mntmVendaCliente = new JMenuItem("Venda Cliente");
		mntmVendaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaVenda();
				
			}

			
		});
		mnVenda.add(mntmVendaCliente);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}
	
	private void abrirTelaVenda() {
		TelaCadastroVenda telacadastrovenda = new TelaCadastroVenda();
		telacadastrovenda.setCloseAction(e -> tabbedPane.remove(telacadastrovenda));
		tabbedPane.addTab("Vanda", telacadastrovenda);
	}

	protected void abrirTelacategoria() {
		TelaCadastroCategoria telacadastrocategoria = new TelaCadastroCategoria();
			telacadastrocategoria.setCloseAction(e -> tabbedPane.remove(telacadastrocategoria));
			tabbedPane.addTab("Categoria", telacadastrocategoria);
	}

	private void blockParaLogin() {
		Runnable acaoOk = () -> {
			glass.setVisible(false);
			glass = new BlockPanel();
		};

		// ---- USAR A INDICAÇÃO DE PROGRESSO.
		// JXBusyLabel busy = new JXBusyLabel();
		// busy.setBusy(true);
		// glass = new BlockPanel(busy);
		// -----------------------------------

		// ---- USAR O PAINEL DE LOGIN.
		PainelLogin painelLogin = new PainelLogin(acaoOk);
		glass = new BlockPanel(painelLogin);
		// -----------------------------------

		setGlassPane(glass);

		glass.setVisible(true);
	}

	protected void block() {
		
		setGlassPane(glass);
		glass.setVisible(true);

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				glass.setVisible(false);
			}
		}).start();
	}

	protected void abrirTelaCliente() {
		TelaCadastroCliente telacadastrocliente = new TelaCadastroCliente();

		telacadastrocliente.setCloseAction(e -> tabbedPane
				.remove(telacadastrocliente));
		tabbedPane.addTab("Cliente", telacadastrocliente);

	}

	protected void abrirTelaProduto() {

		TelaCadastroProduto telacadastroproduto = new TelaCadastroProduto();

		telacadastroproduto.setCloseAction(e -> tabbedPane
				.remove(telacadastroproduto));
		tabbedPane.addTab("Produto", telacadastroproduto);
	}

}
