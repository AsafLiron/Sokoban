package controller;

import java.io.IOException;
import java.net.URISyntaxException;

public interface Command {
	
	public void execute() throws ClassNotFoundException, IOException, URISyntaxException;

}
