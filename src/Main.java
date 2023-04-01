package src;

public class Main{
	public static int NUM_USERS;
	public static int NUM_DISKS = 2;
	public static int NUM_PRINTERS = 3;
	
	public static Disk[] disks;
	public static Printer[] printers;
	public static UserThread[] users;
	
	public static DiskManager diskManager;
	public static PrinterManager printerManager;
	
	
	public static void main(String[] args) {
		//construct users
		NUM_USERS = Integer.valueOf(args[0].substring(1));
		users = new UserThread[NUM_USERS];
		for (int i=0; i<NUM_USERS; i++) {
			users[i] = new UserThread(args[i+1]);
		}
		
		//construct disks
		disks = new Disk[NUM_DISKS];
		for (int i=0; i<NUM_DISKS; i++) {
			disks[i] = new Disk();
		}
		
		
		//construct printers
		printers = new Printer[NUM_PRINTERS];
		for (int i=0; i<NUM_PRINTERS; i++) {
			printers[i] = new Printer(i+1);
		}
		
		//construct diskManager
		diskManager = new DiskManager(NUM_DISKS);
		
		//construct printerManager;
		printerManager = new PrinterManager(NUM_PRINTERS);
		
		for (int i=0; i<NUM_USERS; i++) {
			users[i].start();
		}
		
		
	}
}