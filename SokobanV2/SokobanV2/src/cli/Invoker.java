package cli;

import java.io.IOException;
import java.util.Scanner;

import model.data.Level;

import commands.DisplayLevelCommand;
import commands.ExitCommand;
import commands.LoadLevelCommand;
import commands.MoveCommand;
import commands.SaveLevelCommand;

public class Invoker {

	int flag;
	Level l;
	
	public Invoker() {
		flag=0;
		l=null;
	}
	
	
	public int doAction(String action) 
	{
		switch(action)
		{
		case("1") : //Display Case
			DisplayLevelCommand dlc = new DisplayLevelCommand(l);
			dlc.execute();	
			break;
		case("2") : //Load Case
			System.out.println("Enter the location of the level");
			System.out.println("");
			Scanner lc = new Scanner(System.in);
			String lcs=lc.next();
			LoadLevelCommand llc= new LoadLevelCommand(lcs);
			try {
				llc.execute();
				l=llc.getL();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case("3") ://Save Case 
			System.out.println("Select Save Type");
			System.out.println("XML");
			System.out.println("Object");
			System.out.println("Text");
			System.out.println("");
			Scanner sc = new Scanner(System.in);
			String scs=sc.next();
			SaveLevelCommand slc = new SaveLevelCommand(l,scs);
			try {
				slc.execute();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case("4") : //Move Case
			System.out.println("Enter which way to move");
			System.out.println("1)up");
			System.out.println("2)down");
			System.out.println("3)right");
			System.out.println("left");
			System.out.println("");
			Scanner mc = new Scanner(System.in);
			String mcs=mc.next();
			MoveCommand mmc = new MoveCommand(l,mcs);
			mmc.execute();
			break;
		case("5") : //Exit Case
			flag=1;
			break;
		case("6")://Exiting The Game
			ExitCommand xc = new ExitCommand();
			xc.execute();
		default :
			System.out.println("Invalid Value");
			break;
		}
		
		return flag;
	}

}
