package br.com.geradorArquivoIndice;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.charset.Charset;
import br.com.geradorArquivoIndice.Layout;

public class Endereco implements Layout{
	
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;
	private String sigla;
	private String cep;
	private long position;

	public void leEndereco(DataInput din) throws IOException
	{
		byte logradouro[] = new byte[72];
		byte bairro[] = new byte[72];
		byte cidade[] = new byte[72];
		byte estado[] = new byte[72];
		byte sigla[] = new byte[2];
		byte cep[] = new byte[8];
		
		


		din.readFully(logradouro);
		din.readFully(bairro);
		din.readFully(cidade);
		din.readFully(estado);
		din.readFully(sigla);
		din.readFully(cep);
		din.readByte(); // Ultimo espaco em branco 
		din.readByte(); // Quebra de linha
		
		// Definie a forma como caracteres especias estão codificados.
		Charset enc = Charset.forName("ISO-8859-1");
		
		this.logradouro = new String(logradouro,enc);
		this.bairro = new String(bairro,enc);
		this.cidade = new String(cidade,enc);
		this.estado = new String(estado,enc);
		this.sigla = new String(sigla,enc);
		this.cep = new String(cep,enc);
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getBairro() {
		return bairro;
	}
			
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public void readFields(DataInput input) throws IOException {
		leEndereco(input);
		
	}

	@Override
	public void writeFields(DataOutput output) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printFields() {
		
		System.out.println( "Logradouro : "+this.logradouro);
		System.out.println( "Bairro : "+this.bairro);
		System.out.println( "Cidade : "+this.cidade);
		System.out.println( "Estado : "+this.estado);
		System.out.println( "Sigle : "+this.sigla);
		System.out.println( "CEP : "+this.cep);
		System.out.println( "Posicao : "+this.position);
	}

	@Override
	public long getPosition() {
		return this.position;
	}

	public void setPosition(long position){
		this.position = position;
		
	}
	@Override
	public int lengthLine() {
		return 300;
	}

}
