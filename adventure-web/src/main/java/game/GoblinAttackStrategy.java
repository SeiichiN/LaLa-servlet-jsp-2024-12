package game;

public class GoblinAttackStrategy implements AttackStrategy {
	private final int MAXAP = 10;

	@Override
	public int getMAXAP() {
		return MAXAP;
	}

	@Override
	public String uniqueAttack() {
		return "口から火を噴いた。";
	}

}
