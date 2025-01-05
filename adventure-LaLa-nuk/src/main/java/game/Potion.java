package game;

public class Potion extends Item {
	private int rp = 100;
	
	public Potion(String type, SetSelfOnMap obj) {
		super(type, obj);
	}
	
	public int getRp() {
		return this.rp;
	}
}
