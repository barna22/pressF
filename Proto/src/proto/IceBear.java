package proto;

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
		if (ConsoleApp.GetRandom()) {
			Random random = new Random();
			int dir = random.nextInt(field.GetNumberOfNeighbours());
			while(field.GetNeighbour(dir) == null) {
				dir = random.nextInt(field.GetNumberOfNeighbours());
			}
			Move(dir);
		}
	}

	public void PrintInfo() {
		System.out.println(ConsoleApp.GetName(field));
	}
}
