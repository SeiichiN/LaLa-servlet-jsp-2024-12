package game;

public class Ether extends Item {
	private int rmp = 100;
	
	public Ether(String type, SetSelfOnMap obj) {
		super(type, obj);
	}
	
	public int getRmp() {
		return this.rmp;
	}
}
