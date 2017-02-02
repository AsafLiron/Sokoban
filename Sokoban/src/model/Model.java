package model;

import java.io.FileNotFoundException;
import java.io.IOException;

import general.Level;
import model.data.PlayableCharacter;

public interface Model {
	
	void loadLevel() throws FileNotFoundException, ClassNotFoundException, IOException;
	void moveCommandUP();
	void moveCommandDown();
	void moveCommandRight();
	void moveCommandLeft();
	void saveLevel() throws FileNotFoundException, IOException;
	void exit();
	Level getLevel();
	PlayableCharacter getChar();
	

}
