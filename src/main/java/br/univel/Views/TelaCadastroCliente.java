package br.univel.Views;

import java.awt.BorderLayout;

public class TelaCadastroCliente extends MolduraAbstract {

	public TelaCadastroCliente() {
		super();
	}
	
	@Override
	protected void configuraConteudo() {
		super.add(new ConteudoCadastroCliente(), BorderLayout.CENTER);
		
	}

}
