package game;

import java.util.ArrayList;
import java.util.List;

public class Dragon extends Monster {
	public Dragon(String type) {
		super(type);
	}

	@Override
	public List<String> attack(Player p) {
		List<String> msgList = new ArrayList<>();
		if (this.getHp() <= 0) { return null; }
		msgList.add(this.getType() + "は口から火を噴いた。");
		int ap = (int)Math.floor(Math.random() * 31);
		p.setHp(p.getHp() - ap);
		msgList.add(p.getName() + "に" + ap + "ポイントのダメージ");
		if (p.getHp() <= 0) {
			msgList.add(p.getName() + "を倒した。");
		}
		return msgList;
	}

}
