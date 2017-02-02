package commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import model.data.Level;
import model.data.MyObjectLevelLoader;
import model.data.MyTextLevelLoader;
import model.data.MyXMLLevelLoader;

public class LoadLevelCommand implements Command {
	String add;
	HashMap<String, String> exten;
	Level l;//not in use at the moment
	
	public LoadLevelCommand(String loc) {
		exten = new HashMap<String,String>();
	    exten.put("xml", "1");
	    exten.put("obj", "2");
	    exten.put("txt", "3");
	    exten.put("object", "2");
	    exten.put("text", "3");
	    add=loc;
	}
	
	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public HashMap<String, String> getExten() {
		return exten;
	}

	public void setExten(HashMap<String, String> exten) {
		this.exten = exten;
	}

	public Level getL() {
		return l;
	}

	public void setL(Level l) {
		this.l = l;
	}

	@Override
	public void execute() throws ClassNotFoundException, IOException {
	    InputStream io = new FileInputStream(this.add);
	    this.add = this.add.substring(this.add.indexOf('.')+1);
	    this.add=add.toLowerCase();
	    
	    switch(exten.get(this.add))
	    {
	    case("1"):
	    	this.l= new MyXMLLevelLoader().LoadLevel(io);
	    	break;
	    case("2"):
	    	this.l= new MyObjectLevelLoader().LoadLevel(io);
	    	break;
	    case("3"):
	    	this.l=new MyTextLevelLoader().LoadLevel(io);
	    	break;
	    default:
	    	System.out.println("Wrong File Extensoin");
	    	break;
	    }
	    
	    



	}

}
