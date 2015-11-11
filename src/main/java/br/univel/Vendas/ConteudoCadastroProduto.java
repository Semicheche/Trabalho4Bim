package br.univel.Vendas;

import javax.print.attribute.standard.PDLOverrideSupported;
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.w3c.dom.CDATASection;
import org.w3c.dom.ls.LSInput;

public class ConteudoCadastroProduto extends JPanel {
	private JTextField txtid;
	private JTextField txtdescricao;
	private JTextField txtcodigobarra;
	private JTextField txtcusto;
	private JTextField txtmargemlucro;
	private JComboBox combocategoria;
	private JComboBox combounidade;
	private JTable table;
	ProdutoDaoImp pdao = new ProdutoDaoImp();
	ModelProduto model = new ModelProduto();
	private JTextField txtnome;
	private JButton btnExcluir;
	private JButton btncancelar;
	private JButton btnEditar;
	private JButton btnSalvar;
	private int idCategoria;

	/**
	 * Create the panel.
	 */
	public ConteudoCadastroProduto() {
		
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JButton btnNewButton_3 = new JButton("Novo");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastrar();
			}
		});
		panel.add(btnNewButton_3);

		JLabel label = new JLabel("             ");
		panel.add(label);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		panel.add(btnExcluir);

		btncancelar = new JButton("Cancelar");
		btncancelar.setEnabled(false);
		panel.add(btncancelar);

		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		panel.add(btnEditar);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		btnSalvar.setEnabled(false);
		panel.add(btnSalvar);

		JLabel lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);

		txtid = new JTextField();
		GridBagConstraints gbc_txtid = new GridBagConstraints();
		gbc_txtid.insets = new Insets(0, 0, 5, 5);
		gbc_txtid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtid.gridx = 1;
		gbc_txtid.gridy = 1;
		add(txtid, gbc_txtid);
		txtid.setColumns(10);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.anchor = GridBagConstraints.EAST;
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.gridx = 2;
		gbc_lblDescrio.gridy = 1;
		add(lblDescrio, gbc_lblDescrio);

		txtdescricao = new JTextField();
		GridBagConstraints gbc_txtdescricao = new GridBagConstraints();
		gbc_txtdescricao.insets = new Insets(0, 0, 5, 0);
		gbc_txtdescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtdescricao.gridx = 3;
		gbc_txtdescricao.gridy = 1;
		add(txtdescricao, gbc_txtdescricao);
		txtdescricao.setColumns(10);

		JLabel lblCodigoDeBarras = new JLabel("Codigo de Barras");
		GridBagConstraints gbc_lblCodigoDeBarras = new GridBagConstraints();
		gbc_lblCodigoDeBarras.anchor = GridBagConstraints.EAST;
		gbc_lblCodigoDeBarras.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigoDeBarras.gridx = 0;
		gbc_lblCodigoDeBarras.gridy = 2;
		add(lblCodigoDeBarras, gbc_lblCodigoDeBarras);

		txtcodigobarra = new JTextField();
		GridBagConstraints gbc_txtcodigobarra = new GridBagConstraints();
		gbc_txtcodigobarra.insets = new Insets(0, 0, 5, 5);
		gbc_txtcodigobarra.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcodigobarra.gridx = 1;
		gbc_txtcodigobarra.gridy = 2;
		add(txtcodigobarra, gbc_txtcodigobarra);
		txtcodigobarra.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 2;
		gbc_lblNome.gridy = 2;
		add(lblNome, gbc_lblNome);

		txtnome = new JTextField();
		GridBagConstraints gbc_txtnome = new GridBagConstraints();
		gbc_txtnome.insets = new Insets(0, 0, 5, 0);
		gbc_txtnome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnome.gridx = 3;
		gbc_txtnome.gridy = 2;
		add(txtnome, gbc_txtnome);
		txtnome.setColumns(10);

		JLabel lblCusto = new JLabel("Custo");
		GridBagConstraints gbc_lblCusto = new GridBagConstraints();
		gbc_lblCusto.anchor = GridBagConstraints.EAST;
		gbc_lblCusto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCusto.gridx = 0;
		gbc_lblCusto.gridy = 3;
		add(lblCusto, gbc_lblCusto);

		txtcusto = new JTextField();
		GridBagConstraints gbc_txtcusto = new GridBagConstraints();
		gbc_txtcusto.insets = new Insets(0, 0, 5, 5);
		gbc_txtcusto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcusto.gridx = 1;
		gbc_txtcusto.gridy = 3;
		add(txtcusto, gbc_txtcusto);
		txtcusto.setColumns(10);

		JLabel lblMagemLucro = new JLabel("Magem de Lucro");
		GridBagConstraints gbc_lblMagemLucro = new GridBagConstraints();
		gbc_lblMagemLucro.anchor = GridBagConstraints.EAST;
		gbc_lblMagemLucro.insets = new Insets(0, 0, 5, 5);
		gbc_lblMagemLucro.gridx = 2;
		gbc_lblMagemLucro.gridy = 3;
		add(lblMagemLucro, gbc_lblMagemLucro);

		txtmargemlucro = new JTextField();
		GridBagConstraints gbc_txtmargemlucro = new GridBagConstraints();
		gbc_txtmargemlucro.insets = new Insets(0, 0, 5, 0);
		gbc_txtmargemlucro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtmargemlucro.gridx = 3;
		gbc_txtmargemlucro.gridy = 3;
		add(txtmargemlucro, gbc_txtmargemlucro);
		txtmargemlucro.setColumns(10);

		JLabel lblUnidade = new JLabel("Unidade");
		GridBagConstraints gbc_lblUnidade = new GridBagConstraints();
		gbc_lblUnidade.anchor = GridBagConstraints.EAST;
		gbc_lblUnidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnidade.gridx = 0;
		gbc_lblUnidade.gridy = 4;
		add(lblUnidade, gbc_lblUnidade);

		combounidade = new JComboBox(Unidade.values());
		GridBagConstraints gbc_combounidade = new GridBagConstraints();
		gbc_combounidade.insets = new Insets(0, 0, 5, 5);
		gbc_combounidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_combounidade.gridx = 1;
		gbc_combounidade.gridy = 4;
		add(combounidade, gbc_combounidade);

		JLabel lblCategoria = new JLabel("Categoria");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 2;
		gbc_lblCategoria.gridy = 4;
		add(lblCategoria, gbc_lblCategoria);
		
		CategoriaDaoImp cdao = new CategoriaDaoImp();
		ArrayList<Categoria> lista = (ArrayList<Categoria>) cdao.listar();
		combocategoria = new JComboBox();
		GridBagConstraints gbc_combocategoria = new GridBagConstraints();
		gbc_combocategoria.insets = new Insets(0, 0, 5, 0);
		gbc_combocategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_combocategoria.gridx = 3;
		gbc_combocategoria.gridy = 4;
		add(combocategoria, gbc_combocategoria);
		for (int i = 0; i <lista.size(); i++) {			
			combocategoria.addItem(lista.get(i).getCategoria());
			if(combocategoria.equals(lista.get(i).getCategoria().toString()))
				idCategoria = lista.get(i).getId();
		}

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 6;
		add(scrollPane, gbc_scrollPane);

		table = new JTable(model);
		scrollPane.setViewportView(table);
		
	
	}


	protected void salvar() {
		Produto p = new Produto();

		p.setCategoria(idCategoria);
		p.setNome(txtnome.getText());
		p.setCodigodebarras(Integer.valueOf(txtcodigobarra.getText()));
		p.setDescricao(txtdescricao.getText());
		p.setUnidade(Unidade.valueOf(combounidade.getSelectedItem().toString()));
		p.setCusto(BigDecimal.valueOf(Double.valueOf(txtcusto.getText())));
		p.setMargemdelucro(BigDecimal.valueOf(Double.valueOf(txtmargemlucro
				.getText())));

		pdao.inserir(p);
		model.fireTableDataChanged();
		cancelar();

	}

	protected void Cadastrar() {
		btnSalvar.setEnabled(true);
		btncancelar.setEnabled(true);

	}

	private void cancelar() {
		txtid.setText("");
		txtdescricao.setText("");
		txtcodigobarra.setText("");
		txtnome.setText("");
		txtcusto.setText("");
		txtmargemlucro.setText("");

	}

}
