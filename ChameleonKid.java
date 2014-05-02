import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.ArrayList;

/**
 * A <code>ChameleonKid</code> takes on the color of neighboring actors 
 * immediately in front or behind as it moves through the grid. <br />
 */
public class ChameleonKid extends ChameleonCritter
{

    /**
     * Gets the actors for processing. Implemented to return the actors that
     * occupy neighboring grid locations. Override this method in subclasses to
     * look elsewhere for actors to process.<br />
     * Postcondition: The state of all actors is unchanged.
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> arr = new ArrayList<Actor>();
        int[] dirs =
            { Location.AHEAD, Location.HALF_CIRCLE };
        for (Location loc : getLocationsInDirections(dirs))
            if (getGrid().get(loc) != null)
                arr.add(getGrid().get(loc));
        return arr;
    }
        
     /**
     * Finds the valid adjacent locations of this critter in different
     * directions.
     * @param directions - an array of directions (which are relative to the
     * current direction)
     * @return a set of valid locations that are neighbors of the current
     * location in the given directions
     */
    public ArrayList<Location> getLocationsInDirections(int[] directions)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();
    
        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc))
                locs.add(neighborLoc);
        }
        return locs;
    }
}
