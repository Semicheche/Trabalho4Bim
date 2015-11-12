package br.univel.Vendas;

import javax.swing.JPanel;

import java.awt.BorderLayout;

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

import br.univel.itemsvendas.ItemsVendas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.peer.RobotPeer;

public class ConteudoCadastroVenda extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTable tableClietne;
	private JTable tableProduto;
	private JTable tableVendaProduto;
	private int idproduto;
	private String descricao;
	
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
					return "ouve um Erro";
		}
		}
	};
	
	
	
	ModelCliente modelcliente = new ModelCliente(){
		
		public int getRowCount() {
			return lista.size();
		}

		@Override
		public int getColumnCount() {
			return 2;
		}
		
		@Override
		public String getColumnName(int column) {
			
			switch (column) {
			
			case 0:
				return "ID";
			case 1:
				return "Nome";
			default:
				return "Ouve algun erro";
				
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
				return "Ouve algun erro";
				
			}
		}
	};
	
	
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
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setEnabled(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 2;
		gbc_lblNome.gridy = 0;
		panel_1.add(lblNome, gbc_lblNome);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 4;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 0;
		panel_1.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
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
		scrollPane_2.setViewportView(tableClietne);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}

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
		
		JLabel label = new JLabel("0");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 15;
		gbc_label.gridy = 8;
		panel_1.add(label, gbc_label);
		
		JLabel lblTroco = new JLabel("VALOR RECEBIDO");
		GridBagConstraints gbc_lblTroco = new GridBagConstraints();
		gbc_lblTroco.insets = new Insets(0, 0, 5, 5);
		gbc_lblTroco.gridx = 14;
		gbc_lblTroco.gridy = 9;
		panel_1.add(lblTroco, gbc_lblTroco);
		
		JLabel label_1 = new JLabel("0");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 15;
		gbc_label_1.gridy = 9;
		panel_1.add(label_1, gbc_label_1);
		
		JLabel lblTroco_1 = new JLabel("TROCO");
		GridBagConstraints gbc_lblTroco_1 = new GridBagConstraints();
		gbc_lblTroco_1.anchor = GridBagConstraints.EAST;
		gbc_lblTroco_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTroco_1.gridx = 14;
		gbc_lblTroco_1.gridy = 10;
		panel_1.add(lblTroco_1, gbc_lblTroco_1);
		
		JLabel label_2 = new JLabel("0");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 15;
		gbc_label_2.gridy = 10;
		panel_1.add(label_2, gbc_label_2);

	}


	protected void AdicionaItems() {
		
		
		
	}
	private void BuscarIdProd() {
		ItemsVendas items = new ItemsVendas();
		
		ProdutoDaoImp pdao = new ProdutoDaoImp();
		idproduto = pdao.listar().get(tableProduto.getSelectedRow()).getId();
		descricao = pdao.listar().get(tableProduto.getSelectedRow()).getDescricao();
		
		items.setNomeproduto(descricao);
		
		modelitemsvendas.lista.add(items);
		modelitemsvendas.fireTableDataChanged();
	}

}
