package game;

public class Goblin extends Monster {
	public Goblin(String type) {
		super(type);
	}

	@Override
	public void attack(Player p) {
		if (this.getHp() <= 0) { return; }		
		System.out.println(this.getType() + "は斧で切りつけた。");
		int ap = (int)Math.floor(Math.random() * 11);
		p.setHp(p.getHp() - ap);
		System.out.println(p.getName() + "に" + ap + "ポイントのダメージ");
		if (p.getHp() <= 0) {
			System.out.println(p.getName() + "を倒した。");
		}
	}
}
