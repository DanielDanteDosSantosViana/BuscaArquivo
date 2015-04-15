package br.com.geradorArquivoIndice;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class GeraArquivoBinario {
	private File arquivoAlvo;
	private File arquivoNovo;
	private EscreveArquivoBinario write;
	private LeArquivoBinario lerArquivoBinario;
	
	public GeraArquivoBinario configurarGerador(File arquivoAlvo , File arquivoNovo){
		this.arquivoAlvo = arquivoAlvo;
		this.arquivoNovo = arquivoNovo;
		
		write = new EscreveArquivoBinario(this.arquivoNovo);
		lerArquivoBinario = new LeArquivoBinario();
		
		return this;
	}
	
	public void gera() throws IOException{
		RandomAccessFile f = new RandomAccessFile(arquivoAlvo, "r");
		int totalWrites = 0;
		
		System.out.println("Gerando o arquivo de Indice...");
		System.out.println("##############");
		while(f.getFilePointer() < f.length()){
			
			Endereco endereco = (Endereco) lerArquivoBinario.definedLayout(new Endereco()).ler(f);
			System.out.println("CEP: "+endereco.getCep()+" - "+"PONT :"+f.getFilePointer());
			
			LayoutArquivo arquivo = montaLayout(f, endereco);
			write.escreve(arquivo);
			totalWrites++;
			
		}
		
		f.close();
		write.fechaStream();
		System.out.println("##############");
		System.out.println("Fim do arquivo");
		System.out.println("Total de escritas : "+totalWrites);
		
		
		

	}

	private LayoutArquivo montaLayout(RandomAccessFile f, Endereco endereco)
			throws IOException {
		LayoutArquivo arquivo = new LayoutArquivo();
		arquivo.setCep(endereco.getCep().getBytes());
		arquivo.setPosicao(f.getFilePointer());
		return arquivo;
	}
}
