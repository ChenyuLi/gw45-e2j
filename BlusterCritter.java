import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;

import java.util.ArrayList;

/**
 * A <code>BlusterCritter</code> changes color depending on if the number
 * of critters within two steps of its current location is greater than or
 * less than its courage. <br />
 */
public class BlusterCritter extends Critter
{

    private static final double DARKENING_FACTOR = 0.05;
    private static final double BRIGHTENING_FACTOR = 0.05;

    private int courage;

    public BlusterCritter( int c ) {
	super();
	courage = c;
    }
    

    /**
     * Gets the actors for processing. Implemented to return the actors that
     * occupy neighboring grid locations within two steps from current location.<br />
     * Postcondition: The state of all actors is unchanged.
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
	ArrayList<Actor> arr = new ArrayList<Actor>();

	Location loc = getLocation();
	for( int r = loc.getRow()-2; r < loc.getRow()+2; r++ )
	    for( int c = loc.getCol()-2; c < loc.getCol()+2; c++ ) {
		Location newLoc = new Location( r, c );
		arr.add( getGrid().get(newLoc) );
	    }

	return arr;
    }


    /**
     * Looks at number of actors. If the number of neighbors is less than 
     * its courage, the color of the critter will brighten. If the number
     * of neighbors is greater than its courage, the color of the critter
     * will darken.
     */
    public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        if (n == 0)
	    return;
	else if ( n < c ) {
	    Color c = getColor();
	    int red = (int) (c.getRed() * (1 + BRIGHTENING_FACTOR));
	    int green = (int) (c.getGreen() * (1 + BRIGHTENING_FACTOR));
	    int blue = (int) (c.getBlue() * (1 + BRIGHTENING_FACTOR));
	    
	    setColor(new Color(red, green, blue));
	}
	else if ( n > c ) {
	    Color c = getColor();
	    int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
	    int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
	    int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
	    
	    setColor(new Color(red, green, blue));
	}
    }

}
