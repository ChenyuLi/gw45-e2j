import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * A <code>RockHound</code> removes any rocks from the grid.
 * It process actors and moves like a Critter <br />
 */
public class RockHound extends Critter
{

    /**
     * Processes the elements of <code>actors</code>. Implemented to "eat" (i.e. remove) all rocks. <br />
     * Postcondition: (1) The state of all actors in the grid other than this
     * critter and the elements of <code>actors</code> is unchanged. (2) The
     * location of this critter is unchanged.
     * @param actors the actors to be processed
     */
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if ( a instanceof Rock )
                a.removeSelfFromGrid();
        }
    }

}
