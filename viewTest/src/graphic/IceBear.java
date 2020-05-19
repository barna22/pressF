package graphic;

import java.util.Random;

public class IceBear extends Entity implements Steppable {

	/**
	 *Vihar esetén a medvével nem történik semmi.
	 */
	@Override
	public void CaughtByStorm() {
	}

	/**
	 * A medve vízbe esik, ez azonban nem akadályozza a mozgásban,
	 * így nem történik semmi.
	 */
	@Override
	public void FallInWater(IceField field) {
		
	}
	
	/**
	 * A medve megöli a játékost akivel találkozik.
	 */
	public void Meet(Player player) {
		player.Die();
	}

	/**
	 * A medve véletlenszerű irányba lép egyet.
	 */
	@Override
	public void Step() {
		Random random = new Random();
		int dir = random.nextInt(4);
		while(field.GetNeighbour(Direction.values()[dir]) == null) {
			dir = random.nextInt(4);
		}
		Move(Direction.values()[dir]);
	}

	/**
	 * A medve a kapott irányba lép, és az előző mezőről leveszi magát.
	 */
	@Override
	public void Move(Direction d) {
		IceField newfield = field.GetNeighbour(d);
		if(newfield == null) {
			return;
		}
		field.Remove(this);
		field = newfield;
		field.Accept(this);
		
	}
}
