package game;

public class DragonAttackStrategy implements AttackStrategy {
	public final int MAXAP = 30;

	@Override
	public String uniqueAttack() {
		return "口から火を噴いた。";
	}

	@Override
	public int getMAXAP() {
		return MAXAP;
	}

}
