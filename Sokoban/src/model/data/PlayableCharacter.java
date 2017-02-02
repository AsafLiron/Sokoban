package model.data;

import java.util.HashMap;

public class PlayableCharacter extends Character {
	
	public PlayableCharacter() {
		str=1;
		flag=false;
	}
	
	public PlayableCharacter(Position2D pos) {
		flag=false;
		this.setPos(pos);
		this.setSolid(true);
		this.setType("PlayableCharacter");
		this.setOn(false);
	}
	
	public void onTarget(HashMap<Position2D, Destination> dest)
	{
		for(Position2D pos : dest.keySet())
		{
			if(this.getPos().onEach(pos)==true)
			{
				this.setOn(true);
			}
			else
			{
				this.setOn(false);
			}
		}
	}

}
