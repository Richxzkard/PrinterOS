package src;

class Disk {
	static final int NUM_SECTORS = 1024;
	StringBuffer sectors[] = new StringBuffer[NUM_SECTORS];
	
	public Disk() {
		for (int i=0; i < NUM_SECTORS; i++) {
			sectors[i] = new StringBuffer();
		}
	}
	
	void write(int sector, StringBuffer data) {
		try {
			Thread.sleep(200);
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
		sectors[sector].append(data);
	}
	
	void read(int sector, StringBuffer data) {
		try {
			Thread.sleep(200);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		data.append(sectors[sector]);
	}
}
