package szkeleton;

public class Skeleton{
	
	public static String GetName(Object o) {
		return "valami";
	}
	
	//Dávid
	public void Dig()
	{
		Player p = new Player();
		
		IceField f = new IceField();

		f.SetPlayerForInit(p); //kéne
		
		p.Dig();
	}
	
	public void TakeItem() //ne legyen hó
	{
		Player p = new Player();
		
		IceField f = new IceField();
		
		Food i = new Food();
		
		f.SetItem(i); //kéne
		
		f.SetPlayerForInit(p);
		
		p.PickUpItem();
	}
	
	public void FlareGunSuccess()
	{
		Player p = new Player();
		
		Game g = new Game();
		
		IceField f= new IceField();
		
		FlareGunPart p1 = new FlareGunPart();
		FlareGunPart p2 = new FlareGunPart();
		FlareGunPart p3 = new FlareGunPart();
		
		g.SetPlayerForInit(p); //kéne
		
		p.SetItem(p1);
		p.SetItem(p2);
		p.SetItem(p3);
		
		f.SetPlayer(p);
		
		p.UseItem(p1);
	}
	
	public void FlareGunFail()
	{
		Player player1 = new Player();
		Player player2 = new Player();
		
		Game g = new Game();
		
		IceField f1= new IceField();
		IceField f2= new IceField();
		
		FlareGunPart p1 = new FlareGunPart();
		FlareGunPart p2 = new FlareGunPart();
		FlareGunPart p3 = new FlareGunPart();
		
		g.SetPlayerForInit(player1);
		g.SetPlayerForInit(player2);
		
		player1.SetItem(p1);
		player1.SetItem(p2);
		player1.SetItem(p3);
		
		f1.SetPlayerForInit(player1);
		f2.SetPlayerForInit(player2);
		
		p1.UseItem(p1);
	}
	
	public void UseFood()
	{
		Player p = new Player();
		
		Food i = new Food();
		
		p.SetItem(i);
		
		p.UseItem(i);
	}
	
	public void UseRopeFail()
	{
		Player p = new Player();
		
		Game g = new Game();
		
		IceField f1 = new IceField();
		IceField f2 = new IceField();
		IceField f3 = new IceField();
		IceField f4 = new IceField();
		IceField f5 = new IceField();
		
		Rope i = new Rope();
		
		p.SetItem(i);
		
		f1.SetPlayerForInit(p);
		
		f1.AddNeighbour(Direction.UP, f2);
		f1.AddNeighbour(Direction.DOWN, f3);
		f1.AddNeighbour(Direction.LEFT, f4);
		f1.AddNeighbour(Direction.RIGHT, f5);
		
		p.UseItem(i);
	}
	
	public void UseRopeSuccess() //legyen a vízben
	{
		Player p1 = new Player();
		Player p2 = new Player();
		
		Game g = new Game();
		
		IceField f1 = new IceField();
		IceField f2 = new IceField();
		IceField f3 = new IceField();
		IceField f4 = new IceField();
		IceField f5 = new IceField();
		
		Rope i = new Rope();
		
		p.SetItem(i);
		
		f1.SetPlayerForInit(p1);
		f2.SetPlayerForInit(p2);
		
		f1.AddNeighbour(Direction.UP, f2);
		f1.AddNeighbour(Direction.DOWN, f3);
		f1.AddNeighbour(Direction.LEFT, f4);
		f1.AddNeighbour(Direction.RIGHT, f5);
		
		p.UseItem(i);
	}
	
	public void UseShovel()
	{
		Player p = new Player();
		
		IceField f = new IceField();
		
		Shovel i = new Shovel();
		
		f.SetPlayerForInit(p);
		
		p.SetItem(i);
		
		p.UseItem(i);
	}
	
	public void MoveWithSuit() //instabil
	{
		Player p = new Player();
		
		IceField f1 = new IceField();
		IceField f2 = new IceField();
		
		DivingGear i = new DivingGear();
		
		f1.SetPlayerForInit(p);
		
		p.SetItem(i);
		
		p.UseItem(i);
		
		f1.AddNeighbour(Direction.UP, f2);
		
		p.Move(Direction.UP);
	}
	
	public void MoveWithoutSuit() //instabil
	{
		Player p = new Player();
		
		IceField f1 = new IceField();
		IceField f2 = new IceField();
		
		f1.SetPlayerForInit(p);
		
		f1.AddNeighbour(Direction.UP, f2);
		
		p.Move(Direction.UP);
	}
	
	public void MoveOnStable() //stabil
	{
		Player p = new Player();
		
		IceField f1 = new IceField();
		IceField f2 = new IceField();
		
		f1.SetPlayerForInit(p);
		
		f1.AddNeighbour(Direction.UP, f2);
		
		p.Move(Direction.UP);
	}
	
	public void MoveToFinishRound() //remaining action 1-nek kéne hogy legyen, stabilitynek stabil
	{
		Player p = new Player();
		
		Game g = new Game();
		
		IceField f1 = new IceField();
		IceField f2 = new IceField();
		
		g.SetPlayerForInit(p);
		g.SetActivePlayer(p);
		
		f1.SetPlayerForInit(p);
		
		f1.AddNeighbour(Direction.UP, f2);
		
		p.Move(Direction.UP);
	}
	
	public void MoveToFinishTurn() //remaining action 1-nek kéne hogy legyen, stabilitynek stabil
	{
		Player p1 = new Player();
		Player p2 = new Player();
		
		Game g = new Game();
		
		IceField f1 = new IceField();
		IceField f2 = new IceField();
		
		g.SetPlayerForInit(p1);
		g.SetPlayerForInit(p2);
		g.SetActivePlayer(p1);
		
		f1.SetPlayer(p);
		
		f1.AddNeighbour(Direction.UP, f2);
		
		p1.Move(Direction.UP);
	}
	
	public void NextTurn()
	{
		Player p1 = new Player();
		Player p2 = new Player();
		
		Game g = new Game();
		
		g.SetPlayerForInit(p1);
		g.SetPlayerForInit(p2);
		
		g.SetActivePlayer(p1);
		
		g.NextPlayer();
	}
	
	public void NextRound()
	{
		Player p1 = new Player();
		Player p2 = new Player();
		
		Game g = new Game();
		
		g.SetPlayerForInit(p1);
		g.SetPlayerForInit(p2);
		
		g.SetActivePlayer(p2);
		
		g.NextPlayer();
	}
	
	public void LethalStorm() //testho legyen 1, iglu nincs
	{
		Player p = new Player();
		
		IceField f = new IceField();
		
		f.SetPlayerForInit(p);
		
		f.Storm();
	}
	
	public void IglooStorm() //testho mind1, iglu van
	{
		Player p = new Player();
		
		IceField f = new IceField();
		
		f.SetPlayerForInit(p);
		
		f.Storm();
	}
	
	public void HitStorm() //testho legyen 2+, iglu nincs
	{
		Player p = new Player();
		
		IceField f = new IceField();
		
		f.SetPlayerForInit(p);
		
		f.Storm();
	}
	
	public void Igloo()
	{
		Eskimo p = new Eskimo();
		
		IceField f = new IceField();
		
		f.SetPlayerForInit(p);
		
		p.UseAbility(Direction.UP);
	}
	 
	public void Reveal()
	{
		Researcher p = new Researcher();
		
		IceField f1 = new IceField();
		IceField f2 = new IceField();
		
		f1.SetPlayerForInit(p);
		
		f1.AddNeighbour(Direction.UP, f2);
		
		p.UseAbility(Direction.UP);
	}
	//Dávid vége
}