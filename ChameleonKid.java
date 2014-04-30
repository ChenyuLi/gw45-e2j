import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

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
	Location front = getLocation().getAdjacentLocation( getDirection() ); //actor immediately in front
	Location back = getLocation().getAdjacentLocation( getDirection() + 180 ); //actor immediately behind

	ArrayList<Actor> arr = new ArrayList<Actor>();
	arr.add( getGrid().get( front ) );
	arr.add( getGrid().get( back ) );
        return arr;
    }

}
