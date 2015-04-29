package br.com.buscabinariaemarquivocep;

import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

import br.com.geradorArquivoIndice.Layout;

public class BuscaSequencial implements Buscador{

	@Override
	public void busca(Layout layout) throws Exception {

		String caminhoArquivo = JOptionPane.showInputDialog("Digite o caminho do arquivo : ");
		RandomAccessFile f;
		if(caminhoArquivo!=null && !caminhoArquivo.isEmpty()){
		   f = new RandomAccessFile(caminhoArquivo, "r");
		}else{
			throw new Error("Caminho do arquivo não informado!");
		}
		
		String identificacao = JOptionPane.showInputDialog("Entre com sua identificacao para busca sequencial no arquivo : ");
		
		
		while( f.getFilePointer() < f.length() ) // para Detectar EOF
		{
				layout.readFields(f);
				if(identificacao.equals(layout.getId().toString())){
					layout.printFields();
					break;
				}
				
		}
		
		f.close();
			
	}

	@Override
	public long posicaoNoArquivo() {
		// TODO Auto-generated method stub
		return 0;
	}

}
