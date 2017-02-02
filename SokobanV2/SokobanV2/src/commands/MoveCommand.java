package commands;

import model.data.Box;
import model.data.Destination;
import model.data.Level;
import model.data.PlayableCharacter;
import model.data.Space;
import model.policy.MySokobanPolicy;

public class MoveCommand implements Command {
	Level l;
	String way;
	MySokobanPolicy msp;
	PlayableCharacter pc;
	Destination temp;
	int flag;
	Box bx;
	int bxflag;
	
	
	public MoveCommand(Level l,String way) {
		this.l=l;
		this.way=way;
		msp=null;
		pc=l.getActors().get(0);
		flag=0;
		temp=null;
		bx=null;
		bxflag=0;
	}

	@Override
	public void execute() {
		int x=l.getActors().get(0).getPos().getX();
		int y=l.getActors().get(0).getPos().getY();
		way.toLowerCase();
		if(way.equals("up"))
		{
			msp=new MySokobanPolicy(this.l);
			if(msp.moveUp(l.getActors().get(0))==true)
			{
				if(l.getDest().get(pc.getPos())!=null)
				{
					temp=l.getDest().get(pc.getPos());
					flag=1;
				}
				pc.getPos().setY(y-1);
				
				if(l.getItems().get(y-1).get(x).getType().equals("Box"))
				{
					bx=(Box) l.getItems().get(y-1).get(x);
					if(l.getDest().get(bx.getPos())!=null)
					{
						temp=l.getDest().get(bx.getPos());
						bxflag=1;
					}
					bx.getPos().setY(this.bx.getPos().getY()-1);
					l.getItems().get(y-1).remove(x);
					l.getItems().get(bx.getPos().getY()-1).set(x, bx);
					if(bxflag==1)
					{
						l.getItems().get(y-1).remove(x);
						l.getItems().get(y-1).set(x, temp);
					}
					else
					{
						Space sp=new Space(x,y);
						l.getItems().get(y).set(x, sp);
					}
					
				}
				
				l.getActors().set(0, pc);
				l.getItems().get(y-1).set(x, pc);
				
				if(flag==1)
				{
				l.getItems().get(y).remove(x);
				l.getItems().get(y).set(x, temp);
				}
				else
				{
					Space sp=new Space(x,y);
					l.getItems().get(y).set(x, sp);
				}

			}
		}
		if(way.equals("down"))
		{
			msp=new MySokobanPolicy(this.l);
			if(msp.moveUp(l.getActors().get(0))==true)
			{
				if(l.getDest().get(pc.getPos())!=null)
				{
					temp=l.getDest().get(pc.getPos());
					flag=1;
				}
				pc.getPos().setY(y+1);
				l.getActors().set(0, pc);
				l.getItems().get(y+1).set(x, pc);
				if(flag==1)
				{
				l.getItems().get(y).remove(x);
				l.getItems().get(y).set(x, temp);
				}
				else
				{
					Space sp=new Space(x,y);
					l.getItems().get(y).set(x, sp);
				}
			}
		}
		if(way.equals("right"))
		{
			msp=new MySokobanPolicy(this.l);
			if(msp.moveUp(l.getActors().get(0))==true)
			{
				if(l.getDest().get(pc.getPos())!=null)
				{
					temp=l.getDest().get(pc.getPos());
					flag=1;
				}
				pc.getPos().setX(x+1);
				l.getActors().set(0, pc);
				l.getItems().get(y).set(x+1, pc);
				if(flag==1)
				{
				l.getItems().get(y).remove(x);
				l.getItems().get(y).set(x, temp);
				}
				else
				{
					Space sp=new Space(x,y);
					l.getItems().get(y).set(x, sp);
				}
			}
		}
		if(way.equals("left"))
		{
			msp=new MySokobanPolicy(this.l);
			if(msp.moveUp(l.getActors().get(0))==true)
			{
				if(l.getDest().get(pc.getPos())!=null)
				{
					temp=l.getDest().get(pc.getPos());
					flag=1;
				}
				pc.getPos().setX(x-1);
				l.getActors().set(0, pc);
				l.getItems().get(y).set(x-1, pc);
				if(flag==1)
				{
				l.getItems().get(y).remove(x);
				l.getItems().get(y).set(x, temp);
				}
				else
				{
					Space sp=new Space(x,y);
					l.getItems().get(y).set(x, sp);
				}
			}
		}
		
	}

}
