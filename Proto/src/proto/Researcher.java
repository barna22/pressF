package proto;


public class Researcher extends Player {
	
	/**
	 * A kutató használja a képességét, mellyel felderít egy szomszédos mezőt.
	 */
	public void UseAbility(Direction d) {
		IceField researchedfield = field.GetNeighbour(d);
		researchedfield.RevealCapacity();
		if(remainingActions <= 0) {
			game.NextPlayer();
		}
	}
	
}
