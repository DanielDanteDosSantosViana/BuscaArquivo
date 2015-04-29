package br.com.buscabinariaemarquivocep;

import br.com.geradorArquivoIndice.Layout;
import br.com.geradorArquivoIndice.LayoutArquivo;


public class Main {

	public static void main(String[] args) throws Exception {
	
		//Buscador buscador = new BuscaSequencial();
		Buscador buscador = new BuscaSequencial();
		Layout layout = new LayoutArquivo();
		buscador.busca(layout);
	}
}
