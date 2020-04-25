package proto;

public class Eskimo extends Player {
	
	/**
	 * Az eszkim� haszn�lja a k�pess�g�t, mellyel �p�t egy iglut.
	 */
	public void UseAbility(Direction d) {
		field.BuildIgloo();
		if(remainingActions <=0) {
			game.NextPlayer();
		}
	}
}