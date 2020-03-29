package szkeleton;

import java.util.HashMap;
import java.util.Map;

public class Skeleton{
	
	//Visszaadja az objektumhoz tartozó változó nevet
	public static String GetName(Object o) {
		return nameMap.get(o);
	}
	
	//Map a GetName-nek
	private static Map<Object, String> nameMap;
	
	//Egy karakter kézzel ás.
	public void Dig()
	{
		nameMap = new HashMap<Object, String>();
		
		Player p = new Researcher();
		nameMap.put(p, "p");
		
		IceField f = new IceField();
		nameMap.put(f, "f");

		f.AddPlayerForInit(p);
		
		p.Dig();
	}
	
	//Egy karakter felvesz egy itemet.
	public void TakeItem() //ne legyen hó
	{
		nameMap = new HashMap<Object, String>();
		
		Player p = new Researcher();
		nameMap.put(p, "p");
		
		IceField f = new IceField();
		nameMap.put(f, "f");
		
		Food i = new Food();
		nameMap.put(i, "i");
		
		p.SetItemForInit(i);
		
		f.AddPlayerForInit(p);
		
		p.PickUpItem();
	}
	
	//Use flare gun, everyone is here
	public void FlareGunSuccess()
	{
		nameMap = new HashMap<Object, String>();
		
		Player p = new Researcher();
		nameMap.put(p, "p");
		
		Game g = new Game();
		nameMap.put(g, "g");
		
		IceField f= new IceField();
		nameMap.put(f, "f");
		
		FlareGunPart part1 = new FlareGunPart();
		nameMap.put(part1, "part1");
		FlareGunPart part2 = new FlareGunPart();
		nameMap.put(part2, "part2");
		FlareGunPart part3 = new FlareGunPart();
		nameMap.put(part3, "part3");
		
		g.SetPlayerForInit(p);
		
		p.SetItemForInit(part1);
		p.SetItemForInit(part2);
		p.SetItemForInit(part3);
		
		f.AddPlayerForInit(p);
		
		part1.SetGameForInit(g);
		part2.SetGameForInit(g);
		part3.SetGameForInit(g);
		
		p.UseItem(part1);
	}
	
	//Use flare gun, somebody is missing
	public void FlareGunFail()
	{
		nameMap = new HashMap<Object, String>();
		
		Player p1 = new Researcher();
		nameMap.put(p1, "p1");
		Player p2 = new Researcher();
		nameMap.put(p2, "p2");
		
		Game g = new Game();
		nameMap.put(g, "g");
		
		IceField f1= new IceField();
		nameMap.put(f1, "f1");
		IceField f2= new IceField();
		nameMap.put(f2, "f2");
		
		FlareGunPart part1 = new FlareGunPart();
		nameMap.put(part1, "part1");
		FlareGunPart part2 = new FlareGunPart();
		nameMap.put(part2, "part2");
		FlareGunPart part3 = new FlareGunPart();
		nameMap.put(part3, "part3");
		
		g.SetPlayerForInit(p1);
		g.SetPlayerForInit(p2);
		
		p1.SetItemForInit(part1);
		p1.SetItemForInit(part2);
		p1.SetItemForInit(part3);
		
		f1.AddPlayerForInit(p1);
		f2.AddPlayerForInit(p2);
		
		part1.SetGameForInit(g);
		part2.SetGameForInit(g);
		part3.SetGameForInit(g);
		
		p1.UseItem(part1);
	}
	
	//Egy karakter megesz egy adag élelmet.
	public void UseFood()
	{
		nameMap = new HashMap<Object, String>();
		
		Player p = new Researcher();
		nameMap.put(p, "p");
		
		Food i = new Food();
		nameMap.put(i, "i");
		
		Game g = new Game();
		nameMap.put(g, "g");
		
		g.SetPlayerForInit(p);
		
		p.SetItemForInit(i);
		
		p.UseItem(i);
	}
	
	//Egy karakter sikertelenül használja a kötelét.
	public void UseRopeFail()
	{
		nameMap = new HashMap<Object, String>();
		
		Player p = new Researcher();
		nameMap.put(p, "p");
		
		Game g = new Game();
		nameMap.put(g, "g");
		
		IceField f1 = new IceField();
		nameMap.put(f1, "f1");
		IceField f2 = new IceField();
		nameMap.put(f2, "f2");
		IceField f3 = new IceField();
		nameMap.put(f3, "f3");
		IceField f4 = new IceField();
		nameMap.put(f4, "f4");
		IceField f5 = new IceField();
		nameMap.put(f5, "f5");
		
		Rope i = new Rope();
		nameMap.put(i, "i");
		
		p.SetItemForInit(i);
		
		f1.AddPlayerForInit(p);
		
		f1.AddNeighbour(Direction.UP, f2);
		f1.AddNeighbour(Direction.DOWN, f3);
		f1.AddNeighbour(Direction.LEFT, f4);
		f1.AddNeighbour(Direction.RIGHT, f5);
		
		p.UseItem(i);
	}
	
