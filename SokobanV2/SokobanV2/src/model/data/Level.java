package model.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Level implements Serializable {
	
    ArrayList<ArrayList<GameObject>> items;
    HashMap<Position2D, Destination> dest;
    Boolean finished;
    ArrayList<PlayableCharacter> actors;

    
    public Level() {
		items=new ArrayList<ArrayList<GameObject>>();
		dest=new HashMap<Position2D,Destination>();
		finished=false;
		actors = new ArrayList<PlayableCharacter>();
	}
    
    
	
		
	public ArrayList<PlayableCharacter> getActors() {
		return actors;
	}
	public void setActors(ArrayList<PlayableCharacter> actors) {
		this.actors = actors;
	}
	public ArrayList<ArrayList<GameObject>> getItems() {
		return items;
	}
	public void setItems(ArrayList<ArrayList<GameObject>> items) {
		this.items = items;
	}
	public HashMap<Position2D, Destination> getDest() {
		return dest;
	}
	public void setDest(HashMap<Position2D, Destination> dest) {
		this.dest = dest;
	}
	public Boolean getFinished() {
		return finished;
	}
	public void setFinished(Boolean finished) {
		this.finished = finished;
	}
	
	public void print()
	{
		 HashMap<String, String> hm= new HashMap<String,String>();
		    hm.put("Box", "@");
		    hm.put("Wall", "#");
		    hm.put("Space", " ");
		    hm.put("Destination", "o");
		    hm.put("PlayableCharacter", "A");
		System.out.println("*****************");
		
		if((this.getItems() != null) && (this.getDest() != null))
		{
			for(ArrayList<GameObject> c : this.getItems())
			{
				for(GameObject obj : c)
				{
					System.out.print(hm.get(obj.getType()));
				}
				System.out.println();
			}
		}
	}
    
    

}
