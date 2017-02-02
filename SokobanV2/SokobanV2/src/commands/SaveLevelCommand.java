package commands;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Scanner;

import model.data.Level;
import model.data.ObjectLevelSaver;
import model.data.TextLevelSaver;
import model.data.XmlLevelSaver;

public class SaveLevelCommand implements Command {
	HashMap<String, String> exten;
	Level l;
	String s;
	String name;
	
	public SaveLevelCommand(Level l,String s) {
		this.l=l;
		this.s=s;
		exten=new HashMap<String,String>();
	    exten.put("xml", "1");
	    exten.put("obj", "2");
	    exten.put("txt", "3");
	}	

	
	@Override
	public void execute() throws IOException {
		System.out.println("Choose name to save the level");
		Scanner lc = new Scanner(System.in);
		name=lc.next();
		OutputStream os = new FileOutputStream(new File(name));
	    switch(exten.get(s))
	    {
	    case("1"):
	    	new XmlLevelSaver().saveLevel(os, l);
	    	break;
	    case("2"):
	    	new ObjectLevelSaver().saveLevel(os, l);
	    	break;
	    case("3"):
	    	new TextLevelSaver().saveLevel(os,l);
	    	break;
	    default:
	    	System.out.println("Error");
	    		
	    }


	}



}
