package br.com.geradorArquivoIndice;

import java.io.DataInput;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeArquivoBinario {
	
	private Layout layout;

	public LeArquivoBinario definedLayout(Layout layout){
		this.layout = layout;
		return this;
	}

	public Layout ler(DataInput dataInput){
	
		try {
			layout.readFields(dataInput);
			return layout;
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return layout;
	}
}
