package graphic;


public class Researcher extends Player {
	
	/**
	 * A kutató használja a képességét, mellyel felderít egy szomszédos mezőt.
	 */
	public Researcher() {
		maxTemperature = 4;
		temperature = 4;
		remainingActions = 0;
		isInWater = false;
		hasDivingGear = false;
	}
	
	public void UseAbility(Direction d) {
		IceField neighbour = field.GetNeighbour(d);
		if (neighbour == null)
			return;
		if(!neighbour.isCapacityRevealed()) {
			neighbour.RevealCapacity();
			remainingActions -= 1;
		}
		if(remainingActions <= 0) {
			game.NextPlayer();
		}
	}
	
}
