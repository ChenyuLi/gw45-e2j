import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * A <code>KingCrab</code> looks at a limited set of neighbors when it eats and moves.
 * Causes each actor it processes to move one location further away from the KingCrab.
 * <br />
 */
public class KingCrab extends CrabCritter
{

    /**
     * Processes the elements of <code>actors</code>. New actors may be added
     * to empty locations. Actors move one location further away from KingCrab. 
     * If the actor cannot move away, it is removed from grid. <br />
     * Postcondition: (1) The state of all actors in the grid other than this
     * critter and the elements of <code>actors</code> is unchanged. (2) The
     * location of this critter is unchanged.
     * @param actors the actors to be processed
     */
    public void processActors(ArrayList<Actor> actors)
    {
	for (Actor a : actors)
        {
	    ArrayList<Location> arr = getGrid().getEmptyAdjacentLocations(a.getLocation());
	    if( arr.size() == 0 )
                a.removeSelfFromGrid();
	    int r = (int) (Math.random()*arr.size());
	    a.moveTo( arr.get(r) );
        }
    }

}
