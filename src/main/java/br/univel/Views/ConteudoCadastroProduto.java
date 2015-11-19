package br.univel.Views;

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

import org.omg.PortableServer.ForwardRequestHelper;
import org.w3c.dom.CDATASection;
import org.w3c.dom.ls.LSInput;

import br.univel.Categoria.Categoria;
import br.univel.Categoria.CategoriaDaoImp;
import br.univel.Enum.Unidade;
import br.univel.Models.ModelProduto;
import br.univel.Produto.Produto;
import br.univel.Produto.ProdutoDaoImp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JButton btnCadastrar;
	private int idCategoria;
	private JButton btnSalvar;

	/**
	 * Create the panel.
	 */
	public ConteudoCadastroProduto() {
		
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 85, 43, 20, 91, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JLabel label = new JLabel("             ");
		panel.add(label);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		panel.add(btnExcluir);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		panel.add(btnSalvar);

		btncancelar = new JButton("Cancelar");
		btncancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtid.setText("");
				txtcodigobarra.setText("");
				txtcusto.setText("");
				txtdescricao.setText("");
				txtmargemlucro.setText("");
				txtnome.setText("");
				combocategoria.setSelectedIndex(-1);
				combounidade.setSelectedIndex(-1);
			}
		});
		btncancelar.setEnabled(false);
		panel.add(btncancelar);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnEditar.setEnabled(false);
		panel.add(btnEditar);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		panel.add(btnCadastrar);

		JLabel lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);
		
				txtid = new JTextField();
				txtid.setEditable(false);
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
		gbc_lblDescrio.gridx = 3;
		gbc_lblDescrio.gridy = 1;
		add(lblDescrio, gbc_lblDescrio);

		txtdescricao = new JTextField();
		GridBagConstraints gbc_txtdescricao = new GridBagConstraints();
		gbc_txtdescricao.insets = new Insets(0, 0, 5, 0);
		gbc_txtdescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtdescricao.gridx = 4;
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
		gbc_txtcodigobarra.gridwidth = 2;
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
		gbc_lblNome.gridx = 3;
		gbc_lblNome.gridy = 2;
		add(lblNome, gbc_lblNome);

		txtnome = new JTextField();
		GridBagConstraints gbc_txtnome = new GridBagConstraints();
		gbc_txtnome.insets = new Insets(0, 0, 5, 0);
		gbc_txtnome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnome.gridx = 4;
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
		gbc_txtcusto.gridwidth = 2;
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
		gbc_lblMagemLucro.gridx = 3;
		gbc_lblMagemLucro.gridy = 3;
		add(lblMagemLucro, gbc_lblMagemLucro);

		txtmargemlucro = new JTextField();
		GridBagConstraints gbc_txtmargemlucro = new GridBagConstraints();
		gbc_txtmargemlucro.insets = new Insets(0, 0, 5, 0);
		gbc_txtmargemlucro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtmargemlucro.gridx = 4;
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
		gbc_lblCategoria.gridx = 3;
		gbc_lblCategoria.gridy = 4;
		add(lblCategoria, gbc_lblCategoria);
		
		CategoriaDaoImp cdao = new CategoriaDaoImp();
		ArrayList<Categoria> lista = (ArrayList<Categoria>) cdao.listar();
		combocategoria = new JComboBox();
		GridBagConstraints gbc_combocategoria = new GridBagConstraints();
		gbc_combocategoria.insets = new Insets(0, 0, 5, 0);
		gbc_combocategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_combocategoria.gridx = 4;
		gbc_combocategoria.gridy = 4;
		add(combocategoria, gbc_combocategoria);
		for (int i = 0; i <lista.size(); i++) {			
			combocategoria.addItem(lista.get(i).getCategoria());
			idCategoria = lista.get(i).getId();
		}

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 6;
		add(scrollPane, gbc_scrollPane);

		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btnSalvar.setEnabled(true);
				btncancelar.setEnabled(true);
				btnEditar.setEnabled(true);
				btnExcluir.setEnabled(true);
				
				editar();
			}
		});
		scrollPane.setViewportView(table);
		
	
	}


	protected void editar() {
		ProdutoDaoImp pdao = new ProdutoDaoImp();
		int linha = table.getSelectedRow();
		CategoriaDaoImp cdao = new CategoriaDaoImp();
		ArrayList<Categoria> c = (ArrayList<Categoria>) cdao.listar();
		ArrayList<Produto> p = (ArrayList<Produto>) pdao.listar();
		
		txtid.setText(String.valueOf(p.get(linha).getId()));
		txtnome.setText(p.get(linha).getNome());
		txtcodigobarra.setText(String.valueOf(p.get(linha).getCodigodebarras()));
		txtdescricao.setText(p.get(linha).getDescricao());
		txtcusto.setText(String.valueOf(p.get(linha).getCusto()));
		txtmargemlucro.setText(String.valueOf(p.get(linha).getMargemdelucro()));
		
		for (Categoria categoria : cdao.listar()) {
			if(p.get(linha).getCategoria() == categoria.getId())
			combocategoria.setSelectedItem(categoria.getCategoria());	
		}		
		combounidade.setSelectedItem(p.get(linha).getUnidade());
		
		
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

		if(p.getId() == 0)
			pdao.inserir(p);
		else
			pdao.atualizar(p);
		model.fireTableDataChanged();
		cancelar();

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
