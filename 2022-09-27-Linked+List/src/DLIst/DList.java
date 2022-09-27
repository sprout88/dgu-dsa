package DLIst;
import java.util.NoSuchElementException;

public class DList<E> {
	protected DNode<E> head, tail;
	protected int size;
	public DList() {
		head=new DNode<E>(null,null,null);
		tail=new DNode<E>(null,head,null);
		head.setNext(tail);
		size=0;
	}
	
	public void insertBefore(DNode<E> p,E newItem) {
		DNode<E> t = p.getPrevious();
		DNode<E> newNode=new DNode<E>(newItem,t,p);
		p.setPrevious(newNode);
		t.setNext(newNode);
		size++;
	}
	public void insertAfter(DNode<E> p,E newItem) {
		DNode<E> t=p.getNext();
		DNode<E> newNode = new DNode<E>(newItem,p,t);
		t.setPrevious(newNode);
		p.setNext(newNode);
		size++;
	}
	public void delete(DNode<E> x) {
		if(x==null) throw new NoSuchElementException();
		DNode<E> f=x.getPrevious();
		DNode<E> r=x.getNext();
		f.setNext(r);
		r.setPrevious(f);
		size--;
	}
	public boolean isEmpty() {return size==0;}
	public void print() {
		if(size>0)
			for(DNode<E> p=head.getNext();p!=tail;p=p.getNext())
				System.out.print(p.getItem()+"\t");
		else
			System.out.println("list is Empty");
	}
	public int size() {return size;}

}
