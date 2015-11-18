package br.univel.Views;

import java.awt.BorderLayout;

public class TelaCadastroCategoria extends MolduraAbstract {

	
	
	public TelaCadastroCategoria() {
		super();
	}
	
	
	@Override
	protected void configuraConteudo() {
		super.add(new ConteudoCadastroCategoria(), BorderLayout.CENTER);
	}

}
