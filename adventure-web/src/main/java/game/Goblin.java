package game;

import java.util.ArrayList;
import java.util.List;

public class Goblin extends Monster {
	public Goblin(String type) {
		super(type);
	}

	@Override
	public List<String> attack(Player p) {
		List<String> msgList = new ArrayList<>();
		if (this.getHp() <= 0) {
			Game.map[this.getY()][this.getX()] = ".";
			return null; 
		}		
		msgList.add(this.getJaType() + "は斧で切りつけた。");
		int ap = (int)Math.floor(Math.random() * 11);
		p.setHp(p.getHp() - ap);
		msgList.add(p.getName() + "に" + ap + "ポイントのダメージ");
		if (p.getHp() <= 0) {
			msgList.add(p.getName() + "を倒した。");
		}
		return msgList;
	}
}
