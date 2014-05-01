//group e2j
/*
3. Consider this implementation of an unbounded grid in which all valid locations have non-negative row and
column values. The constructor allocates a 16 x 16 array. When a call is made to the put method with a row
or column index that is outside the current array bounds, double both array bounds until they are large enough,
construct a new square array with those bounds, and place the existing occupants into the new array.
Implement the methods specified by the Grid interface using this data structure. What is the Big-Oh
efficiency of the get method? What is the efficiency of the put method when the row and column index
values are within the current array bounds? What is the efficiency when the array needs to be resized?

get: O(1), just [][]
put: O(1) if new element put within the current bounds, just [][]
     O(n^2), where n is the array before resizing. As elements of the old array must be copied into new array 
*/

import info.gridworld.grid.*;
import java.util.ArrayList;
import java.util.*;

public class UnboundedGrid2<E> extends AbstractGrid<E>{
    private Object[][] occupant;
    private int n; 
    public UnboundedGrid2(){
	n = 16;
	occupant = new Object[n][n];
    }
    public int getNumRows(){
	return -1;
    }
    public int getNumCols(){
	return -1;
    }
    public boolean isValid(Location loc){
	return loc.getRow() >= 0 && loc.getCol() >= 0;
    }
    public ArrayList<Location> getOccupiedLocations(){
	ArrayList<Location> locations = new ArrayList<Location>();
	for (int r = 0; r < n; r++){
	    for (int c = 0; c < n; c++){
		Location loc = new Location(r, c);
		if (get(loc) != null){
		    locations.add(loc);
		}
	    }
	}
	return locations;
    }
    public E get(Location loc){
	if (isValid(loc)){
	    if(loc.getRow() >= n || loc.getCol() >= n){
		return null;
	    }
	    return (E) occupant[loc.getRow()][loc.getCol()];
	}
	else{
	    return null;
	}
    }
    public E put(Location loc, E obj){
	if (loc != null && obj!= null){
	    if (loc.getRow() >= n || loc.getCol() >= n){
		int size = n;
		while (loc.getRow() >= size || loc.getCol() >= size){
		    size *= 2;
		}
		Object[][] temp = new Object[size][size];
		for(int r = 0; r < n; r++){
		    for(int c = 0; c < n; c++){
			temp[r][c] = occupant[r][c];
		    }
		}
		occupant = temp;
		n = size;
	    }
	    E old = get(loc);
	    occupant[loc.getRow()][loc.getCol()] = obj;
	    return old;
	}
	else{
	    return null;
	}
    }
    public E remove(Location loc){
	if (isValid(loc)){
	    if(loc.getRow() >= n || loc.getCol() >= n){
		return null;
	    }
	    E r = get(loc);
	    occupant[loc.getRow()][loc.getCol()] = null;
	    return r;
	}
	else{
	    return null;
	}
    }
}
