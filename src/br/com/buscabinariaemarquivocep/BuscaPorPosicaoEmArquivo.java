package br.com.buscabinariaemarquivocep;

import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

import br.com.geradorArquivoIndice.Layout;

public class BuscaPorPosicaoEmArquivo implements Buscador{

	@Override
	public void busca(Layout layout) throws Exception {
		String caminhoArquivo = JOptionPane.showInputDialog("Digite o caminho do arquivo cep ordenado: ");
		RandomAccessFile f;
		if(caminhoArquivo!=null && !caminhoArquivo.isEmpty()){
		   f = new RandomAccessFile(caminhoArquivo, "r");
		}else{
			throw new Error("Caminho do arquivo não informado!");
		}
		long posicaoDoArquivo = layout.getPosition();
		
		f.seek(posicaoDoArquivo);
		
		layout.readFields(f);
		layout.printFields();
		
	}

	@Override
	public long posicaoNoArquivo() {
		return 0;
	}

}
