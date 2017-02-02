package controller;

import java.io.IOException;
import java.util.HashMap;

import general.Level;
import model.Model;

public class LoadLevelCommand implements Command {
	String add;
	HashMap<String, String> exten;
	Level l;//not in use at the moment
	Model m;
	

	
	public LoadLevelCommand(Model m)
	{
		this.m=m;
	}
	
	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public HashMap<String, String> getExten() {
		return exten;
	}

	public void setExten(HashMap<String, String> exten) {
		this.exten = exten;
	}

	public Level getL() {
		return l;
	}

	public void setL(Level l) {
		this.l = l;
	}

	@Override
	public void execute() throws ClassNotFoundException, IOException {
	    m.loadLevel();
	    
	    



	}

}
