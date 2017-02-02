package model.data;

import java.io.Serializable;

public abstract class GameObject implements Serializable {
	Position2D pos;
	String type;
	Boolean solid;
	Boolean on;
	
	public Position2D getPos() {
		return pos;
	}
	public void setPos(Position2D pos) {
		this.pos = new Position2D(pos);
	}
	public void setPos(int x,int y) {
		this.pos=new Position2D(x,y);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getSolid() {
		return solid;
	}
	public void setSolid(Boolean solid) {
		this.solid = solid;
	}
	public Boolean getOn() {
		return on;
	}
	public void setOn(Boolean on) {
		this.on = on;
	}
	

}
