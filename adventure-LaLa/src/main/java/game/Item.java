package game;

public abstract class Item extends GameLocation
                           implements SetSelfOnMap {
	private String type;
	
	public Item (String type) {
		this.type = type;
		setLocation();
		setSelfOnMap();
	}
	
	public void setSelfOnMap() {
		Game.map[this.getY()][this.getX()] = this.type;
	}	
	public String getType() {
		return type;
	}
}
