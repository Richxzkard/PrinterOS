package src;

public class DiskManager extends ResourceManager{
	
	public DirectoryManager directoryManager;
	private int[] disks;
	
	public DiskManager(int numberofDisk) {
		super(numberofDisk);
		this.disks = new int[numberofDisk];
		for (int i=0;i<disks.length;i++) {
			disks[i] = 0;
		}
		this.directoryManager = new DirectoryManager();
	}
	
	public int nextFreeSector(int diskNumber) {
		return disks[diskNumber];
	}
	
	public void sectorOccupied(int diskNumber, int n) {
		disks[diskNumber] = n;
	}
	
	
}