package controller;

public class ExitCommand implements Command {
	
	public ExitCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		System.out.println("Exiting The Game");
		System.exit(1);
	}


}
