package br.com.main;

import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

public class BuscaBinaria implements Buscador {

	public void busca() throws Exception {
		
		RandomAccessFile f = new RandomAccessFile("/home/daniel/Downloads/Aula3/cep_ordenado.dat", "r");
		Endereco e = new Endereco();
		
		String cepBusca = JOptionPane.showInputDialog("Entre com seu cep : ");
		
		Long inicio = new Long(0);
		Long fim = f.length()/300;
		
		
		
		while( inicio <= fim ) // para Detectar EOF
		{
			Long meio = (inicio + fim )/2;
			f.seek(meio*300);
			e.leEndereco(f);
			
			if(cepBusca.equals(e.getCep())){
				System.out.println(f.getFilePointer());	
				System.out.println(e.getLogradouro());
				System.out.println(e.getBairro());
				System.out.println(e.getCidade());
				System.out.println(e.getEstado());
				System.out.println(e.getSigla());
				System.out.println(e.getCep());
				f.close();
				break;
			}
			if(Long.parseLong(cepBusca) > Long.parseLong(e.getCep())){
				
				inicio = meio +1;
			
			}else{
				fim = meio -1;
			}
			
		}
		
		f.close();
	}

}
