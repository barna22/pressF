package proto;


public class Researcher extends Player {
	
	/**
	 * A kutató használja a képességét, mellyel felderít egy szomszédos mezőt.
	 */
	public void UseAbility(int d) {
		field.GetNeighbour(d).RevealCapacity();
		remainingActions -= 1;
		if(remainingActions <= 0) {
			game.NextPlayer();
		}
	}
	
}
