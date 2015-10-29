package br.univel.Vendas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ConteudoCadastroProduto extends JPanel {
	private JTextField txtid;
	private JTextField txtdescricao;
	private JTextField txtcodigobarra;
	private JTextField txtcusto;
	private JTextField txtmargemlucro;

	/**
	 * Create the panel.
	 */
	public ConteudoCadastroProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);
		
		txtid = new JTextField();
		GridBagConstraints gbc_txtid = new GridBagConstraints();
		gbc_txtid.insets = new Insets(0, 0, 5, 0);
		gbc_txtid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtid.gridx = 1;
		gbc_txtid.gridy = 0;
		add(txtid, gbc_txtid);
		txtid.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.anchor = GridBagConstraints.EAST;
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.gridx = 0;
		gbc_lblDescrio.gridy = 1;
		add(lblDescrio, gbc_lblDescrio);
		
		txtdescricao = new JTextField();
		GridBagConstraints gbc_txtdescricao = new GridBagConstraints();
		gbc_txtdescricao.insets = new Insets(0, 0, 5, 0);
		gbc_txtdescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtdescricao.gridx = 1;
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
		gbc_txtcodigobarra.insets = new Insets(0, 0, 5, 0);
		gbc_txtcodigobarra.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcodigobarra.gridx = 1;
		gbc_txtcodigobarra.gridy = 2;
		add(txtcodigobarra, gbc_txtcodigobarra);
		txtcodigobarra.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 0;
		gbc_lblCategoria.gridy = 3;
		add(lblCategoria, gbc_lblCategoria);
		
		JComboBox combocategoria = new JComboBox();
		GridBagConstraints gbc_combocategoria = new GridBagConstraints();
		gbc_combocategoria.insets = new Insets(0, 0, 5, 0);
		gbc_combocategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_combocategoria.gridx = 1;
		gbc_combocategoria.gridy = 3;
		add(combocategoria, gbc_combocategoria);
		
		JLabel lblCusto = new JLabel("Custo");
		GridBagConstraints gbc_lblCusto = new GridBagConstraints();
		gbc_lblCusto.anchor = GridBagConstraints.EAST;
		gbc_lblCusto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCusto.gridx = 0;
		gbc_lblCusto.gridy = 4;
		add(lblCusto, gbc_lblCusto);
		
		txtcusto = new JTextField();
		GridBagConstraints gbc_txtcusto = new GridBagConstraints();
		gbc_txtcusto.insets = new Insets(0, 0, 5, 0);
		gbc_txtcusto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcusto.gridx = 1;
		gbc_txtcusto.gridy = 4;
		add(txtcusto, gbc_txtcusto);
		txtcusto.setColumns(10);
		
		JLabel lblMagemLucro = new JLabel("Magem de Lucro");
		GridBagConstraints gbc_lblMagemLucro = new GridBagConstraints();
		gbc_lblMagemLucro.anchor = GridBagConstraints.EAST;
		gbc_lblMagemLucro.insets = new Insets(0, 0, 5, 5);
		gbc_lblMagemLucro.gridx = 0;
		gbc_lblMagemLucro.gridy = 5;
		add(lblMagemLucro, gbc_lblMagemLucro);
		
		txtmargemlucro = new JTextField();
		GridBagConstraints gbc_txtmargemlucro = new GridBagConstraints();
		gbc_txtmargemlucro.insets = new Insets(0, 0, 5, 0);
		gbc_txtmargemlucro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtmargemlucro.gridx = 1;
		gbc_txtmargemlucro.gridy = 5;
		add(txtmargemlucro, gbc_txtmargemlucro);
		txtmargemlucro.setColumns(10);
		
		JLabel lblUnidade = new JLabel("Unidade");
		GridBagConstraints gbc_lblUnidade = new GridBagConstraints();
		gbc_lblUnidade.anchor = GridBagConstraints.EAST;
		gbc_lblUnidade.insets = new Insets(0, 0, 0, 5);
		gbc_lblUnidade.gridx = 0;
		gbc_lblUnidade.gridy = 6;
		add(lblUnidade, gbc_lblUnidade);
		
		JComboBox combounidade = new JComboBox();
		GridBagConstraints gbc_combounidade = new GridBagConstraints();
		gbc_combounidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_combounidade.gridx = 1;
		gbc_combounidade.gridy = 6;
		add(combounidade, gbc_combounidade);

	}

}
