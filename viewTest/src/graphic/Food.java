package graphic;


/*
 * Fel lehet használni a játékost testhõjének növelésére.
 */
public class Food extends Item {
	
	/*
	 * A játékos testhõjét növeli. True-val tér vissza
	 */
	public boolean Use(Player p) {
		p.ChangeTemperature(1); 
		p.RemoveItem(this);
		return true;
	}
	
	/*
	 * True-val tér vissza.
	 */
	public boolean IsTheSame(Food f) {
		return true;
	}
}
