package br.com.geradorArquivoIndice;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.charset.Charset;

public class LayoutArquivo implements Layout{
	protected byte cep[] = new byte[8];
	private long posicao;
	
	public LayoutArquivo(byte cep[] , long posicao){
		this.posicao = posicao;
		this.cep = cep;		
	}
	public LayoutArquivo(){
	
	}
	
	public byte[] getCep() {
		return cep;
	}
	public void setCep(byte cep[]) {
		this.cep = cep;
	}
	public long getPosicao() {
		return posicao;
	}
	public void setPosicao(long posicao) {
		this.posicao = posicao;
	}
	@Override
	public void readFields(DataInput input) throws IOException {
		Charset enc = Charset.forName("ISO-8859-1");
		input.readFully(cep);
		posicao = input.readLong();
		System.out.println("CEP : "+new String(cep,enc) +" - "+ " PONT : "+posicao);
		
	}
	@Override
	public void writeFields(DataOutput output) throws IOException {
		output.write(this.cep);
		output.writeLong(this.posicao);
		
	}

	
	
}
