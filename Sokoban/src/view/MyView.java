package view;

import java.util.Observable;

import general.Level;

public class MyView extends Observable implements View {
	
	DisplayLevel dl;
	
	public void displayLevel(Level l)
	{
		dl=new DisplayLevel(l);
		dl.show();
	}

}
