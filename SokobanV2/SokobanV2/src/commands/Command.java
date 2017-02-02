package commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.data.Level;

public interface Command {
	
	public void execute() throws ClassNotFoundException, IOException;

}
