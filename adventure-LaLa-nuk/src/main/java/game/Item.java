package game;

public abstract class Item extends GameLocation {
	private String type;
	private SetSelfOnMap obj;
	
	public Item() {}
	public Item (String type, SetSelfOnMap obj) {
		this.type = type;
		this.obj = obj;
		setLocation();
		obj.setSelfOnMap(this, this.getType());
	}

	public String getType() {
		return type;
	}
}
