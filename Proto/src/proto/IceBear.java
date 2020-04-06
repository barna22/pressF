package proto;

public class IceBear extends Entity implements Steppable {

	/**
	 *Vihar eset�n a medv�vel nem t�rt�nik semmi.
	 */
	@Override
	public void CaughtByStorm() {
		
	}

	/**
	 * A medve v�zbe esik, ez azonban nem akad�lyozza a mozg�sban,
	 * �gy nem t�rt�nik semmi.
	 */
	@Override
	public void FallInWater() {
		
	}
	
	/**
	 * A medve meg�li a j�t�kost akivel tal�lkozik.
	 */
	public void Meet(Player player) {
		Player.Die();
	}

	/**
	 * A medve v�letlenszer� ir�nyba l�p egyet.
	 */
	@Override
	public void Step() {
		
	}

}
