package graphic;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

/**
 * Inicializ�lja a j�t�kot. Nyilv�ntartja a j�t�k �llapot�t.
 * Sz�mon tartja, hogy h�nyan vannak v�zbe esve �s h�ny alkatr�sze van ki�sva a jelz�pisztolynak.
 * A j�t�k v�get �r, ha a k�r v�g�n valaki v�zbe van esve. Minden k�r v�g�n l�pteti a Steppable
 * interf�szt megval�s�t� objektumokat �s vihart ind�t a j�gt�bl�kon.
 *
 */
public class Game {

	private ArrayList<IceField> fields;// az �sszes j�gt�bla
	private ArrayList<Steppable> steppables;// a s�trak �s medv�k
	private ArrayList<Player> players;// a j�t�kosok
	private Player activePlayer;// a soron lev� j�t�kos
	private String state = "running";//running, ended
	private int playersInWater = 0, gunPartsFound = 0;// a v�zben lev� j�t�kosok �s megtal�lt jelz�pisztoly alkatr�szek sz�ma

	Game(){
		fields = new ArrayList<IceField>();
		steppables = new ArrayList<Steppable>();
		players = new ArrayList<Player>();
		state = "running";
	}
	/**
	 * Vihart ind�t minden j�gt�bl�n
	 */
	public void Storm() {
		for(IceField f : fields){
			f.Storm();
		}
	}
	 /**
	  * Inicializ�lja a j�t�kot. A p�lya elrendez�se majdnem teljesen v�letlenszer�.
	  * Minden entit�s k�l�n mez�n kezd
	 * @param row sorok sz�ma
	 * @param col oszlopok sz�ma
	 * @param e eszkim�k sz�ma
	 * @param r kutat�k sz�ma
	 * @param ib jegesmedv�k sz�ma
	 */
	public void init(int row, int col, int e, int r, int ib) {
		CreateFields(row, col, e+r);
		for(int i = 0; i < e; i++) {
			Eskimo eskimo = new Eskimo();
			EskimoView ev = new EskimoView();
			ev.SetPlayer(eskimo);
			eskimo.SetView(ev);
			InitPlayer(eskimo);
		}

		for(int i = 0; i < r; i++) {
			Researcher researcher = new Researcher();
			ResearcherView rv = new ResearcherView();
			rv.SetPlayer(researcher);
			researcher.SetView(rv);
			InitPlayer(researcher);
		}

		PutBearsOnFields(ib);
		Collections.shuffle(players);
	}

	/**
	 * Felteszi a j�t�kost egy v�letlenszer� mez�re, ami m�g �gy nem borul fel t�le �s
	 * hozz�adja a j�t�kost a j�t�kosok list�j�hoz
	 * @param newPlayer Az elhelyezend� j�t�kos
	 */
	private void InitPlayer(Player player) {
		Random random = new Random();
		IceField startingField;
		do {//megfelel� kezd� mez� sorsol�s
			startingField = fields.get(random.nextInt(fields.size()));
		}while(startingField.GetNumberOfEntities() >= startingField.GetCapacity());//m�r nem f�r a mez�re

		player.SetField(startingField);
		startingField.AddEntityForInit(player);//lehet, hogy gondot okoz, hogy az Accept-el adja hoz�, de elvileg nem k�ne
		players.add(player);
	}
	/**
	 * Elhelyez a mez�k�n ib darab jegesmedv�t �gy, hogy ott m�g ne �lljon olyan entit�s, amit nem
	 * ez a f�ggv�ny tesz f�l.
	 * @param ib Az elhelyezend� medv�k sz�ma
	 */
	private void PutBearsOnFields(int ib) {
		Random random = new Random();
		ArrayList<IceField> chosenFields = new ArrayList<IceField>();
		//kisorsol ib db IceField-et, ahova majd rak 1-1 medv�t. Egy IceField szerepelhet t�bbsz�r is.
		for(int i = 0; i < ib; i++) {
			IceField newField;
			do {
				newField = fields.get(random.nextInt(fields.size()));
			}while(newField.GetNumberOfEntities() != 0);//van m�r valaki itt
			chosenFields.add(newField);


		}
		//A kisorsolt mez�kre tesz egy-egy medv�t.
		for(IceField field : chosenFields) {
			IceBear newIceBear = new IceBear();
			IceBearView ibv = new IceBearView();
			newIceBear.SetField(field);
			newIceBear.SetView(ibv);
			field.AddEntityForInit(newIceBear);//lehet, hogy gondot okoz, hogy az Accept-el adja hoz�, de elvileg nem k�ne
			steppables.add(newIceBear);
		}
	}
	/**
	 * row*col m�ret� n�gyzetr�csnak megfelel�en k�sz�t j�gt�bl�kat
	 * kisorsolja a kapacit�st, h�r�teget �s a befagyott t�rgyakat az al�bbiakat garant�lva:
	 * -min 3 j�gt�bla van, amire r� tudnak �llni egyszerre a j�t�kosok an�lk�l, hogy felborulna
	 * -3db nem 0 kapacit�s� j�gt�bl�ba lesznek fagyva a jelz�pisztoly alkatr�szei
	 * @param row sorok sz�ma
	 * @param col oszlopok sz�ma
	 * @param numberOfPlayers j�t�kosok sz�ma
	 */
	private void CreateFields(int row, int col, int numberOfPlayers) {
		Random random = new Random();
		//j�gmez�k elk�sz�t�se(+h�szint sorsol�s) �s szomsz�dok be�ll�t�sa
		for(int i = 0; i < row; i ++)
			for(int j = 0; j < col; j ++) {
				IceField neighbour, newField = new IceField(-1, random.nextInt(4));
				if(i>0) {//fels� szomsz�d
					neighbour = fields.get((i-1)*col + j);
					newField.AddNeighbour(Direction.UP, neighbour);
					neighbour.AddNeighbour(Direction.DOWN, newField);
				}
				if(j>0) {//bal oldali szomsz�d
					neighbour = fields.get(i*col + j-1);
					newField.AddNeighbour(Direction.LEFT, neighbour);
					neighbour.AddNeighbour(Direction.RIGHT, newField);
				}
				fields.add(newField);
			}

		//kapacit�sok sorsol�sa
		//3 mez�, ahol garant�ltan elf�r mindenki
		for(int i = 0; i < 3; i ++) {
			IceField selectedField;
			do {
				selectedField = fields.get(random.nextInt(row*col));
			}while(selectedField.GetCapacity() != -1);
			selectedField.SetCapacity(numberOfPlayers);
		}

		//minden mez�nek kapacit�s, ha nincs az el�z�leg kisorsolt 3 k�z�tt
		for(IceField field : fields)
			if(field.GetCapacity() == -1)
				field.SetCapacity(random.nextInt(numberOfPlayers+1));

		//t�rgyak kisorsol�sa a j�gt�bl�kra
		//3 helyre jelz�pisztoly
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

		//minden m�s mez�re egy random t�rgy
		for(IceField field : fields)
			if(field.GetItem() == null) {
				Item item;
				ItemView iv;
				int tmp = random.nextInt(6);
				switch(tmp) {
				default://ha 0-�t sorsol (ha nincs default nem hiszi el, hogy inicializ�lva lesz)
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
					steppables.add((Tent) item);
					break;
				}
				field.SetItem(item);
			}

	}

