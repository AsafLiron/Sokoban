package model.data;

import java.io.IOException;
import java.io.OutputStream;

import general.Level;

public  interface  LevelSaver {
	
	public void saveLevel(OutputStream os,Level l) throws IOException;
	

}
