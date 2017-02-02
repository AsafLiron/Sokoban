package view;

import java.net.URISyntaxException;

import general.Level;

public interface  View  {
	
	void displayLevel(Level l) throws URISyntaxException;

	void closingLevel();

}