	/**
	 * Megn�zi, hogy teljes�lnek-e a gy�zelem felt�telei �s ha igen, akkor a j�t�kosok nyertek.
	 * @param f: a vizsg�lt IceField
	 * @return	 True, ha a j�t�kosok nyertek.
	 */
	public boolean TryToWin() {
		IceField f = players.get(0).GetField();
		for(Player player : players)//mindenki ugyan azon a mez�n �ll
			if(player.GetField() != f)
				return false;

		if(gunPartsFound == 3) {//megvan minden alkatr�sz
			Over(true);
			return true;
		}
		return false;
	}

	/**
	 * Befejezi a j�t�kot. Ha a param�ter true, akkor a j�t�kosok nyertek.
	 * @param victory True/false: a j�t�kosok nyertek/vesztettek.
	 */
	public void Over(boolean victory) {
		state = "ended";
		activePlayer = null;
	}

	/**
	 * A k�r v�g�n megn�zi, hogy v�zbe van-e esve valaki.
	 * Ha igen, akkor a j�t�knak v�ge.
	 * Vihart ind�t az IceFieldeken.
	 * L�pteti a Steppable-ket
	 */
	private void RoundOver() {

		if(playersInWater > 0)
			Over(false);
		if(state.equals("ended"))
			return;
		Storm();
		for(Steppable s : steppables)
			s.Step();
	}

	/**
	 * �t�ll�tja, hogy ki az aktu�lis j�t�kos �s �t�ll�tja a h�tralev� akci�it 4-re.
	 * Ha v�ge egy k�rnek, akkor megh�vja a RoundOver()-t.
	 */
	public void NextPlayer() {
		if(state.contentEquals("ended"))
			return;
		int idx = players.indexOf(activePlayer);
		if( idx == players.size()-1 ) {//utols� j�t�kos van soron
			RoundOver();
			if(state.contentEquals("ended"))
				return;
			idx = 0;
		}
		else
			idx++;
		activePlayer = players.get(idx);
		activePlayer.SetRemainingActions(4);
	}

	/**
	 * Ezzel lehet jelezni, hogy egy j�t�kost kimentettek a v�zb�l.
	 */
	public void PlayerSaved() {
		playersInWater--;

	}

	/**
	 * Ezzel lehet jelezni, hogy egy j�t�kost beleesett a v�zbe.
	 */
	public void PlayerFellInWater() {
		playersInWater++;
	}

	/**
	 * Ezzel lehet jelezni, hogy megtal�lt�k a jelz�pisztoly egyik alkatr�sz�t.
	 */
	public void GunPartFound() {
		gunPartsFound++;
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
		for(Player player : p)
			player.SetGame(this);
	}
	/**
	 * Hozz�ad egy j�t�kost a j�tkosok list�j�hoz.
	 * @param p: A hozz�adand� j�t�kos.
	 */
	public void AddPlayer(Player p) {
		players.add(p);
		p.SetGame(this);
	}
	/**
	 * Hozz�ad egy j�gt�bl�t a j�gt�bl�k list�j�hoz.
	 * @param field A hozz�adand� j�gt�bla.
	 */
	public void AddField(IceField field) {
		fields.add(field);
	}
	/**
	 * Be�ll�tja az akt�v j�t�kost.
	 * @param p: A j�t�kos, akit be�ll�t.
	 */
	public void SetActivePlayer(Player p) {
		activePlayer = p;
	}
	/**
	 * Ha nincs be�ll�tva akt�v j�t�kos, akkor be�ll�tja az els�t annak.
	 * @return Az akt�v j�t�kost adja vissza.
	 */
	public Player GetActivePlayer() {
		return activePlayer;
	}
	/**
	 * Hozz�ad egy jegesmedv�t a steppable list�hoz.
	 * @param ib A hozz�adand� jegesmedve.
	 */
	public void AddBear(IceBear ib) {
		steppables.add(ib);
	}

	public IceField getField(int i) {
		return fields.get(i);
	}

}
