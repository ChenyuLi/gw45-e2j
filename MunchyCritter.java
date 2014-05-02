//Justin Strauss Eric Li Joanne Yang
//APCS pd08
//HW35 -- GridWorld, Part 5
//2014-04-30

// A new type of Critter has appeared on the scene:

//MunchyCritter...I choose you! For a reptile to consume non-organic food and ebb away in pain...I truly admire your bravery and stupidity.

// MunchyCritter Specs:
// MunchyCritter will extend Critter. A MunchyCritter looks at all of the neighbors within one step of its current location. It will then proceed to eat (remove) all actors within one stepo of its current location. However, if the actor that is removed is a Rock, then the MunchyCritter dies. If there are no actors within a one step radius of its current location, the MunchyCritter will move in a random direction for one step.

// MunchyCritter Test Cases:
// First Test Case: A MunchyCritter is placed in a grid where there are only actors except for Rocks. 
// The MunchyCritter would be able to eat anything in its radius and keep moving if there is nothing to eat.
// Second Test Case: A MunchyCritter is placed in a grid where there are only actors that are Rocks.
// The MunchyCritter move around and then if it encounters a rock, it will eat and then proceed to "die" or remove itself.
// Third Test Case: A MunchyCritter is placed at the edge of the grid.
// It should be able to discern which direction is a valid location to step in and proceed to step in the correct path.
// Fourth Test Case: When the MunchyCritter is surrounded by Actors other than Rocks.
// All Actors should be consumed.
// Fifth Test Case: When the MunchyCritter is surrounde by Rocks
// All rocks should be consumed and the MunchyCritter will remove itself. 

//ERRATA
//Addendum: MunchyCritter surrounded by both actors and rocks, everything should disappear

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.awt.Color;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;

public class MunchyCritter extends Critter{
    
    public MunchyCritter(){
	setColor(Color.RED);
    }
    public void act() {
	if (getGrid() == null)
	    return;
	Grid grid = getGrid();
	ArrayList<Actor> actors = getActors();
	if (actors.size() == 0) {
	    ArrayList<Location> locs = grid.getValidAdjacentLocations(this.getLocation());
	    int rand = (int) (locs.size() * Math.random());
	    makeMove(locs.get(rand));
	}
	else
	    processActors(actors);
    }

    public void processActors(ArrayList<Actor> actors) {
	boolean die = false;
	for (Actor a:actors) {
	    a.removeSelfFromGrid();
	    if (a instanceof Rock)
		die = true;
	}
	if(die){
	    this.removeSelfFromGrid();
	}
    }

    public static void main (String[] args) {
	ActorWorld world = new ActorWorld();
	/*
	//Test Case 1
        world.add(new Location(7, 5), new Flower());
        world.add(new Location(5, 4), new Flower());
        world.add(new Location(5, 7), new Flower());
        world.add(new Location(7, 3), new Flower());
        world.add(new Location(7, 8), new MunchyCritter());
	
	//Test Case 2
        world.add(new Location(7, 5), new Rock());
        world.add(new Location(5, 4), new Rock());
        world.add(new Location(5, 7), new Rock());
        world.add(new Location(7, 3), new Rock());
        world.add(new Location(7, 8), new MunchyCritter());
	
	
	//Test Case 3
        world.add(new Location(7, 5), new Rock());
        world.add(new Location(5, 4), new Rock());
        world.add(new Location(5, 7), new Rock());
        world.add(new Location(7, 3), new Rock());
        world.add(new Location(0, 0), new MunchyCritter());
	/

	//Test Case 4
        world.add(new Location(8, 9), new Actor());
	world.add(new Location(9, 8), new Actor());
	world.add(new Location(9, 9), new Actor());
	world.add(new Location(9, 7), new Actor());
        world.add(new Location(7,8), new Actor());
	world.add(new Location(8, 7), new Actor());
        world.add(new Location(7, 9), new Actor());
        world.add(new Location(7, 7), new Actor());
        world.add(new Location(8, 8), new MunchyCritter());
	
	//Test Case 5
        world.add(new Location(8, 9), new Rock());
	world.add(new Location(9, 8), new Rock());
	world.add(new Location(9, 9), new Rock());
	world.add(new Location(9, 7), new Rock());
        world.add(new Location(7,8), new Rock());
	world.add(new Location(8, 7), new Rock());
        world.add(new Location(7, 9), new Rock());
        world.add(new Location(7, 7), new Rock());
        world.add(new Location(8, 8), new MunchyCritter());   
	*/
	//Addendum
	world.add(new Location(8, 9), new Actor());
	world.add(new Location(9, 8), new Actor());
	world.add(new Location(9, 9), new Rock());
	world.add(new Location(9, 7), new Rock());
        world.add(new Location(7, 8), new Rock());
	world.add(new Location(8, 7), new Rock());
        world.add(new Location(7, 9), new Rock());
        world.add(new Location(7, 7), new Rock());
        world.add(new Location(8, 8), new MunchyCritter());   
	
        world.show();
    }

}