	//Egy karakter sikeresen használja a kötelét.
	public void UseRopeSuccess() //legyen a vízben
	{
		nameMap = new HashMap<Object, String>();
		
		Player p1 = new Researcher();
		nameMap.put(p1, "p1");
		Player p2 = new Researcher();
		nameMap.put(p2, "p2");
		
		Game g = new Game();
		nameMap.put(g, "g");
		
		IceField f1 = new IceField();
		nameMap.put(f1, "f1");
		IceField f2 = new IceField();
		nameMap.put(f2, "f2");
		IceField f3 = new IceField();
		nameMap.put(f3, "f3");
		IceField f4 = new IceField();
		nameMap.put(f4, "f4");
		IceField f5 = new IceField();
		nameMap.put(f5, "f5");
		
		Rope i = new Rope();
		nameMap.put(i, "i");
		
		p1.SetItemForInit(i);
		
		f1.AddPlayerForInit(p1);
		f2.AddPlayerForInit(p2);
		
		f1.AddNeighbour(Direction.UP, f2);
		f1.AddNeighbour(Direction.DOWN, f3);
		f1.AddNeighbour(Direction.LEFT, f4);
		f1.AddNeighbour(Direction.RIGHT, f5);
		
		p1.UseItem(i);
	}
	
	//Egy karakter ásásra használja az ásóját.
	public void UseShovel()
	{
		nameMap = new HashMap<Object, String>();
		
		Player p = new Researcher();
		nameMap.put(p, "p");
		
		IceField f = new IceField();
		nameMap.put(f, "f");
		
		Shovel i = new Shovel();
		nameMap.put(i, "i");
		
		f.AddPlayerForInit(p);
		
		p.SetItemForInit(i);
		
		p.UseItem(i);
	}
	
	//Egy karakter rásétál egy mezõre, ahol biztonságosan a vízbe esik, és nem ér véget a köre.
	public void MoveWithSuit() //instabil
	{
		nameMap = new HashMap<Object, String>();
		
		Player p = new Researcher();
		nameMap.put(p, "p");
		
		Game g = new Game();
		nameMap.put(g, "g");
		
		IceField f1= new IceField();
		nameMap.put(f1, "f1");
		IceField f2= new IceField();
		nameMap.put(f2, "f2");
		
		DivingGear i = new DivingGear();
		nameMap.put(i, "i");
		
		g.SetPlayerForInit(p);
		g.SetActivePlayer(p);
		
		f1.AddPlayerForInit(p);
		
		p.SetItemForInit(i);
		
		p.UseItem(i);
		
		f1.AddNeighbour(Direction.UP, f2);
		
		p.Move(Direction.UP);
	}
	
	//Egy karakter rásétál egy mezõre, ahol a vízbe esik, és véget ér a köre.
	public void MoveWithoutSuit() //instabil
	{
		nameMap = new HashMap<Object, String>();
		
		Player p = new Researcher();
		nameMap.put(p, "p");
		
		Game g = new Game();
		nameMap.put(g, "g");
		
		IceField f1= new IceField();
		nameMap.put(f1, "f1");
		IceField f2= new IceField();
		nameMap.put(f2, "f2");
		
		g.SetPlayerForInit(p);
		g.SetActivePlayer(p);
		
		f1.AddPlayerForInit(p);
		
		f1.AddNeighbour(Direction.UP, f2);
		
		p.Move(Direction.UP);
	}
	
	//Egy karakter rásétel egy másik mezõre.
	public void MoveOnStable() //stabil
	{
		nameMap = new HashMap<Object, String>();
		
		Player p = new Researcher();
		nameMap.put(p, "p");
		
		IceField f1= new IceField();
		nameMap.put(f1, "f1");
		IceField f2= new IceField();
		nameMap.put(f2, "f2");
		
		f1.AddPlayerForInit(p);
		
		f1.AddNeighbour(Direction.UP, f2);
		
		p.Move(Direction.UP);
	}
	
	//Egy karakter rásétel egy másik mezõre, és mivel ez volt az utolsó akciója, véget ér a köre, és mivel ez volt az utolsó akcióval bíró játékos, ezért véget ér a nagy kör is.
	public void MoveToFinishRound() //remaining action 1-nek kéne hogy legyen, stabilitynek stabil
	{
		nameMap = new HashMap<Object, String>();
		
		Player p = new Researcher();
		nameMap.put(p, "p");
		
		Game g = new Game();
		nameMap.put(g, "g");
		
		IceField f1= new IceField();
		nameMap.put(f1, "f1");
		IceField f2= new IceField();
		nameMap.put(f2, "f2");
		
		g.SetPlayerForInit(p);
		g.SetActivePlayer(p);
		
		f1.AddPlayerForInit(p);
		
		f1.AddNeighbour(Direction.UP, f2);
		
		p.Move(Direction.UP);
	}
	
