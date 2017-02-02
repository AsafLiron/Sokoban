package model.data;

import java.io.IOException;
import java.io.InputStream;

public interface LevelLoader {
	
	public Level LoadLevel(InputStream io) throws ClassNotFoundException, IOException;

}
