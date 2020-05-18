package graphic;


/*
 * Ezekbõl kell összegyûjteni mindhármat és használni egy helyen állva a játék megnyeréséhez.
 */
public class FlareGunPart extends Item {
	private Game game;
	
	/*
	 * Szól a Game-nek, hogy ellenõrizze a gyõzelem feltételeit. False-al tér vissza, ha nem teljesültek.
	 */
	public boolean Use(Player p) {
		return game.TryToWin();
	}
	
	/*
	 * True-val tér vissza.
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
