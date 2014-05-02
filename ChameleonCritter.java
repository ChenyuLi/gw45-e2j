import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;

import java.util.ArrayList;

/**
 * A <code>ChameleonCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 */
public class ChameleonCritter extends Critter
{
	
    //similar implementation of a Flower
    private static final double DARKENING_FACTOR = 0.05;

    /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors, the color of the
     * critter will darken.
     */
    public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        if (n == 0) {
	    Color c = getColor();
	    int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
	    int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
	    int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
	    
	    setColor(new Color(red, green, blue));
	    return;
	}

        int r = (int) (Math.random() * n);
        Actor other = actors.get(r);
        setColor(other.getColor());
    }

}
