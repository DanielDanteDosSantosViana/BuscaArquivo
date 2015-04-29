package br.com.buscabinariaemarquivocep;

import br.com.geradorArquivoIndice.Layout;


public interface Buscador {

	public void busca(Layout layout) throws Exception;
	public long posicaoNoArquivo();
}
