package cli;

import java.io.IOException;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		printMenu();
		int flag=0;		
		Scanner sc = new Scanner(System.in);
		String com = sc.next();
		Invoker inv= new Invoker();
			flag=inv.doAction(com);
		do
		{
			printMenu();
			com=sc.next();
			flag=inv.doAction(com);
			
		}while(flag!=1);
		inv.doAction("6");		

	}
	
	
	public static void printMenu()
	{
		System.out.println("**********************");
		System.out.println("Enter a number");
		System.out.println("1) Display Level");
		System.out.println("2) Load Level");
		System.out.println("3) Save Level");
		System.out.println("4) Move The Character");
		System.out.println("5) Exit");
		System.out.println("**********************");
		System.out.println("");
	}

}
