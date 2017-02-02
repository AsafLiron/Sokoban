package controller;

import java.util.Scanner;

import model.Model;
import view.View;

public class MoveCommand implements Command {
	Model m;
	View ui;
	
	
	public MoveCommand(Model m,View ui) {
		this.m=m;
		this.ui=ui;
	}

	@Override
	public void execute() {
		System.out.println("Enter the direction in which you want to move");
		System.out.println("Up/Down/Left/Right");
		Scanner sc = new Scanner(System.in);
		String scs=sc.next();
		scs.toLowerCase();
		
		switch(scs)
		{
		case("up"):
			m.moveCommandUP();
			break;
		case("down"):
			m.moveCommandDown();
			break;
		case("right"):
			m.moveCommandRight();
			break;
		case("left"):
			m.moveCommandLeft();
			break;
		}
		
	
		
	}

}
