package src;

import java.io.*;

public class UserThread extends Thread {
	String fileName;
	StringBuffer line;

	public UserThread(String fileName) {
		this.fileName = fileName;
		line = new StringBuffer();
		System.out.println(fileName);
	}

	@Override
	public void run(){
		try
		{
			FileReader fr = new FileReader("./inputs/" + fileName);
			BufferedReader br = new BufferedReader(fr);
			String str;
			while((str = br.readLine()) != null)
			{
				this.line.append(str);
				String command = str.split(" ")[0];
				switch(command)
				{
					case ".save": 
						this.line.delete(0, this.line.length());
						saveFile(str.split(" ")[1], fileName, br);
						break;
					case ".print":
						new PrintJobThread(str.split(" ")[1]).start();
						break;
					default: 
						System.out.println("Unknown command: " + command); 
				}
				this.line.delete(0, this.line.length());
			}
			br.close();
		}
		catch (IOException e) { 
			e.printStackTrace();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	synchronized void saveFile(String name, String inputFile, BufferedReader br) throws InterruptedException
	{
		int diskNumber = Main.diskManager.request();
		int offset = Main.diskManager.nextFreeSector(diskNumber);
		int fileLines = 0;
		String str;
		try {
			while ((str = br.readLine()) != null) {
				this.line.append(str);
				if(str.equals(".end"))
				{
					Main.diskManager.directoryManager.enter(name, new FileInfo(diskNumber, offset, fileLines));
					break;
				}
				else {
					Main.disks[diskNumber].write(offset + fileLines, line);
					fileLines++; 
				}
				this.line.delete(0, this.line.length());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Main.diskManager.sectorOccupied(diskNumber, offset+fileLines);
		Main.diskManager.release(diskNumber);
	}
}