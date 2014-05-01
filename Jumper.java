//gw3--group thluffy

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
public class Jumper extends Actor{ 
    public Jumper(){ 
	setColor(Color.BLUE); 
    } 
    public Jumper(Color color){
	setColor(color); 
    } 
    public void act() { 
	if (canJump()){ 
	    jump(); 
	}
	else{
	    turn();
	} 
    } 
    public void turn(){ 
	setDirection(getDirection() + Location.HALF_RIGHT); //45deg
    } 
    public void jump(){
	Grid<Actor> myGrid = getGrid(); 
	if (myGrid == null){
	    return; 
	}
	Location realEstate = getLocation(); 
	Location next = realEstate.getAdjacentLocation(getDirection()); 
	Location twoAway = next.getAdjacentLocation(getDirection()); 
	if (myGrid.isValid(twoAway)){
	    moveTo(twoAway); 
	}
	else{
	    removeSelfFromGrid(); 
	}
    } 
    public boolean canJump(){
	Grid<Actor> myGrid = getGrid(); 
	if (myGrid == null){
	    return false;
	}
	Location realEstate = getLocation(); 
	Location next = realEstate.getAdjacentLocation(getDirection()); 
	if (!myGrid.isValid(next)){ 
	    return false;
	}
	Actor enemy = myGrid.get(next); 
	if (!((enemy == null)
	      || (enemy instanceof Flower) 
	      || (enemy instanceof Rock))){
	    return false;
	}
	Location twoAway = next.getAdjacentLocation(getDirection()); 
	if (!myGrid.isValid(twoAway)){ 
	    return false; 
	}
	enemy = myGrid.get(twoAway); 
	return ((enemy == null) || (enemy instanceof Flower)); 
    } 
} 
