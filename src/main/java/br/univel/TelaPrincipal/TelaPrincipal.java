package br.univel.TelaPrincipal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXBusyLabel;

import br.univel.Jasper.JasperReportCliente;
import br.univel.Jasper.JasperReportProduto;
import br.univel.Jasper.JasperReportVendas;
import br.univel.Views.TelaCadastroCategoria;
import br.univel.Views.TelaCadastroCliente;
import br.univel.Views.TelaCadastroProduto;
import br.univel.Views.TelaCadastroVenda;

public class TelaPrincipal extends JFrame {

	/**
	 * @author Luciano Semicheche - 02/11/2015 21:29:00
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private BlockPanel glass;
	private Carregar glasses;
	
	private Map<Integer, JComponent> mapa = new HashMap<Integer, JComponent>();

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
		setExtendedState(TelaPrincipal.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icon/add.png")));
		menuBar.add(mnNewMenu);

		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icon/1449205752_product.png")));
		mntmProduto.setHorizontalAlignment(SwingConstants.LEFT);
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaProduto();
			}
		});
		mnNewMenu.add(mntmProduto);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icon/1449205797_Add-Male-User.png")));
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCliente();					
			}
		});
		mnNewMenu.add(mntmCliente);

		JMenuItem mntmBloquear = new JMenuItem("Bloquear");
		mntmBloquear.setHorizontalAlignment(SwingConstants.LEFT);
		mntmBloquear.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icon/padlock.png")));
		mntmBloquear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blockLoad();
			}
		});

		JMenuItem mntmCategoria = new JMenuItem("Categoria");
		mntmCategoria.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icon/1449206103_category.png")));
		mntmCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelacategoria();
			}
		});
		mnNewMenu.add(mntmCategoria);
		mnNewMenu.add(mntmBloquear);

		JMenu mnVenda = new JMenu("");
		mnVenda.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icon/1449206519_Money.png")));
		menuBar.add(mnVenda);

		JMenuItem mntmVendaCliente = new JMenuItem("Venda Produto");
		mntmVendaCliente.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icon/cash-register.png")));
		mntmVendaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaVenda();

			}

		});
		mnVenda.add(mntmVendaCliente);

		JMenu mnRelatorios = new JMenu("");
		mnRelatorios.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icon/1449206648_product-sales-report.png")));
		menuBar.add(mnRelatorios);

		JMenuItem mntmCliente_1 = new JMenuItem("Clientes");
		mntmCliente_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icon/report user.png")));
		mntmCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JasperReportCliente();

			}
		});
		mnRelatorios.add(mntmCliente_1);

		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mntmProdutos.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icon/Product-report.png")));
		mntmProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JasperReportProduto();
			}
		});
		mnRelatorios.add(mntmProdutos);

		JMenuItem mntmVendas = new JMenuItem("Vendas");
		mntmVendas.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icon/sales-report.png")));
		mntmVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JasperReportVendas();
			}
		});
		mnRelatorios.add(mntmVendas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

	private void abrirTelaVenda() {
		TelaCadastroVenda telacadastrovenda = new TelaCadastroVenda();
		telacadastrovenda.setCloseAction(e -> tabbedPane
				.remove(telacadastrovenda));
		tabbedPane.addTab("Venda", telacadastrovenda);
		mostraUltima();
	}

	protected void abrirTelacategoria() {
		TelaCadastroCategoria telacadastrocategoria = new TelaCadastroCategoria();
		telacadastrocategoria.setCloseAction(e -> tabbedPane
				.remove(telacadastrocategoria));
		tabbedPane.addTab("Categoria", telacadastrocategoria);
		mostraUltima();
	}

	private void blockParaLogin() {
		Runnable acaoOk = () -> {
			glass.setVisible(false);
			glasses = new Carregar();
		};

		// ---- USAR A INDICA��O DE PROGRESSO.
//		 JXBusyLabel busy = new JXBusyLabel();
//		 busy.setBusy(true);
//		 glass = new Carregar(busy);
		// -----------------------------------

		// ---- USAR O PAINEL DE LOGIN.
		PainelLogin painelLogin = new PainelLogin(acaoOk);
		glass = new BlockPanel(painelLogin);
		// -----------------------------------

		setGlassPane(glass);

		glass.setVisible(true);
	}
		
	private void blockLoad() {
		
			Runnable acaoOk = () -> {
				glasses.setVisible(false);
				glasses = new Carregar();
			};

			// ---- USAR A INDICA��O DE PROGRESSO.
			 JXBusyLabel busy = new JXBusyLabel();
			 busy.setBusy(true);
			 glasses = new Carregar(busy);
			// -----------------------------------

			// ---- USAR O PAINEL DE LOGIN.
//			PainelLogin painelLogin = new PainelLogin(acaoOk);
//			glass = new BlockPanel(painelLogin);
			// -----------------------------------

			setGlassPane(glasses);

			glasses.setVisible(true);
			
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
					glasses.setVisible(false);
				}
			}).start();
		}

	
	

	public void block() {

		setGlassPane(glasses);
		glasses.setVisible(true);

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
				glasses.setVisible(false);
			}
		}).start();
	}

	protected void abrirTelaCliente() {
		TelaCadastroCliente telacadastrocliente = new TelaCadastroCliente();

		telacadastrocliente.setCloseAction(e -> tabbedPane
				.remove(telacadastrocliente));
		tabbedPane.addTab("Cliente", telacadastrocliente);
		mostraUltima();

	}

	protected void abrirTelaProduto() {
		
		TelaCadastroProduto telacadastroproduto = new TelaCadastroProduto();
		telacadastroproduto.setCloseAction(e -> tabbedPane
				.remove(telacadastroproduto));
		tabbedPane.addTab("Produto", telacadastroproduto);
		
		mostraUltima();
	}

	private void mostraUltima() {
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
	}
		
}
