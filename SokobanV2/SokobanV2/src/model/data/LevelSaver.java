package model.data;

import java.io.IOException;
import java.io.OutputStream;

public  interface  LevelSaver {
	
	public void saveLevel(OutputStream os,Level l) throws IOException;
	

}
