package graphic;


/*
 * A haszn�lhat� t�rgyak heterog�n kollekci�ja.
 */
public class Item {
	/*
	 * A kapott j�t�kos haszn�lja a t�rgyat. True-val t�r vissza, ha
	 * siker�lt.
	 */
	protected ItemView view;
	
	public boolean Use(Player p) {
		return false;
	}
	
	/*
	 * A kapott player felveszi a t�rgyat. Ha siker�l True-val t�r
	 * vissza.
	 */
	public boolean Equip(Player p) {
		return p.AddItem(this);
	}
	
	/*
	 * False-al t�r vissza. A lesz�rmazottaknak van egy ugyan
	 * ilyen nev� f�ggv�ny�k, amiben magukb�l vesznek �t egy p�ld�nyt param�terk�nt �s
	 * azok true-val t�rnek vissza. �gy meg lehet n�zni, hogy a kapott item ugyanolyan fajtae, mint ez.
	 */
	public boolean IsTheSame(Item i) {
		return false;
	}
	
	public ItemView GetView() {
		return view;
	}
	
	public void SetView(ItemView iv) {
		view = iv;
	}
}
