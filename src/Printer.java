package src;

import java.io.BufferedWriter;
import java.io.*;

class Printer {
	private File outputFile;
	private int index;
	
	public Printer(int i) {
		this.index = i;
		this.outputFile = new File("PRINTER" + this.index);
		try {
			outputFile.createNewFile();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
	void print(StringBuffer data) {
		try {
			Thread.sleep(2750);
			FileWriter fr = new FileWriter(outputFile, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write(data.toString());
			br.newLine();
			br.flush();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
