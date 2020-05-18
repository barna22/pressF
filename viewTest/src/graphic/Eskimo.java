package graphic;

public class Eskimo extends Player {
	
	/**
	 * Az eszkim� haszn�lja a k�pess�g�t, mellyel �p�t egy iglut.
	 */
	public Eskimo() {
		maxTemperature = 5;
		temperature = 5;
		remainingActions = 4;
		isInWater = false;
		hasDivingGear = false;
	}
	
	public void UseAbility(Direction d) {
		if(field.BuildIgloo())
			remainingActions -= 1;
		if(remainingActions <=0) {
			game.NextPlayer();
		}
	}
}