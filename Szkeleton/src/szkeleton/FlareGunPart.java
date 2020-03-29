package szkeleton;


/*
 * Ezekb�l kell �sszegy�lyteni mindh�rmat �s haszn�lni egy helyen �llva a j�t�k megnyer�s�hez.
 */
public class FlareGunPart extends Item {
	private Game game;
	
	/*
	 * Megn�zi, hogy teljes�lnek-e a gy�zelem felt�telei �s jelez a
	 * Game-nek, ha igen. True-val t�r vissza, ha siker�lt haszn�lni.
	 */
	public boolean Use(Player p) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Use(" + Skeleton.GetName(p) + ")");
		MethodPrinter.IncreaseIndentation();
		IceField f = p.GetField();
		boolean result = false;
		if(game.IsEveryoneHere(f))
			result = f.CountGunParts(this);
		MethodPrinter.DecreaseIndentation();
		return result;
	}
	
	/*
	 * True-val t�r vissza.
	 */
	public boolean IsTheSame(FlareGunPart f) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".IsTheSame(" + Skeleton.GetName(f) + ")");
		return true;
	}
}
