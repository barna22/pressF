package graphic;

import java.io.PrintWriter;
import java.util.Random;

public class IceBear extends Entity implements Steppable {

	/**
	 *Vihar esetÃ©n a medvÃ©vel nem tÃ¶rtÃ©nik semmi.
	 */
	@Override
	public void CaughtByStorm() {
	}

	/**
	 * A medve vÃ­zbe esik, ez azonban nem akadÃ¡lyozza a mozgÃ¡sban,
	 * Ã­gy nem tÃ¶rtÃ©nik semmi.
	 */
	@Override
	public void FallInWater(IceField field) {
		
	}
	
	/**
	 * A medve megÃ¶li a jÃ¡tÃ©kost akivel talÃ¡lkozik.
	 */
	public void Meet(Player player) {
		player.Die();
	}

	/**
	 * A medve vÃ©letlenszerÃ» irÃ¡nyba lÃ©p egyet.
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
