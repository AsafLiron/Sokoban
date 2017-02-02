package controller;

import java.io.IOException;
import java.net.URISyntaxException;

import model.Model;
import view.View;

public class LoadLevelCommand implements Command {
	Model m;
	String[] arr;
	View v;
	

	
	public LoadLevelCommand(Model m,String[] arr,View v)
	{
		this.arr=arr;
		this.m=m;
		this.v=v;
	}
	



	@Override
	public void execute() throws ClassNotFoundException, IOException, URISyntaxException {
	    m.loadLevel(arr);
	    v.displayLevel(m.getLevel());

	}

}
