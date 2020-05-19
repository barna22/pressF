package graphic;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

/**
 * Inicializálja a játékot. Nyilvántartja a játék állapotát. 
 * Számon tartja, hogy hányan vannak vízbe esve és hány alkatrésze van kiásva a jelzõpisztolynak. 
 * A játék véget ér, ha a kör végén valaki vízbe van esve. Minden kör végén lépteti a Steppable
 * interfészt megvalósító objektumokat és vihart indít a jégtáblákon.
 * 
 */
public class Game {

	private ArrayList<IceField> fields;// az ï¿½sszes jï¿½gtï¿½bla
	private ArrayList<Steppable> steppables;// a sï¿½trak ï¿½s medvï¿½k
	private ArrayList<Player> players;// a jï¿½tï¿½kosok
	private Player activePlayer;// a soron levï¿½ jï¿½tï¿½kos
	private String state = "running";//running, won, lost;
	private int playersInWater = 0, gunPartsFound = 0;// a vï¿½zben levï¿½ jï¿½tï¿½kosok ï¿½s megtalï¿½lt jelzï¿½pisztoly alkatrï¿½szek szï¿½ma

	Game(){
		fields = new ArrayList<IceField>();
		steppables = new ArrayList<Steppable>();
		players = new ArrayList<Player>();
		state = "running";
	}
	/**
	 * Vihart indít minden jégtáblán
	 */
	public void Storm() {
		for(IceField f : fields){
			f.Storm();
		}
		GameView.instance.AnimateStorm();
	}
	/**
	  * Inicializálja a játékot. A pálya elrendezése majdnem teljesen véletlenszerû.
	  * Minden entitás külön mezõn kezd
	 * @param row sorok száma
	 * @param col oszlopok száma
	 * @param e eszkimók száma
	 * @param r kutatók száma
	 * @param ib jegesmedvék száma
	 */
	public void init(int row, int col, int e, int r, int ib) {
		CreateFields(row, col, e+r);
		for(int i = 0; i < e; i++) {
			Eskimo eskimo = new Eskimo();
			EskimoView ev = new EskimoView();
			ev.SetPlayer(eskimo);
			eskimo.SetView(ev);
			eskimo.SetName("Player" + (i+1));
			eskimo.SetGame(this);
			InitPlayer(eskimo);
		}

		for(int i = 0; i < r; i++) {
			Researcher researcher = new Researcher();
			ResearcherView rv = new ResearcherView();
			rv.SetPlayer(researcher);
			researcher.SetView(rv);
			researcher.SetName("Player" + (e + i + 1));
			researcher.SetGame(this);
			InitPlayer(researcher);
		}

		PutBearsOnFields(ib);
		Collections.shuffle(players);
		activePlayer = players.get(0);
		activePlayer.SetRemainingActions(4);
	}

