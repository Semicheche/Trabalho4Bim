package br.univel.Views;

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

import br.univel.Cliente.Cliente;
import br.univel.Cliente.ClienteDaoImpl;
import br.univel.Models.ModeItemsVendas;
import br.univel.Models.ModelCliente;
import br.univel.Models.ModelProduto;
import br.univel.Produto.Produto;
import br.univel.Produto.ProdutoDaoImp;
import br.univel.Venda.Venda;
import br.univel.Venda.VendaDaoImp;
import br.univel.itemsvendas.ItemsVendas;
import br.univel.itemsvendas.ItemsVendasDAOImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.security.acl.LastOwnerException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;

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
	private int idvenda;
	
	VendaDaoImp vdao = new VendaDaoImp();
	
	/**
	 * Create the panel.
	 */
	public ConteudoCadastroVenda() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnconfirmar = new JButton("Comfirmar");
		btnconfirmar.setIcon(new ImageIcon(ConteudoCadastroVenda.class.getResource("/icon/Shopping-basket-accept.png")));
		btnconfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				concluirVenda();
			}
		});
		panel.add(btnconfirmar);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{25, 45, 88, 37, 24, 0, 89, 0, 78, 59, 0, 12, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_txtnome.gridwidth = 5;
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
				BigDecimal valorpago = new BigDecimal(Double.valueOf(txtvalorpago.getText().replaceAll(",", ".")));
				BigDecimal valortotal = new BigDecimal(Double.valueOf(lbltotal.getText().replaceAll(",", ".")));
				
				if(valorpago.doubleValue() >= valortotal.doubleValue() ){
					
				NumberFormat nfBR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
				
				lblvalorrecebido.setText(txtvalorpago.getText());
				BigDecimal valor = total;
				BigDecimal valorrecebido = BigDecimal.valueOf(Double.valueOf(lblvalorrecebido.getText().replaceAll(",", ".")));
				BigDecimal troco = valorrecebido.subtract(valor);
				
				lbltroco.setText(nfBR.format(troco));
				}else{
					JOptionPane.showMessageDialog(null,"Valor pago e menor que total da Compra");
				}
			}
		});
		GridBagConstraints gbc_txtvalorpago = new GridBagConstraints();
		gbc_txtvalorpago.gridwidth = 2;
		gbc_txtvalorpago.insets = new Insets(0, 0, 5, 5);
		gbc_txtvalorpago.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtvalorpago.gridx = 9;
		gbc_txtvalorpago.gridy = 1;
		panel_1.add(txtvalorpago, gbc_txtvalorpago);
		txtvalorpago.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.gridwidth = 3;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 1;
		gbc_lblCliente.gridy = 3;
		panel_1.add(lblCliente, gbc_lblCliente);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setBackground(SystemColor.activeCaption);
		GridBagConstraints gbc_lblProdutos = new GridBagConstraints();
		gbc_lblProdutos.gridwidth = 3;
		gbc_lblProdutos.insets = new Insets(0, 0, 5, 5);
		gbc_lblProdutos.gridx = 6;
		gbc_lblProdutos.gridy = 3;
		panel_1.add(lblProdutos, gbc_lblProdutos);
		
		JLabel lblNewLabel = new JLabel("Items da Nota");
		lblNewLabel.setBackground(SystemColor.activeCaption);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 11;
		gbc_lblNewLabel.gridy = 3;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridwidth = 3;
		gbc_scrollPane_2.gridheight = 7;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 1;
		gbc_scrollPane_2.gridy = 4;
		panel_1.add(scrollPane_2, gbc_scrollPane_2);
		
		tableClietne = new JTable(modelcliente);
		tableClietne.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AdicionarCliente();
				tableProduto.setEnabled(true);
				tableVendaProduto.setEnabled(true);
			}
		});
		scrollPane_2.setViewportView(tableClietne);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.addMouseListener(new MouseAdapter() {
			
		});
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 5;
		gbc_scrollPane.gridy = 4;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		tableProduto = new JTable(modelproduto);
		tableProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtid.getText().equals("") && txtnome.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Selecione um cliente!!!");
				}
					
			}
		});
		scrollPane.setViewportView(tableProduto);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(ConteudoCadastroVenda.class.getResource("/icon/Next-.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionaItems();
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.NORTH;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 10;
		gbc_button.gridy = 4;
		panel_1.add(button, gbc_button);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setEnabled(false);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 5;
		gbc_scrollPane_1.gridheight = 7;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 11;
		gbc_scrollPane_1.gridy = 4;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);
		
		tableVendaProduto = new JTable(modelitemsvendas);
		scrollPane_1.setViewportView(tableVendaProduto);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(ConteudoCadastroVenda.class.getResource("/icon/Previous-icon.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerItens();	
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 10;
		gbc_button_1.gridy = 6;
		panel_1.add(button_1, gbc_button_1);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 14;
		gbc_lblTotal.gridy = 11;
		panel_1.add(lblTotal, gbc_lblTotal);
		
		lbltotal = new JLabel("0");
		GridBagConstraints gbc_lbltotal = new GridBagConstraints();
		gbc_lbltotal.insets = new Insets(0, 0, 5, 5);
		gbc_lbltotal.gridx = 15;
		gbc_lbltotal.gridy = 11;
		panel_1.add(lbltotal, gbc_lbltotal);
		
		JLabel lblTroco = new JLabel("VALOR RECEBIDO");
		GridBagConstraints gbc_lblTroco = new GridBagConstraints();
		gbc_lblTroco.insets = new Insets(0, 0, 5, 5);
		gbc_lblTroco.gridx = 14;
		gbc_lblTroco.gridy = 12;
		panel_1.add(lblTroco, gbc_lblTroco);
		
		lblvalorrecebido = new JLabel("0");
		GridBagConstraints gbc_lblvalorrecebido = new GridBagConstraints();
		gbc_lblvalorrecebido.insets = new Insets(0, 0, 5, 5);
		gbc_lblvalorrecebido.gridx = 15;
		gbc_lblvalorrecebido.gridy = 12;
		panel_1.add(lblvalorrecebido, gbc_lblvalorrecebido);
		
		JLabel lblTroco_1 = new JLabel("TROCO");
		GridBagConstraints gbc_lblTroco_1 = new GridBagConstraints();
		gbc_lblTroco_1.anchor = GridBagConstraints.EAST;
		gbc_lblTroco_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTroco_1.gridx = 14;
		gbc_lblTroco_1.gridy = 13;
		panel_1.add(lblTroco_1, gbc_lblTroco_1);
		
		lbltroco = new JLabel("0");
		GridBagConstraints gbc_lbltroco = new GridBagConstraints();
		gbc_lbltroco.insets = new Insets(0, 0, 5, 5);
		gbc_lbltroco.gridx = 15;
		gbc_lbltroco.gridy = 13;
		panel_1.add(lbltroco, gbc_lbltroco);

	}

	protected void confirmarVenda() {
		ItemsVendas iv = new ItemsVendas();
		ItemsVendasDAOImpl ivdao = new ItemsVendasDAOImpl();

		for (int i = 0; i < modelitemsvendas.lista.size(); i++) {
			iv.setIdvenda(idvenda);
			iv.setNomeproduto(modelitemsvendas.lista.get(i).getNomeproduto());
			iv.setCustoproduto(modelitemsvendas.lista.get(i).getCustoproduto());
			iv.setMargemlucro(modelproduto.lista.get(i).getMargemdelucro());
			iv.setQuantidade(modelitemsvendas.lista.get(i).getQuantidade());
			
			ivdao.inserir(iv);
			
		}
		idvenda = 0;
		modelitemsvendas.lista.clear();
		modelitemsvendas.fireTableDataChanged();
	}

	protected void concluirVenda() {
		if(txtvalorpago.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Informe o Valor a ser Pago!!!");
		}else{
			Timestamp Datahoje = new Timestamp(System.currentTimeMillis());
			Venda v = new Venda();
			
			v.setNomecliente(txtnome.getText());
			v.setHoravenda(Datahoje);
			v.setTotal(total);
			
			vdao.inserir(v);
			idvenda = vdao.listar().get(vdao.listar().size()-1).getIdvenda();
			confirmarVenda();
		}
	}

	ClienteDaoImpl cdao = new ClienteDaoImpl();
	private JTextField txtvalorpago;
	
	protected void AdicionarCliente() {
		txtid.setText((String.valueOf(cdao.listar().get(tableClietne.getSelectedRow()).getId())));
		txtnome.setText(cdao.listar().get(tableClietne.getSelectedRow()).getNome());
		
		
		
	}

	
	protected void removerItens() {
		NumberFormat nfBR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		
		ProdutoDaoImp pdao = new ProdutoDaoImp();
		ItemsVendas items = new ItemsVendas();
		
		if(tableVendaProduto.getSelectedRow() != -1){
			BigDecimal itemretirado = modelitemsvendas.lista.get(tableVendaProduto.getSelectedRow()).getCustoproduto().multiply(modelitemsvendas.lista.get(tableVendaProduto.getSelectedRow()).getQuantidade());
			modelitemsvendas.lista.remove(tableVendaProduto.getSelectedRow());
			
			
			
			total = total.subtract(itemretirado);
			lbltotal.setText(nfBR.format(total));
			modelitemsvendas.fireTableDataChanged();
		}else
			JOptionPane.showMessageDialog(null, "Selecione o item que deseja Remover!!");
	}

	protected void adicionaItems() {
		NumberFormat nfBR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		
		ItemsVendas items = new ItemsVendas();
		ProdutoDaoImp pdao = new ProdutoDaoImp();
	
		items.setQuantidade(BigDecimal.valueOf(Double.valueOf(JOptionPane.showInputDialog(null, "Informe a quntidade Desejada"))));
		items.setNomeproduto(pdao.listar().get(tableProduto.getSelectedRow()).getDescricao());
		items.setCustoproduto(pdao.listar().get(tableProduto.getSelectedRow()).getCusto());
		
		total = total.add(items.getCustoproduto().multiply(items.getQuantidade()));
		
		modelitemsvendas.lista.add(items);
		modelitemsvendas.fireTableDataChanged();
		DecimalFormat df = new DecimalFormat("#,##0.00");
					
		lbltotal.setText(df.format(total));
	}
		
}