	//Egy karakter rásétel egy másik mezõre, és mive ez volt az utolsó akciója, véget ér a köre.
	public void MoveToFinishTurn() //remaining action 1-nek kéne hogy legyen, stabilitynek stabil
	{
		nameMap = new HashMap<Object, String>();
		
		Player p1 = new Researcher();
		nameMap.put(p1, "p1");
		Player p2 = new Researcher();
		nameMap.put(p1, "p2");
		
		Game g = new Game();
		nameMap.put(g, "g");
		
		IceField f1= new IceField();
		nameMap.put(f1, "f1");
		IceField f2= new IceField();
		nameMap.put(f2, "f2");
		
		g.SetPlayerForInit(p1);
		g.SetPlayerForInit(p2);
		g.SetActivePlayer(p1);
		
		f1.AddPlayerForInit(p1);
		
		f1.AddNeighbour(Direction.UP, f2);
		
		p1.Move(Direction.UP);
	}
	
	//Egy játékos kifogy az akcióiból, és a következõ játékos jön
	public void NextTurn()
	{
		nameMap = new HashMap<Object, String>();
		
		Player p1 = new Researcher();
		nameMap.put(p1, "p1");
		Player p2 = new Researcher();
		nameMap.put(p2, "p2");
		
		Game g = new Game();
		nameMap.put(g, "g");
		
		g.SetPlayerForInit(p1);
		g.SetPlayerForInit(p2);
		
		g.SetActivePlayer(p1);
		
		g.NextPlayer();
	}
	
	//Egy játékos kifogy az akcióiból, és mivel õ volt az utolsó játékos, a következõ kör kezdõdik
	public void NextRound()
	{
		nameMap = new HashMap<Object, String>();
		
		Player p1 = new Researcher();
		nameMap.put(p1, "p1");
		Player p2 = new Researcher();
		nameMap.put(p2, "p2");
		
		Game g = new Game();
		nameMap.put(g, "g");
		
		g.SetPlayerForInit(p1);
		g.SetPlayerForInit(p2);
		
		g.SetActivePlayer(p2);
		
		g.NextPlayer();
	}
	
	//A vihar lecsap egy mezõre, ahol karakter tartózkodik, és a vihar megöli ezt a karaktert.
	public void LethalStorm() //testho legyen 1, iglu nincs
	{
		nameMap = new HashMap<Object, String>();
		
		Player p = new Researcher();
		nameMap.put(p, "p");
		
		IceField f = new IceField();
		nameMap.put(f, "f");
		
		f.AddPlayerForInit(p);
		
		f.Storm();
	}
	
	//A vihar lecsap egy mezõre, ahol igloo van, ezért nem hûl ki senki.
	public void IglooStorm() //testho mind1, iglu van
	{
		nameMap = new HashMap<Object, String>();
		
		Player p = new Researcher();
		nameMap.put(p, "p");
		
		IceField f = new IceField();
		nameMap.put(f, "f");
		
		f.AddPlayerForInit(p);
		
		f.Storm();
	}
	
	//A vihar lecsap egy mezõre, ahol karakter tartózkodik, és a karakter kihûl.
	public void HitStorm() //testho legyen 2+, iglu nincs
	{
		nameMap = new HashMap<Object, String>();
		
		Player p = new Researcher();
		nameMap.put(p, "p");
		
		IceField f = new IceField();
		nameMap.put(f, "f");
		
		f.AddPlayerForInit(p);
		
		f.Storm();
	}
	
	//Egy eszkimó használja a képességét a saját mezõjén
	public void Igloo()
	{
		nameMap = new HashMap<Object, String>();
		
		Eskimo p = new Eskimo();
		nameMap.put(p, "p");
		
		IceField f = new IceField();
		nameMap.put(f, "f");
		
		f.AddPlayerForInit(p);
		
		p.UseAbility(Direction.UP);
	}
	
	//Egy kutató használja a képességét egy szomszédos mezõn
	public void Reveal()
	{
		nameMap = new HashMap<Object, String>();
		
		Researcher p = new Researcher();
		nameMap.put(p, "p");
		
		IceField f1= new IceField();
		nameMap.put(f1, "f1");
		IceField f2= new IceField();
		nameMap.put(f2, "f2");
		
		f1.AddPlayerForInit(p);
		
		f1.AddNeighbour(Direction.UP, f2);
		
		p.UseAbility(Direction.UP);
	}
}