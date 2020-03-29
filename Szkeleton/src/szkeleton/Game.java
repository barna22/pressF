package szkeleton;
import java.util.ArrayList;

/**
 * Inicializálja a játék elemeit és nyilvántartja a játék állapotát.
 *
 */
public class Game {

	private ArrayList<IceField> fields;
	private ArrayList<Player> players;
	private Player activePlayer;
	

	Game(){
		players = new ArrayList<Player>();
		fields = new ArrayList<IceField>();
	}
	/**
	 * Megnézi, hogy mindenki az átvett fielden áll e.
	 */
	private void Storm() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Storm()");
		MethodPrinter.IncreaseIndentation();
		for(IceField f : fields){
			f.Storm();
		}
		MethodPrinter.DecreaseIndentation();
	}
	
	/**
	 * Megnézi, hogy teljesülnek-e a gyõzelem feltételei és ha igen, akkor a játékosok nyertek.
	 * @param f: a vizsgált IceField
	 * @return	 False, mert a flare
	 */
	public boolean CheckWinCondition(IceField f) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".CheckWinCondition(" + Skeleton.GetName(f) + ")");
		MethodPrinter.IncreaseIndentation();
		for(IceField field : fields)
			field.GetNumberOfPlayers();
		MethodPrinter.DecreaseIndentation();
		boolean result = MethodPrinter.AskQuestion("Mindenki ezen a mezõn áll?") && MethodPrinter.AskQuestion("Az összes alkatrész ki van ásva?");
		if(result) {
			MethodPrinter.IncreaseIndentation();
			Over(true);
			MethodPrinter.DecreaseIndentation();
		}
		return result;
	}
	
	/**
	 * Befejezi a játékot. Ha a paraméter true, akkor a játékosok nyertek.
	 * @param victory True/false: a játékosok nyertek/vesztettek.
	 */
	public void Over(boolean victory) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Over(" + victory + ")");
	}
	
	/**
	 * A kör végén megnézi, hogy vízbe van-e esve valaki.
	 * Ha igen, akkor a játéknak vége.
	 * Vihart indít az IceFieldeken.
	 */
	private void RoundOver() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".RoundOver()");
		if(MethodPrinter.AskQuestion("Van valaki vízbe esve?")) {
			MethodPrinter.IncreaseIndentation();
			Over(false);
			MethodPrinter.DecreaseIndentation();
		}
		MethodPrinter.IncreaseIndentation();
		Storm();
		MethodPrinter.DecreaseIndentation();
	}
	
	/**
	 * Átállítja, hogy ki az aktuális jázékos és átállítja a hátralevõ akcióit 4-re.
	 * Ha vége egy körnek, akkor meghívja a RoundOver()-t.
	 */
	public void NextPlayer() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".NextPlayer()");
		int idx = players.indexOf(activePlayer);
		if( idx == players.size()-1 ) {
			MethodPrinter.IncreaseIndentation();
			RoundOver();
			MethodPrinter.DecreaseIndentation();
			idx = 0;
		}
		else
			idx++;
		MethodPrinter.IncreaseIndentation();
		players.get(idx).SetRemainingActions(4);
		MethodPrinter.DecreaseIndentation();
	}
	
	/**
	 * Ezzel lehet jelezni, hogy egy játékost kimentettek a vízbõl.
	 */
	public void PlayerSaved() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".PlayerSaved()");
		
	}
	
	/**
	 * Ezzel lehet jelezni, hogy egy játékost beleesett a vízbe.
	 */
	public void PlayerFellInWater() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".PlayerFellInWater()");
	}
	
	/**
	 * Ezzel lehet jelezni, hogy megtalálták a jelzõpisztoly egyik alkatrészét.
	 */
	public void FlareGunPartFound() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".FlareGunPartFound()");
	}
	
	/**
	 * Az IceField-ek listáját beállítja.
	 * @param f: Az új lista.
	 */
	public void SetFields(ArrayList<IceField> f) {
		fields = f;
	}
	/**
	 * A Player-ek listáját beállítja.
	 * @param p: Az új lista.
	 */
	public void SetPlayers(ArrayList<Player> p) {
		players = p;
	}
	/**
	 * Hozzáad egy játékost a játkosok listájához.
	 * @param p: A hozzáadandó játékos.
	 */
	public void SetPlayerForInit(Player p) {
		players.add(p);
	}
	/**
	 * Beállítja az aktív játékost.
	 * @param p: A játékos, akit beállít.
	 */
	public void SetActivePlayer(Player p) {
		activePlayer = p;
	}
}