	/**
	 * Felteszi a játékost egy véletlenszerû mezõre, ami még így nem borul fel tõle és
	 * hozzáadja a játékost a játékosok listájához
	 * @param newPlayer Az elhelyezendõ játékos
	 */
	private void InitPlayer(Player player) {
		Random random = new Random();
		IceField startingField;
		do {//megfelelï¿½ kezdï¿½ mezï¿½ sorsolï¿½s
			startingField = fields.get(random.nextInt(fields.size()));
		}while(startingField.GetNumberOfEntities() >= startingField.GetCapacity());//mï¿½r nem fï¿½r a mezï¿½re

		player.SetField(startingField);
		startingField.AddEntityForInit(player);//lehet, hogy gondot okoz, hogy az Accept-el adja hozï¿½, de elvileg nem kï¿½ne
		players.add(player);
	}
	/**
	 * Elhelyez a mezõkön ib darab jegesmedvét úgy, hogy ott még ne álljon olyan entitás, amit nem
	 * ez a függvény tesz föl.
	 * @param ib Az elhelyezendõ medvék száma
	 */
	private void PutBearsOnFields(int ib) {
		Random random = new Random();
		ArrayList<IceField> chosenFields = new ArrayList<IceField>();
		//kisorsol ib db IceField-et, ahova majd rak 1-1 medvï¿½t. Egy IceField szerepelhet tï¿½bbszï¿½r is.
		for(int i = 0; i < ib; i++) {
			IceField newField;
			do {
				newField = fields.get(random.nextInt(fields.size()));
			}while(newField.GetNumberOfEntities() != 0);//van mï¿½r valaki itt
			chosenFields.add(newField);


		}
		//A kisorsolt mezokre tesz egy-egy medvet.
		for(IceField field : chosenFields) {
			IceBear newIceBear = new IceBear();
			IceBearView ibv = new IceBearView();
			newIceBear.SetField(field);
			newIceBear.SetView(ibv);
			field.AddEntityForInit(newIceBear);//lehet, hogy gondot okoz, hogy az Accept-el adja hozï¿½, de elvileg nem kï¿½ne
			steppables.add(newIceBear);
		}
	}
	/**
	 * row*col méretû négyzetrácsnak megfelelõen készít jégtáblákat
	 * kisorsolja a kapacitást, hóréteget és a befagyott tárgyakat az alábbiakat garantálva:
	 * -min 3 jégtábla van, amire rá tudnak állni egyszerre a játékosok anélkül, hogy felborulna
	 * -3db nem 0 kapacitásó jégtáblába lesznek fagyva a jelzõpisztoly alkatrészei
	 * @param row sorok száma
	 * @param col oszlopok száma
	 * @param numberOfPlayers játékosok száma
	 */
	private void CreateFields(int row, int col, int numberOfPlayers) {
		Random random = new Random();
		//jégmezõk elkészítése(+hószint sorsolás) és szomszédok beállítása
		for(int i = 0; i < row; i ++)
			for(int j = 0; j < col; j ++) {
				IceField neighbour, newField = new IceField(-1, random.nextInt(4));
				if(i>0) {//felsõ szomszéd
					neighbour = fields.get((i-1)*col + j);
					newField.AddNeighbour(Direction.UP, neighbour);
					neighbour.AddNeighbour(Direction.DOWN, newField);
				}
				if(j>0) {//bal oldali szomszéd
					neighbour = fields.get(i*col + j-1);
					newField.AddNeighbour(Direction.LEFT, neighbour);
					neighbour.AddNeighbour(Direction.RIGHT, newField);
				}
				fields.add(newField);
			}

		//kapacitások sorsolása
		//3 mezõ, ahol garantáltan elfér mindenki
		for(int i = 0; i < 3; i ++) {
			IceField selectedField;
			do {
				selectedField = fields.get(random.nextInt(row*col));
			}while(selectedField.GetCapacity() != -1);
			selectedField.SetCapacity(numberOfPlayers);
		}

		//minden mezõnek kapacitás, ha nincs az elõzõleg kisorsolt 3 között
		for(IceField field : fields)
			if(field.GetCapacity() == -1)
				field.SetCapacity(random.nextInt(numberOfPlayers+1));

		//tárgyak kisorsolása a jégtáblákra
		//3 helyre jelzõpisztoly
		for(int i = 0; i < 3; i ++) {
			IceField selectedField;
			do {
				selectedField = fields.get(random.nextInt(row*col));
			}while(selectedField.GetCapacity() == 0 || selectedField.GetItem() != null);//nem lehet lyuk
			FlareGunPart fgp = new FlareGunPart();
			ItemView itemview = new ItemView("flare gun.png");
			fgp.SetGame(this);
			fgp.SetView(itemview);
			itemview.SetItem(fgp);
			selectedField.SetItem(fgp);
		}

		//minden más mezõre egy random tárgy
		for(IceField field : fields)
			if(field.GetItem() == null && field.GetCapacity() > 0) {
				Item item;
				ItemView iv;
				int tmp = random.nextInt(6);
				switch(tmp) {
				default://ha 0-át sorsol (ha nincs default nem hiszi el, hogy inicializálva lesz)
					item = new DivingGear();
					iv = new ItemView("diving gear.png");
					item.SetView(iv);
					iv.SetItem(item);
					break;
				case 1:
					item = new Food();
					iv = new ItemView("food.png");
					item.SetView(iv);
					iv.SetItem(item);
					break;
				case 2:
					item = new Rope();
					iv = new ItemView("rope.png");
					item.SetView(iv);
					iv.SetItem(item);
					break;
				case 3:
					item = new Shovel();
					iv = new ItemView("shovel.png");
					item.SetView(iv);
					iv.SetItem(item);
					break;
				case 4:
					item = new BreakableShovel();
					iv = new ItemView("breakable shovel.png");
					item.SetView(iv);
					iv.SetItem(item);
					break;
				case 5:
					item = new Tent();
					iv = new ItemView("tent.png");
					item.SetView(iv);
					iv.SetItem(item);
					break;
				}
				field.SetItem(item);
			}

	}

