package graphic;

import java.io.PrintWriter;
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
	 * A medve véletlenszerû irányba lép egyet.
	 */
	@Override
	public void Step() {
			Random random = new Random();
			int dir = random.nextInt(4);
			while(field.GetNeighbour(Direction.values()[dir]) == null) {
				dir = random.nextInt(4);
			Move(Direction.values()[dir]);
		}
	}

	@Override
	public void Move(Direction d) {
		IceField newfield = field.GetNeighbour(d);
		if(newfield == null) {
			System.out.println("Can't go outside the map");
			return;
		}
		field.Remove(this);
		field = newfield;
		field.Accept(this);
		
	}
}
