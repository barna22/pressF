package graphic;


/*
 * Fel lehet haszn�lni a j�t�kost testh�j�nek n�vel�s�re.
 */
public class Food extends Item {
	
	/*
	 * A j�t�kos testh�j�t n�veli. True-val t�r vissza
	 */
	public boolean Use(Player p) {
		p.ChangeTemperature(1); 
		p.RemoveItem(this);
		return true;
	}
	
	/*
	 * True-val t�r vissza.
	 */
	public boolean IsTheSame(Food f) {
		return true;
	}
}
