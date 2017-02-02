package model.data;

import java.util.ArrayList;
import java.util.HashMap;

public class DisplayLevel {
	Level l;
	int flag;
	
	public DisplayLevel() {
		// TODO Auto-generated constructor stub
	}
	
	public DisplayLevel(Level l) {
		this.l=l;
	}
	
	public void show()
	{
		 HashMap<String, String> hm= new HashMap<String,String>();
		    hm.put("Box", "@");
		    hm.put("Wall", "#");
		    hm.put("Space", " ");
		    hm.put("Destination", "o");
		    hm.put("PlayableCharacter", "A");
		System.out.println("*****************");
		
		if((this.l.getItems() != null) && (this.l.getDest() != null))
		{
			for(ArrayList<GameObject> c : this.l.getItems())
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
