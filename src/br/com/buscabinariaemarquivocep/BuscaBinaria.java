package br.com.buscabinariaemarquivocep;

import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

import br.com.geradorArquivoIndice.Layout;

public class BuscaBinaria implements Buscador {

	private long posicaoArquivo;
	
	public void busca(Layout layout) throws Exception {
		
		String caminhoArquivo = JOptionPane.showInputDialog("Digite o caminho do arquivo : ");
		RandomAccessFile f;
		if(caminhoArquivo!=null && !caminhoArquivo.isEmpty()){
		   f = new RandomAccessFile(caminhoArquivo, "r");
		}else{
			throw new Error("Caminho do arquivo não informado!");
		}
		String cepBusca = JOptionPane.showInputDialog("Entre com seu cep : ");
		
		Long inicio = new Long(0);
		Long fim = f.length()/layout.lengthLine();
		
		
		
		while( inicio <= fim ) // para Detectar EOF
		{
			Long meio = (inicio + fim )/2;
			f.seek(meio*layout.lengthLine());
			layout.readFields(f);
			
			if(cepBusca.equals(layout.getId())){
				layout.printFields();
				this.posicaoArquivo = layout.getPosition();
				f.close();
				break;
			}
			if(Long.parseLong(cepBusca) > Long.parseLong(layout.getId())){
				
				inicio = meio +1;
			
			}else{
				fim = meio -1;
			}
			
		}
		
		f.close();
	}

	@Override
	public long posicaoNoArquivo() {
		return posicaoArquivo;
	}

}
