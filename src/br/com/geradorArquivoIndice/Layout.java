package br.com.geradorArquivoIndice;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public interface Layout {

	 void readFields(DataInput input) throws IOException;
	 void writeFields(DataOutput output) throws IOException;
	 String getId();
	 void printFields();
	 long getPosition();
	 void setPosition(long position);
	 int lengthLine();
}
