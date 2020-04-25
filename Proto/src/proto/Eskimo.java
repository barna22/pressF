package proto;

public class Eskimo extends Player {
	
	/**
	 * Az eszkimó használja a képességét, mellyel épít egy iglut.
	 */
	public void UseAbility(Direction d) {
		field.BuildIgloo();
		if(remainingActions <=0) {
			game.NextPlayer();
		}
	}
}