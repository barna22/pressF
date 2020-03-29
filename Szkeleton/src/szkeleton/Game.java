package szkeleton;
import java.util.ArrayList;

/**
 * Inicializ�lja a j�t�k elemeit �s nyilv�ntartja a j�t�k �llapot�t.
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
	 * Megn�zi, hogy mindenki az �tvett fielden �ll e.
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
	 * Megn�zi, hogy teljes�lnek-e a gy�zelem felt�telei �s ha igen, akkor a j�t�kosok nyertek.
	 * @param f: a vizsg�lt IceField
	 * @return	 False, mert a flare
	 */
	public boolean CheckWinCondition(IceField f) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".CheckWinCondition(" + Skeleton.GetName(f) + ")");
		MethodPrinter.IncreaseIndentation();
		for(IceField field : fields)
			field.GetNumberOfPlayers();
		MethodPrinter.DecreaseIndentation();
		boolean result = MethodPrinter.AskQuestion("Mindenki ezen a mez�n �ll?") && MethodPrinter.AskQuestion("Az �sszes alkatr�sz ki van �sva?");
		if(result) {
			MethodPrinter.IncreaseIndentation();
			Over(true);
			MethodPrinter.DecreaseIndentation();
		}
		return result;
	}
	
	/**
	 * Befejezi a j�t�kot. Ha a param�ter true, akkor a j�t�kosok nyertek.
	 * @param victory True/false: a j�t�kosok nyertek/vesztettek.
	 */
	public void Over(boolean victory) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Over(" + victory + ")");
	}
	
	/**
	 * A k�r v�g�n megn�zi, hogy v�zbe van-e esve valaki.
	 * Ha igen, akkor a j�t�knak v�ge.
	 * Vihart ind�t az IceFieldeken.
	 */
	private void RoundOver() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".RoundOver()");
		if(MethodPrinter.AskQuestion("Van valaki v�zbe esve?")) {
			MethodPrinter.IncreaseIndentation();
			Over(false);
			MethodPrinter.DecreaseIndentation();
		}
		MethodPrinter.IncreaseIndentation();
		Storm();
		MethodPrinter.DecreaseIndentation();
	}
	
	/**
	 * �t�ll�tja, hogy ki az aktu�lis j�z�kos �s �t�ll�tja a h�tralev� akci�it 4-re.
	 * Ha v�ge egy k�rnek, akkor megh�vja a RoundOver()-t.
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
	 * Ezzel lehet jelezni, hogy egy j�t�kost kimentettek a v�zb�l.
	 */
	public void PlayerSaved() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".PlayerSaved()");
		
	}
	
	/**
	 * Ezzel lehet jelezni, hogy egy j�t�kost beleesett a v�zbe.
	 */
	public void PlayerFellInWater() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".PlayerFellInWater()");
	}
	
	/**
	 * Ezzel lehet jelezni, hogy megtal�lt�k a jelz�pisztoly egyik alkatr�sz�t.
	 */
	public void FlareGunPartFound() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".FlareGunPartFound()");
	}
	
	/**
	 * Az IceField-ek list�j�t be�ll�tja.
	 * @param f: Az �j lista.
	 */
	public void SetFields(ArrayList<IceField> f) {
		fields = f;
	}
	/**
	 * A Player-ek list�j�t be�ll�tja.
	 * @param p: Az �j lista.
	 */
	public void SetPlayers(ArrayList<Player> p) {
		players = p;
	}
	/**
	 * Hozz�ad egy j�t�kost a j�tkosok list�j�hoz.
	 * @param p: A hozz�adand� j�t�kos.
	 */
	public void SetPlayerForInit(Player p) {
		players.add(p);
	}
	/**
	 * Be�ll�tja az akt�v j�t�kost.
	 * @param p: A j�t�kos, akit be�ll�t.
	 */
	public void SetActivePlayer(Player p) {
		activePlayer = p;
	}
}