	/**
	 * Megnézi, hogy teljesülnek-e a gyõzelem feltételei és ha igen, akkor a játékosok nyertek.
	 * @param f: a vizsgált IceField
	 * @return	 True, ha a játékosok nyertek.
	 */
	public boolean TryToWin() {
		IceField f = players.get(0).GetField();
		for(Player player : players)//mindenki ugyan azon a mezï¿½n ï¿½ll
			if(player.GetField() != f)
				return false;

		if(gunPartsFound == 3) {//megvan minden alkatrï¿½sz
			Over(true);
			return true;
		}
		return false;
	}

	/**
	 * Befejezi a játékot. Ha a paraméter true, akkor a játékosok nyertek.
	 * @param victory True/false: a játékosok nyertek/vesztettek.
	 */
	public void Over(boolean victory) {
		if(state.equals("win") || state.equals("lost"))
			return;
		if(victory)
			state = "win";
		else
			state = "lost";
		activePlayer = null;
		GameView.instance.Update();
	}

	/**
	 * A kör végén megnézi, hogy vízbe van-e esve valaki.
	 * Ha igen, akkor a játéknak vége.
	 * Vihart indít az IceFieldeken.
	 * Lépteti a Steppable-ket
	 */
	private void RoundOver() {

		if(playersInWater > 0)
			Over(false);
		if(state.equals("win") || state.equals("lost"))
			return;
		Storm();
		for(int i = 0; i < steppables.size(); i++)
			steppables.get(i).Step();
	}

	/**
	 * Átállítja, hogy ki az aktuális játékos és átállítja a hátralevõ akcióit 4-re.
	 * Ha vége egy körnek, akkor meghívja a RoundOver()-t.
	 */
	public void NextPlayer() {
		if(state.contentEquals("win") || state.contentEquals("lost"))
			return;
		int idx = players.indexOf(activePlayer);
		if( idx == players.size()-1 ) {//utolsï¿½ jï¿½tï¿½kos van soron
			RoundOver();
			if(state.contentEquals("win") || state.contentEquals("lost"))
				return;
			idx = 0;
		}
		else
			idx++;
		activePlayer = players.get(idx);
		activePlayer.SetRemainingActions(4);
		GameView.instance.getPlayerPanel().setPlayer(activePlayer);
	}

	/**
	 * Ezzel lehet jelezni, hogy egy játékost kimentettek a vízbõl.
	 */
	public void PlayerSaved() {
		playersInWater--;

	}

	/**
	 * Ezzel lehet jelezni, hogy egy játékost beleesett a vízbe.
	 */
	public void PlayerFellInWater() {
		playersInWater++;
	}

	/**
	 * Ezzel lehet jelezni, hogy megtalaltak a jelzopisztoly egyik alkatreszet.
	 */
	public void GunPartFound() {
		gunPartsFound++;
	}

	/**
	 * Az IceField-ek listáját beállítja.
	 * @param f: Az új lista.
	 */
	public void SetFields(ArrayList<IceField> f) {
		fields = f;
	}
	/**
	 * Ha nincs beállítva aktív játékos, akkor beállítja az elsõt annak.
	 * @return Az aktív játékost adja vissza.
	 */
	public Player GetActivePlayer() {
		return activePlayer;
	}

	public IceField getField(int i) {
		return fields.get(i);
	}

	public void AddSteppable(Steppable s) {
		steppables.add(s);
	}
	
	public void RemoveSteppable(Steppable s) {
		steppables.remove(s);
	}
	
	public String getState() {
		return state;
	}
}
