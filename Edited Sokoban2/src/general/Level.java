package general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import model.data.Box;
import model.data.GameObject;
import model.data.PlayableCharacter;
import model.data.Position2D;

public class Level implements Serializable {
	
    ArrayList<ArrayList<GameObject>> items;
    HashMap<Position2D, Box> boxes;
    Boolean finished;
    ArrayList<PlayableCharacter> actors;

    
    public Level() {
		items=new ArrayList<ArrayList<GameObject>>();
		boxes=new HashMap<Position2D,Box>();
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
	public HashMap<Position2D, Box> getDest() {
		return boxes;
	}
	public void setDest(HashMap<Position2D, Box> boxes) {
		this.boxes = boxes;
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
	
	
	public int getWidth()
	{
		int max=0;
		
		if((this.getItems() != null) && (this.getDest() != null))
		{
			for(ArrayList<GameObject> c : this.getItems())
			{
				if(max<c.size())
					max=c.size();
			}
		}
		
		return max;
		
	}
	
	public int getHeight()
	{
		int max=0;
		
		if((this.getItems() != null) && (this.getDest() != null))
		{
			if(max<this.getItems().size())
				max=this.getItems().size();
		}
		
		return max;
	}
    
    

}
