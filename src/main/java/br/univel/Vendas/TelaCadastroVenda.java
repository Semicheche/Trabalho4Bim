package br.univel.Vendas;

import java.awt.BorderLayout;


public class TelaCadastroVenda extends MolduraAbstract {
	
	public TelaCadastroVenda() {
		super();
	}

	@Override
	protected void configuraConteudo() {
		super.add(new ConteudoCadastroVenda(), BorderLayout.CENTER);

	}

}
