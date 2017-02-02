package commands;

import model.data.DisplayLevel;
import model.data.Level;

public class DisplayLevelCommand implements Command {
	
	private DisplayLevel dis;
	
	public DisplayLevelCommand(Level l) {
		dis=new DisplayLevel(l);
	}
	

	@Override
	public void execute() {
		dis.show();
	}
	

}
