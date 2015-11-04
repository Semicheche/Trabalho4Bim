package br.univel.Vendas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConteudoCadastroProduto extends JPanel {
	private JTextField txtid;
	private JTextField txtdescricao;
	private JTextField txtcodigobarra;
	private JTextField txtcusto;
	private JTextField txtmargemlucro;
	private JComboBox combocategoria;
	private JComboBox combounidade;

	/**
	 * Create the panel.
	 */
	public ConteudoCadastroProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
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
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		panel.add(btnExcluir);
		
		JButton btncancelar = new JButton("Cancelar");
		btncancelar.setEnabled(false);
		panel.add(btncancelar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		panel.add(btnEditar);
		
		JButton btnSalvar = new JButton("Salvar");
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
		
		JLabel lblCategoria = new JLabel("Categoria");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 2;
		gbc_lblCategoria.gridy = 2;
		add(lblCategoria, gbc_lblCategoria);
		
		combocategoria = new JComboBox();
		GridBagConstraints gbc_combocategoria = new GridBagConstraints();
		gbc_combocategoria.insets = new Insets(0, 0, 5, 0);
		gbc_combocategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_combocategoria.gridx = 3;
		gbc_combocategoria.gridy = 2;
		add(combocategoria, gbc_combocategoria);
		
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
		
		combounidade = new JComboBox();
		GridBagConstraints gbc_combounidade = new GridBagConstraints();
		gbc_combounidade.insets = new Insets(0, 0, 5, 5);
		gbc_combounidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_combounidade.gridx = 1;
		gbc_combounidade.gridy = 4;
		add(combounidade, gbc_combounidade);

	}

	protected void Cadastrar() {
		Produto p = new Produto();
		
		p.setCategoria((Categoria) combocategoria.getSelectedItem());
		p.setCodigodebarras(Integer.valueOf(txtcodigobarra.getText()));
		
		
	}
	
	
	
	
	
	
	
	

}
