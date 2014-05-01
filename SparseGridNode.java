//group-e2j
public class SparseGridNode{
    private Object occupant;
    private int col;
    private SparseGridNode next;
    public SparseGridNode(Object occidental, int column,SparseGridNode proximo){
	occupant = occidental;
	col = column;
	next = proximo;
    }
    //column and colNum are anagrams!!!
    public Object getOccupant(){
	return occupant;
    }
    public int getColumn(){
	return col;
    }
    public SparseGridNode getNext(){
	return next;
    }
    public void setOccupant(Object occidental){
	occupant = occidental;
    }
    public void setNext(SparseGridNode nuevoProximo){
	next = nuevoProximo;
    }
}
