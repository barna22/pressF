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
	 * Az eszkim� haszn�lja a k�pess�g�t, mellyel �p�t egy iglut.
	 */
	public void UseAbility(Direction d) {
		if(field.BuildIgloo())
			remainingActions -= 1;
		if(remainingActions <=0) {
			game.NextPlayer();
		}
	}
}