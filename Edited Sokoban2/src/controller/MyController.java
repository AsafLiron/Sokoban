package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import model.Model;
import view.View;

public class MyController extends Controller {
	
	private Model m;
	private View v;
	private Map<String,Command> commands;
	String []arr;
	
	public MyController(Model m,View v) {
		
		arr = new String[3];
		this.m=m;
		this.v=v;
		initCommand();
	}
	
	private void initCommand() {
		commands = new HashMap<String,Command>();
		commands.put("Move",new MoveCommand(this.m,this.v));
		commands.put("Display", new DisplayLevelCommand(this.m,this.v));
		commands.put("Save",new SaveLevelCommand(this.m));
		commands.put("Load",new LoadLevelCommand(this.m,this.arr,this.v));
		commands.put("Exit", new ExitCommand());
				}

	@Override
	public void update(Observable o, Object arg) {
		this.arr=(String[]) arg;
		initCommand();

		try {
			addToQueue(commands.get(arr[1]));
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}
	
	

}
