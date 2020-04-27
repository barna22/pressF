package proto;


/*
 * Fel lehet haszn�lni a j�t�kost testh�j�nek n�vel�s�re.
 */
public class Food extends Item {
	
	/*
	 * A j�t�kos testh�j�t n�veli. True-val t�r vissza
	 */
	public boolean Use(Player p) {
		//ChangeTemperature f�ggv�nynek nem hozz�adni kellene �rt�ket �s -1-t �tadni CaughtbyStorm-n�l?
		p.ChangeTemperature(1); //Visszat�r�si �rt�k boolean?
		return true;
	}
	
	/*
	 * True-val t�r vissza.
	 */
	public boolean IsTheSame(Food f) {
		return true;
	}
}
