package proto;

public class Eskimo extends Player {
	
	/**
	 * Az eszkim� haszn�lja a k�pess�g�t, mellyel �p�t egy iglut.
	 */
	public void UseAbility(int d) {
		field.BuildIgloo();
		remainingActions -= 1;
		if(remainingActions <=0) {
			game.NextPlayer();
		}
	}
}