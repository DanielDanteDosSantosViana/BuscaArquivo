package br.com.geradorArquivoIndice;

import java.io.File;
import java.io.IOException;

public class GeradorBinario {
	public static void main(String[] args) throws IOException {
		GeraArquivoBinario geradorBinario = new GeraArquivoBinario();
		
		if(args.length < 2){
			
			System.out.println("Error!! Não foram informados os parâmetros para geração do arquivo.");
			System.out.println(" Exemplo : java GeradorBinario /home/daniel/...(arquivo alvo) /home/...(arquivo novo)");
			
			System.exit(0);
		}
		
		File arquivoAlvo = new File(args[0]);
		File arquivoNovo = new File(args[1]);
		
		geradorBinario.configurarGerador(arquivoAlvo, arquivoNovo).gera();
	
		
	}
	

}
