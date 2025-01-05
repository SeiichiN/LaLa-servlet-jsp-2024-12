package game;

public class AutoSetOnMap implements SetSelfOnMap {

	@Override
	public void setSelfOnMap(GameLocation obj, String type) {
		obj.getGame().getMap()[obj.getY()][obj.getX()] = type;
	}

}
