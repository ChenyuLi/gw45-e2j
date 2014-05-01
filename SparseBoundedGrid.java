//group-e2j
/*
1) For a grid with r rows and c columns, the sparse array has length r. Each of the linked lists has maximum
length c.

Implement the methods specified by the Grid interface using this data structure. Why is this a more timeefficient
implementation than BoundedGrid?

SparseBounded Grid is much more time efficient than Bounded Grid. As the size of grid gets very large, getOccupiedLocations()'s run time also increases (as we must traverse through the grid. In a BoundedGrid, the run time is O(r*c), as it traverse through every location on the grid. However, the runtime for our SparseBoundedGrid is simply(r+n), where n is the number of items in the grid. This is because, unlike BoundedGrid, which has constant row and col, SparseBoundedGrid only has a constant row. Its col depends on how many elements are in each SparseNode Linked List. Thus, it only traverse through each row, and then down each linked list until it reaches null. Basically, BoundedGrid has empty spaces that are eliminated by SparseBoundedGrid.
*/
import info.gridworld.grid.Grid;
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class SparseBoundedGrid<E> extends AbstractGrid<E>{
    private SparseGridNode[] occupant;
    private int col;
    private int row;

    public SparseBoundedGrid(int rows, int cols){
	col = cols;
	row = rows;
	occupant = new SparseGridNode[rows];
    }
    public int getNumRows(){
	return row;
    }
    public int getNumCols(){
	return col;
    }
    public boolean isValid(Location loc){
	return 0 <= loc.getRow() && loc.getRow() < getNumRows() && 0 <= loc.getCol() && loc.getCol() < getNumCols();
    }
    public ArrayList<Location> getOccupiedLocations(){
	ArrayList<Location> locations = new ArrayList<Location>();
	for (int r = 0; r < getNumRows(); r++){
	    SparseGridNode head = occupant[r];
	    while(head != null) {
		Location loc = new Location(r, head.getColumn());
		locations.add(loc);
		head = head.getNext();
	    }
	}
	return locations;
    }
    public E get(Location loc){
	if (isValid(loc)){
	    SparseGridNode head = occupant[loc.getRow()]; 
	    while(head != null){
		if(loc.getCol() == head.getColumn()){
		    return (E)head.getOccupant();
		}
		head = head.getNext();
	    }
	    return null;
	}
	else{
	    return null;
	}
       
    }
    public E put(Location loc, E obj){
	if (isValid(loc)){
	    E old = remove(loc);
	    SparseGridNode head = occupant[loc.getRow()];
	    occupant[loc.getRow()] = new SparseGridNode(obj, loc.getCol(), head);
	    return old;
	}
	else{
	    return null;
	}
    }
    public E remove(Location loc){
	if (isValid(loc)){
	    E obj = get(loc);
	    if (obj == null){
		return null;
	    } 
	    SparseGridNode head = occupant[loc.getRow()];
	    if(head != null){
		if(head.getColumn() == loc.getCol()){
		    occupant[loc.getRow()] = head.getNext();
		}
		else{
		    SparseGridNode next = head.getNext();
		    while(next!= null && next.getColumn() != loc.getCol()){
			head = head.getNext();
			next = next.getNext();
		    }
		    if(next != null){
			head.setNext(next.getNext());
		    }
		}
	    }
	    return obj;
	}
	else{
	    return null;
	}
    }
}
