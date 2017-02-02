package model.data;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MyXMLLevelLoader {
	String line;

	
	public MyXMLLevelLoader() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Level LoadLevel(InputStream io) throws FileNotFoundException
	{
		XMLDecoder xmld = new XMLDecoder(new BufferedInputStream(io));
		Level l = (Level) xmld.readObject();
		
		xmld.close();
		
		System.out.println("Load Successfully");
		return l;
	}
	
	


}
