package br.univel.Views;

import java.awt.BorderLayout;

public class TelaCadastroProduto extends MolduraAbstract {
	private static final long serialVersionUID = 1L;


	public TelaCadastroProduto() {
		super();
	}

	@Override
	protected void configuraConteudo() {
		super.add(new ConteudoCadastroProduto(), BorderLayout.CENTER);
		
	}

	
}
