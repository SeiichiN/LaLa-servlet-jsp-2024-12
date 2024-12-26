package game;

public class Ether extends Item {
	private int rmp = 100;
	
	public Ether(String type) {
		super(type);
	}
	
	public int getRmp() {
		return this.rmp;
	}
}
