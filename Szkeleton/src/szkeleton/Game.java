package szkeleton;
import java.util.ArrayList;

public class Game {

	private ArrayList<IceField> fields;
	private ArrayList<Player> players;
	private Player activePlayer;
	
	private void Storm() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Storm()");
		MethodPrinter.IncreaseIndentation();
		for(IceField f : fields){
			f.Storm();
		}
		MethodPrinter.DecreaseIndentation();
	}
	
	public boolean IsEveryoneHere(IceField f) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".IsEveryoneHere(Field f)");
		return MethodPrinter.AskQuestion("Mindenki ezen a mezõn áll?");
	}
	
	private void CreateFields() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".CreateFields()");
	}
	
	public void Over(boolean victory) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Over(boolean victory)");
	}
	
	private void RoundOver() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".RoundOver()");
		if(MethodPrinter.AskQuestion("Van valaki vízbe esve?")) {
			MethodPrinter.IncreaseIndentation();
			Over(false);
			MethodPrinter.DecreaseIndentation();
		}
		MethodPrinter.IncreaseIndentation();
		for (IceField f : fields) 
			f.Storm();
		MethodPrinter.DecreaseIndentation();
	}
	
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
	
	public void PlayerSaved() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".PlayerSaved()");
		
	}
	
	public void PlayerFellInWater() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".PlayerFellInWater()");
	}
	
	public void SetFields(ArrayList<IceField> f) {
		fields = f;
	}
	public void SetPlayers(ArrayList<Player> p) {
		players = p;
	}
	public void SetActivePlayer(Player p) {
		activePlayer = p;
	}
}
