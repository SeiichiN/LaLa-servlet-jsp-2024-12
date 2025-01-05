package game;

public class Dragon extends Monster {
	public Dragon(String type, SetSelfOnMap setSelfObj) {
		super(type, setSelfObj);
	}

	@Override
	public void attack(Player p) {
		if (this.getHp() <= 0) { return; }
		System.out.println(this.getType() + "は口から火を噴いた。");
		int ap = (int)Math.floor(Math.random() * 31);
		p.setHp(p.getHp() - ap);
		System.out.println(p.getName() + "に" + ap + "ポイントのダメージ");
		if (p.getHp() <= 0) {
			System.out.println(p.getName() + "を倒した。");
		}
	}

}
