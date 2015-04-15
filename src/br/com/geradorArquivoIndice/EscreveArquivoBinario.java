package br.com.geradorArquivoIndice;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EscreveArquivoBinario {
	
	private  DataOutput dataOutput = null;
	private  OutputStream outputStream = null;
	private File file;
	
	
	public EscreveArquivoBinario(File file){
		this.file = file;
		
		try{
			abreStream();
		}catch (FileNotFoundException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	
	private void abreStream() throws FileNotFoundException{
		outputStream = new FileOutputStream(file);
		dataOutput = new DataOutputStream(outputStream);

	}
	
	public  void escreve(LayoutArquivo layoutArquivo){
		try {
			
			layoutArquivo.writeFields(this.dataOutput);
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	
	public void fechaStream(){
		try{
			outputStream.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
}
