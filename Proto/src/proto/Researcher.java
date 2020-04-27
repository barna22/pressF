package proto;


public class Researcher extends Player {
	
	/**
	 * A kutató használja a képességét, mellyel felderít egy szomszédos mezőt.
	 */
	public Researcher() {
		temperature = 4;
		remainingActions = 4;
		isInWater = false;
		hasDivingGear = false;
	}
	
	public void UseAbility(int d) {
		field.GetNeighbour(d).RevealCapacity();
		remainingActions -= 1;
		if(remainingActions <= 0) {
			game.NextPlayer();
		}
	}
	
}
