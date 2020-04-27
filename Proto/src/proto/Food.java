package proto;


/*
 * Fel lehet használni a játékost testhõjének növelésére.
 */
public class Food extends Item {
	
	/*
	 * A játékos testhõjét növeli. True-val tér vissza
	 */
	public boolean Use(Player p) {
		//ChangeTemperature függvénynek nem hozzáadni kellene értéket és -1-t átadni CaughtbyStorm-nál?
		p.ChangeTemperature(1); //Visszatérési érték boolean?
		return true;
	}
	
	/*
	 * True-val tér vissza.
	 */
	public boolean IsTheSame(Food f) {
		return true;
	}
}
