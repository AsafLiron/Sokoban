package model.data;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;



public class Run {

	public static void main(String[] args) throws FileNotFoundException {
		
		 Level l = new Level();
		 MyXMLLevelLoader xlt = new MyXMLLevelLoader();
		 FileInputStream is =new FileInputStream("Test232323.xml");
		 l=xlt.LoadLevel(is);
		 l.print();
	}

}
