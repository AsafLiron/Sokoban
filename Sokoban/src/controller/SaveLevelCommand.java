package controller;

import java.io.IOException;

import model.Model;

public class SaveLevelCommand implements Command {
	Model m;
	
	public SaveLevelCommand(Model m)
	{
		this.m=m;

	}

	
	@Override
	public void execute() throws IOException {
			m.saveLevel();
	    }


	}



