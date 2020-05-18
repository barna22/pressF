package graphic;


/*
 * Ezekb�l kell �sszegy�jteni mindh�rmat �s haszn�lni egy helyen �llva a j�t�k megnyer�s�hez.
 */
public class FlareGunPart extends Item {
	private Game game;
	
	/*
	 * Sz�l a Game-nek, hogy ellen�rizze a gy�zelem felt�teleit. False-al t�r vissza, ha nem teljes�ltek.
	 */
	public boolean Use(Player p) {
		return game.TryToWin();
	}
	
	/*
	 * True-val t�r vissza.
	 */

	public boolean Equip(Player p) {
		super.Equip(p);
		game.GunPartFound();
		return true;
	}
	
	public void SetGame(Game g) {
		game = g;
	}
}
