package br.com.main;

import java.io.RandomAccessFile;

public class BuscaSequencial implements Buscador{

	@Override
	public void busca() throws Exception {
		RandomAccessFile f = new RandomAccessFile("/home/daniel/Downloads/Aula3/indiceHash.dat", "r");

		Endereco e = new Endereco();
		
		while( f.getFilePointer() < f.length() ) // para Detectar EOF
		{	
			e.leEndereco(f);
				System.out.println(f.getFilePointer());	
				System.out.println(e.getLogradouro());
				System.out.println(e.getBairro());
				System.out.println(e.getCidade());
				System.out.println(e.getEstado());
				System.out.println(e.getSigla());
				System.out.println(e.getCep());
				
				break;
			
		}
		
		f.close();
			
	}

}
