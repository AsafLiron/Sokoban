package controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import model.Model;
import view.View;

public class MyController extends Controller implements Observer {
	
	private Model m;
	private View v;
	private Controller controller;
	private Map<String,Command> commands;
	
	public MyController(Model m,View v) {
		this.m=m;
		this.v=v;
		controller = new Controller();
		controller.start();
		initCommand();
	}
	
	private void initCommand() {
		commands = new HashMap<String,Command>();
		commands.put("Move",new MoveCommand(this.m,this.v));
		commands.put("Display", new DisplayLevelCommand(this.m,this.v));
		commands.put("Save",new SaveLevelCommand(this.m));
		commands.put("Load",new LoadLevelCommand(this.m));
		commands.put("Exit", new ExitCommand());
				}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		LinkedList<String> params=(LinkedList<String>) arg;
		String commandKey=params.removeFirst();
		Command c=commands.get(commandKey);
		if(c==null){
			
		}

	}

}
