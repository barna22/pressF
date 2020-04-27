package proto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
	
	public static void main(String[] args)
	{
		ArrayList<String> lines = ReadLines();
		ConsoleApp app = new ConsoleApp();
		app.Init();
		
		for(String line : lines) {
			String[] pieces = line.split(" ");
			switch(pieces[0]) {
				case "createfield":
					app.CreateField(pieces[1], pieces[2], pieces[3]);
					break;
				case "setneighbor":
					app.SetNeighbour(pieces[1], pieces[2], pieces[3], pieces[4]);
					break;
				case "entity":
					app.CreateEntity(pieces[1], pieces[2], pieces[3]);
					break;
				case "createitem":
					app.CreateItem(pieces[1], pieces[2], pieces[3]);
					break;
				case "useitem":
					app.UseItem(pieces[1]);
					break;
				case "useability":
					app.UseAbility(pieces[1]);
					break;
				case "move":
					app.Move(pieces[1]);
					break;
				case "movebear":
					app.MoveBear(pieces[1], pieces[2]);
					break;
				case "placeigloo":
					app.PlaceIgloo(pieces[1]);
					break;
				case "setactiveplayer":
					app.SetActivePlayer(pieces[1]);
					break;
				case "setactions":
					app.SetActions(pieces[1]);
					break;
				case "settemp":
					app.SetTemp(pieces[1]);
					break;
				case "info":
					app.Info(pieces[1]);
					break;
				case "setrandom":
					app.SetRandom(pieces[1]);
					break;
				case "dig":
					app.Dig();
					break;
				case "pickupitem":
					app.PickUpItem();
					break;
				case "additem":
					app.AddItem(pieces[1], pieces[2]);
					break;
			}
		}
		
	}
	
	private static ArrayList<String> ReadLines() {
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line;
			while( (line = br.readLine()) != null) {
				lines.add(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
}