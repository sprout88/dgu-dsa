package CList;

public class CNode <E>{
	
	private E item;
	private CNode<E> next;
	public CNode(E newItem,CNode<E> node) {
		item = newItem;
		next = node;
	}
	
	public E getItem() {return item;}
	public CNode<E> getNext(){return next;}
	public void setItem(E newItem) {item=newItem;}
	public void setNext(CNode<E> newNext) {next=newNext;}
	
}
