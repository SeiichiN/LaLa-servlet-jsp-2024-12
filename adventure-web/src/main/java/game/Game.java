package game;

import java.util.HashMap;
import java.util.Map;

public class Game {
	public static final int YSIZE = 5;
	public static final int XSIZE = 5;
	public static String[][] map = {
			{".", ".", ".", ".", "."},
			{".", ".", ".", ".", "."},
			{".", ".", "#", "#", "."},
			{".", ".", ".", ".", "."},
			{".", ".", ".", ".", "."}
	}; 
	
	public static void initMap() {
		map = new String[][]{
				{".", ".", ".", ".", "."},
				{".", ".", ".", ".", "."},
				{".", ".", "#", "#", "."},
				{".", ".", ".", ".", "."},
				{".", ".", ".", ".", "."}
		};		
	}
	
	public static String getJa(String word) {
		String jaword = switch(word) {
		case "goblin" -> "ゴブリン";
		case "dragon" -> "ドラゴン";
		case "potion" -> "ポーション";
		case "ether" -> "エーテル";
		default -> "";
		};
		return jaword;
	}
}
