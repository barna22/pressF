package szkeleton;


/*
 * A haszn�lhat� t�rgyak heterog�n kollekci�ja.
 */
public class Item {
	/*
	 * A kapott j�t�kos haszn�lja a t�rgyat. True-val t�r vissza, ha
	 * siker�lt.
	 */
	public boolean Use(Player p) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".IsTheSame(" + Skeleton.GetName(p) + ")");
		return false;
	}
	
	/*
	 * A kapott player felveszi a t�rgyat. Ha siker�l True-val t�r
	 * vissza.
	 */
	public boolean Equip(Player p) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Equip(" + Skeleton.GetName(p) + ")");
		boolean result;
		MethodPrinter.IncreaseIndentation();
		result =  p.AddItem(this);
		MethodPrinter.DecreaseIndentation();
		return result;
	}
	
	/*
	 * False-al t�r vissza. A lesz�rmazottaknak van egy ugyan
	 * ilyen nev� f�ggv�ny�k, amiben magukb�l vesznek �t egy p�ld�nyt param�terk�nt �s
	 * azok true-val t�rnek vissza. �gy meg lehet n�zni, hogy a kapott item ugyanolyan fajtae, mint ez.
	 */
	public boolean IsTheSame(Item i) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".IsTheSame(" + Skeleton.GetName(i) + ")");
		return false;
	}
}
