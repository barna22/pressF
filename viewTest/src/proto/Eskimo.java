package proto;

public class Eskimo extends Player {
	
	/**
	 * Az eszkimó használja a képességét, mellyel épít egy iglut.
	 */
	public Eskimo() {
		temperature = 5;
		remainingActions = 4;
		isInWater = false;
		hasDivingGear = false;
	}
	
	public void UseAbility(int d) {
		if(field.BuildIgloo())
			remainingActions -= 1;
		if(remainingActions <=0) {
			game.NextPlayer();
		}
	}
}