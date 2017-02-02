package controller;

import java.net.URISyntaxException;

import model.Model;
import view.View;

public class DisplayLevelCommand implements Command {
	
	private Model m;
	private View ui;
	
	public DisplayLevelCommand(Model m,View v) {
		this.m=m;
		this.ui=v;
	}
	

	@Override
	public void execute() throws URISyntaxException {
		ui.displayLevel(m.getLevel());
	}
	

}
