package graphic;

public class Eskimo extends Player {
	
	
	public Eskimo() {
		maxTemperature = 5;
		temperature = 5;
		remainingActions = 0;
		isInWater = false;
		hasDivingGear = false;
	}
	/**
	 * Az eszkimó használja a képességét, mellyel épít egy iglut.
	 */
	public void UseAbility(Direction d) {
		if(field.BuildIgloo())
			remainingActions -= 1;
		if(remainingActions <=0) {
			game.NextPlayer();
		}
	}
}