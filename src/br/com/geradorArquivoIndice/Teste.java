package br.com.geradorArquivoIndice;

import java.io.IOException;

public class Teste {

	public static void main(String[] args) throws IOException {
		//new GeradorBinario().main(new String[]{"/home/daniel/Downloads/Aula3/cep_ordenado.dat","/home/daniel/Downloads/Aula3/indiceHash.dat"});
		new LeitorDeArquivo().main(new String[]{"/home/daniel/Downloads/Aula3/indiceHash.dat"});
	}
	
}
