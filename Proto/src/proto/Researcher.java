package proto;


public class Researcher extends Player {
	
	/**
	 * A kutató használja a képességét, mellyel felderít egy szomszédos mezőt.
	 */
	public void UseAbility(Direction d) {
		field.GetNeighbour(d).RevealCapacity();
		if(remainingActions <= 0) {
			game.NextPlayer();
		}
	}
	
}
