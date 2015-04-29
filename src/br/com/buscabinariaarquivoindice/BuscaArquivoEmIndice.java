package br.com.buscabinariaarquivoindice;

import br.com.buscabinariaemarquivocep.BuscaBinaria;
import br.com.buscabinariaemarquivocep.BuscaPorPosicaoEmArquivo;
import br.com.buscabinariaemarquivocep.Buscador;
import br.com.geradorArquivoIndice.Endereco;
import br.com.geradorArquivoIndice.Layout;
import br.com.geradorArquivoIndice.LayoutArquivo;

public class BuscaArquivoEmIndice {

	public static void main(String[] args) throws Exception {
		Buscador buscaBinaria = new BuscaBinaria();
		Layout layoutArquivo = new LayoutArquivo();
		buscaBinaria.busca(layoutArquivo);
		Buscador buscaPorPosicaoEmArquivo = new BuscaPorPosicaoEmArquivo();
		Layout layoutEndereco = new Endereco();
		layoutEndereco.setPosition(buscaBinaria.posicaoNoArquivo());
		buscaPorPosicaoEmArquivo.busca(layoutEndereco);
	}
}
