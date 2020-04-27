package proto;
import java.io.PrintWriter;
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

	private ArrayList<IceField> fields;// az összes jégtábla
	private ArrayList<Steppable> steppables;// a sátrak és medvék
	private ArrayList<Player> players;// a játékosok
	private Player activePlayer;// a soron levõ játékos
	private String state = "running";//running, ended
	private int playersInWater = 0, gunPartsFound = 0;// a vízben levõ játékosok és megtalált jelzõpisztoly alkatrészek száma

	Game(){
		fields = new ArrayList<IceField>();
		steppables = new ArrayList<Steppable>();
		players = new ArrayList<Player>();
		state = "running";
	}
	/**
	 * Vihart indít minden jégtáblán
	 */
	private void Storm() {
		for(IceField f : fields){
			f.Storm();
		}
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
		for(int i = 0; i < e; i++) 
			InitPlayer(new Eskimo());
		for(int i = 0; i < r; i++) 
			InitPlayer(new Researcher());
		PutBearsOnFields(ib);
		Collections.shuffle(players);
	}
	
	/**
	 * Felteszi a játékost egy véletlenszerû mezõre, ami még így nem borul fel tõle és
	 * hozzáadja a játékost a játékosok listájához
	 * @param newPlayer Az elhelyezendõ játékos
	 */
	private void InitPlayer(Player player) {
		Random random = new Random();
		IceField startingField;
		do {//megfelelõ kezdõ mezõ sorsolás
			startingField = fields.get(random.nextInt(fields.size()));
		}while(startingField.GetNumberOfEntities() >= startingField.GetCapacity());//már nem fér a mezõre

		player.SetField(startingField);
		startingField.Accept(player);//lehet, hogy gondot okoz, hogy az Accept-el adja hozá, de elvileg nem kéne
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
		//kisorsol ib db IceField-et, ahova majd rak 1-1 medvét. Egy IceField szerepelhet többször is.
		for(int i = 0; i < ib; i++) {
			IceField newField;
			do {
				newField = fields.get(random.nextInt(fields.size()));
			}while(newField.GetNumberOfEntities() != 0);//van már valaki itt
			chosenFields.add(newField);

			
		}
		//A kisorsolt mezõkre tesz egy-egy medvét.
		for(IceField field : chosenFields) {
			IceBear newIceBear = new IceBear();
			newIceBear.SetField(field);
			field.Accept(newIceBear);//lehet, hogy gondot okoz, hogy az Accept-el adja hozá, de elvileg nem kéne
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
					//newField.AddNeighbour(Direction.UP, neighbour);
					//neighbour.AddNeighbour(Direction.DOWN, newField);
					newField.AddNeighbour(1, neighbour);
					neighbour.AddNeighbour(3, newField);
				}
				if(j>0) {//bal oldali szomszéd
					neighbour = fields.get(i*col + j-1);
					//newField.AddNeighbour(Direction.LEFT, neighbour);
					//neighbour.AddNeighbour(Direction.RIGHT, newField);
					newField.AddNeighbour(0, neighbour);
					neighbour.AddNeighbour(2, newField);
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
			selectedField.SetItem(new FlareGunPart());
		}
		
		//minden más mezõre egy random tárgy
		for(IceField field : fields) 
			if(field.GetItem() == null) {
				Item item;
				int tmp = random.nextInt(6);
				switch(tmp) {
				default://ha 0-át sorsol (ha nincs default nem hiszi el, hogy inicializálva lesz)
					item = new DivingGear();
					break;
				case 1:
					item = new Food();
					break;
				case 2:
					item = new Rope();
					break;
				case 3:
					item = new Shovel();
					break;
				case 4:
					item = new BreakableShovel();
					break;
				case 5:
					item = new Tent();
					steppables.add((Tent) item);
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
		for(Player player : players)//mindenki ugyan azon a mezõn áll
			if(player.GetField() != f)
				return false;

		if(gunPartsFound == 3) {//megvan minden alkatrész
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
		if(victory)
			state = "win";
		else
			state = "lose";
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
		Storm();
		for(Steppable s : steppables)
			s.Step();
	}
	
	/**
	 * Átállítja, hogy ki az aktuális játékos és átállítja a hátralevõ akcióit 4-re.
	 * Ha vége egy körnek, akkor meghívja a RoundOver()-t.
	 */
	public void NextPlayer() {

		int idx = players.indexOf(activePlayer);
		if( idx == players.size()-1 ) {//utolsó játékos van soron
			RoundOver();
			idx = 0;
		}
		else
			idx++;

		players.get(idx).SetRemainingActions(4);
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
	 * Ezzel lehet jelezni, hogy megtalálták a jelzõpisztoly egyik alkatrészét.
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
	 * A Player-ek listáját beállítja.
	 * @param p: Az új lista.
	 */
	public void SetPlayers(ArrayList<Player> p) {
		players = p;
		for(Player player : p)
			player.SetGame(this);
	}
	/**
	 * Hozzáad egy játékost a játkosok listájához.
	 * @param p: A hozzáadandó játékos.
	 */
	public void AddPlayer(Player p) {
		players.add(p);
		p.SetGame(this);
	}
	/**
	 * Hozzáad egy jégtáblát a jégtáblák listájához.
	 * @param field A hozzáadandó jégtábla.
	 */
	public void AddField(IceField field) {
		fields.add(field);
	}
	/**
	 * Beállítja az aktív játékost.
	 * @param p: A játékos, akit beállít.
	 */
	public void SetActivePlayer(Player p) {
		activePlayer = p;
	}
	/**
	 * Ha nincs beállítva aktív játékos, akkor beállítja az elsõt annak.
	 * @return Az aktív játékost adja vissza.
	 */
	public Player GetActivePlayer() {
		if(activePlayer == null)
			activePlayer = players.get(0);
		return activePlayer;
	}
	/**
	 * Hozzáad egy jegesmedvét a steppable listához.
	 * @param ib A hozzáadandó jegesmedve.
	 */
	public void AddBear(IceBear ib) {
		steppables.add(ib);
	}
	/**
	 * Kiírja az adatait a standard kimenetre
	 */
	public void PrintInfo() {
		PrintWriter pw = new PrintWriter(System.out);
		pw.println("State: " + state);
		pw.println("Playersinwater: " + playersInWater);
		pw.println("Gunpartsfound: " + gunPartsFound);
		pw.println("ActivePlayer: " + activePlayer==null ? "-" : ConsoleApp.GetName(activePlayer) );
		pw.close();
	}
}
