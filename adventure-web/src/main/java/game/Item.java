package game;

public abstract class Item extends GameLocation
                           implements SetSelfOnMap {
	private String type;
	private String jaType;
	
	public Item (String type) {
		this.type = type;
		this.jaType = Game.getJa(type);
		setLocation();
		setSelfOnMap();
	}
	
	public void setSelfOnMap() {
		Game.map[this.getY()][this.getX()] = this.type;
	}	
	public String getType() {
		return type;
	}

	public String getJaType() {
		return jaType;
	}

	@Override
	public String toString() {
		return type;
	}
}
