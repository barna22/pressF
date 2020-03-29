package szkeleton;

public class Main
{
	public void Dig()
	{
		Player p = new Player();
		
		IceField f = new IceField();

		f.SetPlayer(p); //kéne
		
		p.Dig();
	}
	
	public void TakeItem()
	{
		Player p = new Player();
		
		IceField f = new IceField();
		
		Food i = new Food();
		
		f.SetItem(i); //kéne
		
		f.SetPlayer(p);
		
		f.SetSnowLevel(0); //kéne
		
		p.PickUpItem();
	}
	
	public void FlareGunSuccess()
	{
		Player p = new Player();
		
		Game g = new Game();
		
		Icefield f= new IceField();
		
		FlareGunPart p1 = new FlareGunPart();
		FlareGunPart p2 = new FlareGunPart();
		FlareGunPart p3 = new FlareGunPart();
		
		g.SetPlayer(p); //kéne
		
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
		
		Icefield f1= new IceField();
		Icefield f2= new IceField();
		
		FlareGunPart p1 = new FlareGunPart();
		FlareGunPart p2 = new FlareGunPart();
		FlareGunPart p3 = new FlareGunPart();
		
		g.SetPlayer(player1);
		g.SetPlayer(player2);
		
		player1.SetItem(p1);
		player1.SetItem(p2);
		player1.SetItem(p3);
		
		f1.SetPlayer(player1);
		f2.SetPlayer(player2);
		
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
		
		f1.SetPlayer(p);
		
		f1.AddNeighbour(Direction.UP, f2);
		f1.AddNeighbour(Direction.DOWN, f3);
		f1.AddNeighbour(Direction.LEFT, f4);
		f1.AddNeighbour(Direction.RIGHT, f5);
		
		p.UseItem(i);
	}
	
	public void UseRopeSuccess()
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
		
		f1.SetPlayer(p1);
		f2.SetPlayer(p2);
		
		p2.SetIsInWater(true); //kéne
		
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
		
		f.SetPlayer(p);
		
		p.SetItem(i);
		
		p.UseItem(i);
	}
	
	public void MoveWithSuit()
	{
		Player p = new Player();
		
		IceField f1 = new IceField();
		IceField f2 = new IceField();
		
		DivingGear i = new DivingGear();
		
		f1.SetPlayer(p);
		
		f2.SetStability(0); //kéne
		
		p.SetItem(i);
		
		p.UseItem(i);
		
		f1.AddNeighbour(Direction.UP, f2);
		
		p.Move(Direction.UP);
	}
	
	public void MoveWithoutSuit()
	{
		Player p = new Player();
		
		IceField f1 = new IceField();
		IceField f2 = new IceField();
		
		f1.SetPlayer(p);
		
		f2.SetStability(0);
		
		f1.AddNeighbour(Direction.UP, f2);
		
		p.Move(Direction.UP);
	}
	
	public void MoveOnStable()
	{
		Player p = new Player();
		
		IceField f1 = new IceField();
		IceField f2 = new IceField();
		
		f1.SetPlayer(p);
		
		f2.SetStability(2);
		
		f1.AddNeighbour(Direction.UP, f2);
		
		p.Move(Direction.UP);
	}
	
	{}
	
	
	
	
}