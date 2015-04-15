package br.com.geradorArquivoIndice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeitorDeArquivo {
	
	public static void main(String[] args) {
		
		
		if(args.length < 1){
				
				System.out.println("Error!! Não foram informados os parâmetros para geração do arquivo.");
				System.out.println(" Exemplo : java LeitorDeArquivo /home/daniel/...(arquivo alvo) ");
				
				System.exit(0);
		}
		
		try {
			RandomAccessFile randomAcess = new RandomAccessFile(new File(args[0]),"r");
			int leituras = 0;
			System.out.println("Lendo o arquivo ...");
			System.out.println("###################");
			
			while(randomAcess.getFilePointer() <  randomAcess.length()){
				LeArquivoBinario leiArquivoBinario = new LeArquivoBinario();
				leiArquivoBinario.definedLayout(new LayoutArquivo()).ler(randomAcess);
				leituras++;
			}
			System.out.println("###################");
			System.out.println("Fim do arquivo");
			System.out.println("Total das leituras : "+leituras);
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		
		
	}

}
