package src;

class PrintJobThread extends Thread{
	public StringBuffer pointer;
	int start;
	int d;
	
	public PrintJobThread(String file) {
		this.pointer = new StringBuffer();
		FileInfo f = Main.diskManager.directoryManager.lookup(file);
		start = f.startingSector;
		d = f.diskNumber;
		int PrinterNumber = Main.printerManager.request();
		for (int i=0;i<f.fileLength;i++) {
			Main.disks[d].read(start+i, pointer);
			Main.printers[PrinterNumber].print(pointer);
			pointer.delete(0, pointer.length());
		}
		Main.printerManager.release(PrinterNumber);
	}
}