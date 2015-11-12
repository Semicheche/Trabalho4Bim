package br.univel.Vendas;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;











import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;

import java.awt.FlowLayout;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import br.univel.itemsvendas.ItemsVendas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.peer.RobotPeer;
import java.math.BigDecimal;

public class ConteudoCadastroVenda extends JPanel {
	private JTextField txtid;
	private JTextField txtnome;
	private JTable tableClietne;
	private JTable tableProduto;
	private JTable tableVendaProduto;
	private int idproduto;
	private String descricao;
	private BigDecimal valor;
	private String quantidade;
	
	ModeItemsVendas modelitemsvendas = new ModeItemsVendas();

	ModelProduto modelproduto = new ModelProduto(){
		@Override
		public int getRowCount() {
			return lista.size();
		}

		@Override
		public int getColumnCount() {
			
			return 5;
		}

		@Override
		public String getColumnName(int column) {
			
			switch (column) {
				case 0:
					return "Categoria";
				case 1:
					return "Nome";
				case 2:
					return "Codigo de Barras";
				case 3:
					return "Descrição";
				case 4:
					return "Custo";
				default:
					return "ouve um Erro";
			}
		}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			
			Produto p = lista.get(rowIndex);
			
			switch (columnIndex) {
				case 0:
					return p.getCategoria();
				case 1:
					return p.getNome();
				case 2:
					return p.getCodigodebarras();
				case 3:
					return p.getDescricao();
				case 4:
					return p.getCusto();
				default:
					return "Erro";
		}
		}
	};
	
	
	
	ModelCliente modelcliente = new ModelCliente(){
		
		public int getRowCount() {
			return lista.size();
		}

		@Override
		public int getColumnCount() {
			return 3;
		}
		
		@Override
		public String getColumnName(int column) {
			
			switch (column) {
			
			case 0:
				return "ID";
			case 1:
				return "Nome";
			default:
				return "quantidade";
				
			}
			
		}

		@Override
		public Object getValueAt(int row, int col) {
		
			Cliente c = (Cliente) cdao.listar().get(row);
			
			switch (col) {
		
			case 0:
				return c.getId();
			case 1:
				return c.getNome();
			default:
				return quantidade;
				
			}
		}
	};
	private JLabel lbltotal;
	private JLabel lblvalorrecebido;
	private JLabel lbltroco;
	
	
	/**
	 * Create the panel.
	 */
	public ConteudoCadastroVenda() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{25, 45, 34, 63, 46, 0, 89, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		panel_1.add(lblId, gbc_lblId);
		
		txtid = new JTextField();
		txtid.setEditable(false);
		txtid.setEnabled(false);
		GridBagConstraints gbc_txtid = new GridBagConstraints();
		gbc_txtid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtid.insets = new Insets(0, 0, 5, 5);
		gbc_txtid.gridx = 1;
		gbc_txtid.gridy = 0;
		panel_1.add(txtid, gbc_txtid);
		txtid.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 2;
		gbc_lblNome.gridy = 0;
		panel_1.add(lblNome, gbc_lblNome);
		
		txtnome = new JTextField();
		txtnome.setEnabled(false);
		txtnome.setEditable(false);
		GridBagConstraints gbc_txtnome = new GridBagConstraints();
		gbc_txtnome.gridwidth = 4;
		gbc_txtnome.insets = new Insets(0, 0, 5, 5);
		gbc_txtnome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnome.gridx = 3;
		gbc_txtnome.gridy = 0;
		panel_1.add(txtnome, gbc_txtnome);
		txtnome.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridwidth = 4;
		gbc_scrollPane_2.gridheight = 6;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 2;
		panel_1.add(scrollPane_2, gbc_scrollPane_2);
		
		tableClietne = new JTable(modelcliente);
		tableClietne.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AdicionarCliente();
			}
		});
		scrollPane_2.setViewportView(tableClietne);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			
		});
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 4;
		gbc_scrollPane.gridy = 2;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		tableProduto = new JTable(modelproduto);
		tableProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				BuscarIdProd();
			}
		});
		scrollPane.setViewportView(tableProduto);
		
		JButton button = new JButton(">>");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionaItems();
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 10;
		gbc_button.gridy = 2;
		panel_1.add(button, gbc_button);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 5;
		gbc_scrollPane_1.gridheight = 6;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 11;
		gbc_scrollPane_1.gridy = 2;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);
		
		tableVendaProduto = new JTable(modelitemsvendas);
		scrollPane_1.setViewportView(tableVendaProduto);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 14;
		gbc_lblTotal.gridy = 8;
		panel_1.add(lblTotal, gbc_lblTotal);
		
		lbltotal = new JLabel("0");
		GridBagConstraints gbc_lbltotal = new GridBagConstraints();
		gbc_lbltotal.insets = new Insets(0, 0, 5, 5);
		gbc_lbltotal.gridx = 15;
		gbc_lbltotal.gridy = 8;
		panel_1.add(lbltotal, gbc_lbltotal);
		
		JLabel lblTroco = new JLabel("VALOR RECEBIDO");
		GridBagConstraints gbc_lblTroco = new GridBagConstraints();
		gbc_lblTroco.insets = new Insets(0, 0, 5, 5);
		gbc_lblTroco.gridx = 14;
		gbc_lblTroco.gridy = 9;
		panel_1.add(lblTroco, gbc_lblTroco);
		
		lblvalorrecebido = new JLabel("0");
		GridBagConstraints gbc_lblvalorrecebido = new GridBagConstraints();
		gbc_lblvalorrecebido.insets = new Insets(0, 0, 5, 5);
		gbc_lblvalorrecebido.gridx = 15;
		gbc_lblvalorrecebido.gridy = 9;
		panel_1.add(lblvalorrecebido, gbc_lblvalorrecebido);
		
		JLabel lblTroco_1 = new JLabel("TROCO");
		GridBagConstraints gbc_lblTroco_1 = new GridBagConstraints();
		gbc_lblTroco_1.anchor = GridBagConstraints.EAST;
		gbc_lblTroco_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTroco_1.gridx = 14;
		gbc_lblTroco_1.gridy = 10;
		panel_1.add(lblTroco_1, gbc_lblTroco_1);
		
		lbltroco = new JLabel("0");
		GridBagConstraints gbc_lbltroco = new GridBagConstraints();
		gbc_lbltroco.insets = new Insets(0, 0, 5, 5);
		gbc_lbltroco.gridx = 15;
		gbc_lbltroco.gridy = 10;
		panel_1.add(lbltroco, gbc_lbltroco);

	}

	ClienteDaoImpl cdao = new ClienteDaoImpl();
	
	protected void AdicionarCliente() {
		txtid.setText((String.valueOf(cdao.listar().get(tableClietne.getSelectedRow()).getId())));
		txtnome.setText(cdao.listar().get(tableClietne.getSelectedRow()).getNome());
		
		
		
	}


	protected void AdicionaItems() {
//		if(tableProduto.getSelectedRow() != 0){
//			DefaultTableModel produto = (DefaultTableModel) tableProduto.getModel(); 
//			DefaultTableModel items =  (DefaultTableModel) tableVendaProduto.getModel();
//			
//			Object[] obj = {tableProduto.getValueAt(tableProduto.getSelectedRow(), 0), tableProduto.getValueAt(tableProduto.getSelectedRow(), 1)};
//			
//			tableVendaProduto.add(null, obj);		
//		}
		
		ItemsVendas items = new ItemsVendas();
		
		ProdutoDaoImp pdao = new ProdutoDaoImp();
		idproduto = pdao.listar().get(tableProduto.getSelectedRow()).getId();
		descricao = pdao.listar().get(tableProduto.getSelectedRow()).getDescricao();
		valor = pdao.listar().get(tableProduto.getSelectedRow()).getCusto();
		
		 quantidade = JOptionPane.showInputDialog(null, "Informe a quntidade Desejada");
		
		
		items.setNomeproduto(descricao);
		items.setCustoproduto(valor);
		
		modelitemsvendas.lista.add(items);
		modelitemsvendas.fireTableDataChanged();
			
		
	}
	


	private void BuscarIdProd() {
		
	}

}
