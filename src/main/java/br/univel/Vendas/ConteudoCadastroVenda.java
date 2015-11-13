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
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.FlowLayout;

import javax.swing.SwingConstants;

import br.univel.Venda.Venda;
import br.univel.Venda.VendaDaoImp;
import br.univel.itemsvendas.ItemsVendas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ConteudoCadastroVenda extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtid;
	private JTextField txtnome;
	private JTable tableClietne;
	private JTable tableProduto;
	private JTable tableVendaProduto;
	private BigDecimal total = new BigDecimal(0);
	
	ModeItemsVendas modelitemsvendas = new ModeItemsVendas();

	ModelProduto modelproduto = new ModelProduto(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

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
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

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
				return "ouve algun Erro";
				
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
				return "ouve algun Erro!";
				
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
		
		JButton btnNewButton_2 = new JButton("Novo");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Cnacelar");
		panel.add(btnNewButton_1);
		
		JButton btnconfirmar = new JButton("Comfirmar");
		btnconfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				concluirVenda();
			}
		});
		panel.add(btnconfirmar);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{25, 45, 69, 37, 24, 0, 89, 0, 78, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		panel_1.add(lblId, gbc_lblId);
		
		txtid = new JTextField();
		txtid.setEditable(false);
		GridBagConstraints gbc_txtid = new GridBagConstraints();
		gbc_txtid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtid.insets = new Insets(0, 0, 5, 5);
		gbc_txtid.gridx = 1;
		gbc_txtid.gridy = 1;
		panel_1.add(txtid, gbc_txtid);
		txtid.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 2;
		gbc_lblNome.gridy = 1;
		panel_1.add(lblNome, gbc_lblNome);
		
		txtnome = new JTextField();
		txtnome.setEditable(false);
		GridBagConstraints gbc_txtnome = new GridBagConstraints();
		gbc_txtnome.gridwidth = 4;
		gbc_txtnome.insets = new Insets(0, 0, 5, 5);
		gbc_txtnome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnome.gridx = 3;
		gbc_txtnome.gridy = 1;
		panel_1.add(txtnome, gbc_txtnome);
		txtnome.setColumns(10);
		
		JLabel lblValorPago = new JLabel("Valor Pago: ");
		GridBagConstraints gbc_lblValorPago = new GridBagConstraints();
		gbc_lblValorPago.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorPago.anchor = GridBagConstraints.EAST;
		gbc_lblValorPago.gridx = 8;
		gbc_lblValorPago.gridy = 1;
		panel_1.add(lblValorPago, gbc_lblValorPago);
		
		txtvalorpago = new JTextField();
		txtvalorpago.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				DecimalFormat df = new DecimalFormat("#,##0.00");
				
				lblvalorrecebido.setText(txtvalorpago.getText().toString());
				BigDecimal valor = total;
				BigDecimal valorrecebido =  BigDecimal.valueOf(Double.valueOf(lblvalorrecebido.getText()));
				BigDecimal troco = valorrecebido.subtract(valor);
				
				lbltroco.setText(df.format(troco));
			}
		});
		GridBagConstraints gbc_txtvalorpago = new GridBagConstraints();
		gbc_txtvalorpago.gridwidth = 3;
		gbc_txtvalorpago.insets = new Insets(0, 0, 5, 5);
		gbc_txtvalorpago.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtvalorpago.gridx = 9;
		gbc_txtvalorpago.gridy = 1;
		panel_1.add(txtvalorpago, gbc_txtvalorpago);
		txtvalorpago.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridwidth = 3;
		gbc_scrollPane_2.gridheight = 6;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 3;
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
		gbc_scrollPane.gridy = 3;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		tableProduto = new JTable(modelproduto);
		tableProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		scrollPane.setViewportView(tableProduto);
		
		JButton button = new JButton(">>");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionaItems();
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 10;
		gbc_button.gridy = 3;
		panel_1.add(button, gbc_button);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 5;
		gbc_scrollPane_1.gridheight = 6;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 11;
		gbc_scrollPane_1.gridy = 3;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);
		
		tableVendaProduto = new JTable(modelitemsvendas);
		scrollPane_1.setViewportView(tableVendaProduto);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 14;
		gbc_lblTotal.gridy = 9;
		panel_1.add(lblTotal, gbc_lblTotal);
		
		lbltotal = new JLabel("0");
		GridBagConstraints gbc_lbltotal = new GridBagConstraints();
		gbc_lbltotal.insets = new Insets(0, 0, 5, 5);
		gbc_lbltotal.gridx = 15;
		gbc_lbltotal.gridy = 9;
		panel_1.add(lbltotal, gbc_lbltotal);
		
		JLabel lblTroco = new JLabel("VALOR RECEBIDO");
		GridBagConstraints gbc_lblTroco = new GridBagConstraints();
		gbc_lblTroco.insets = new Insets(0, 0, 5, 5);
		gbc_lblTroco.gridx = 14;
		gbc_lblTroco.gridy = 10;
		panel_1.add(lblTroco, gbc_lblTroco);
		
		lblvalorrecebido = new JLabel("0");
		GridBagConstraints gbc_lblvalorrecebido = new GridBagConstraints();
		gbc_lblvalorrecebido.insets = new Insets(0, 0, 5, 5);
		gbc_lblvalorrecebido.gridx = 15;
		gbc_lblvalorrecebido.gridy = 10;
		panel_1.add(lblvalorrecebido, gbc_lblvalorrecebido);
		
		JLabel lblTroco_1 = new JLabel("TROCO");
		GridBagConstraints gbc_lblTroco_1 = new GridBagConstraints();
		gbc_lblTroco_1.anchor = GridBagConstraints.EAST;
		gbc_lblTroco_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTroco_1.gridx = 14;
		gbc_lblTroco_1.gridy = 11;
		panel_1.add(lblTroco_1, gbc_lblTroco_1);
		
		lbltroco = new JLabel("0");
		GridBagConstraints gbc_lbltroco = new GridBagConstraints();
		gbc_lbltroco.insets = new Insets(0, 0, 5, 5);
		gbc_lbltroco.gridx = 15;
		gbc_lbltroco.gridy = 11;
		panel_1.add(lbltroco, gbc_lbltroco);

	}

	protected void concluirVenda() {
		
		Timestamp Datahoje = new Timestamp(System.currentTimeMillis());
		VendaDaoImp vdao = new VendaDaoImp();
		Venda v = new Venda();
		ItemsVendas iv = new ItemsVendas();
		
		v.setNomecliente(txtnome.getText());
		v.setHoravenda(Datahoje);
		v.setTotal(total);
		
		vdao.inserir(v);
		
		
		
		for (int i = 0; i < modelitemsvendas.lista.size(); i++) {
			iv.setIdvenda(vdao.listar().get(i).getIdvenda());
			iv.setNomeproduto(modelitemsvendas.lista.get(i).getNomeproduto());
			iv.setCustoproduto(modelitemsvendas.lista.get(i).getCustoproduto().multiply(BigDecimal.valueOf(Double.valueOf(modelitemsvendas.lista.get(i).getQuantidade()))));
			iv.setMargemlucro(modelproduto.lista.get(i).getMargemdelucro());
			iv.setQuantidade(modelitemsvendas.lista.get(i).getQuantidade());
		}
		
		
		
		
		
		
		
		
		
		
	}

	ClienteDaoImpl cdao = new ClienteDaoImpl();
	private JTextField txtvalorpago;
	
	protected void AdicionarCliente() {
		txtid.setText((String.valueOf(cdao.listar().get(tableClietne.getSelectedRow()).getId())));
		txtnome.setText(cdao.listar().get(tableClietne.getSelectedRow()).getNome());
		
		
		
	}


	protected void adicionaItems() {
		
		ItemsVendas items = new ItemsVendas();
		
		ProdutoDaoImp pdao = new ProdutoDaoImp();
	
		items.setQuantidade(Integer.valueOf(JOptionPane.showInputDialog(null, "Informe a quntidade Desejada")));
		items.setNomeproduto(pdao.listar().get(tableProduto.getSelectedRow()).getDescricao());
		items.setCustoproduto(pdao.listar().get(tableProduto.getSelectedRow()).getCusto());
		
		total = total.add(items.getCustoproduto().multiply(BigDecimal.valueOf(Double.valueOf(items.getQuantidade()))));
		
		modelitemsvendas.lista.add(items);
		DecimalFormat df = new DecimalFormat("#,##0.00");
					
		lbltotal.setText(df.format(total));
	}
		
}

