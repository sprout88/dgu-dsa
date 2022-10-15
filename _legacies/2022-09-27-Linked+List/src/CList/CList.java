package CList;

import java.util.NoSuchElementException;

public class CList <E> {
	private CNode<E> last; // ����Ʈ�� ������ ���(�׸�)�� ����Ų��. 
	private int  size; // ����Ʈ�� �׸�(���) ��
	
	public CList() {  // ����Ʈ ������
		// �����̵� �κ��� �ڵ带 �Է��ϼ���~
		
	}
	
	public CNode<E> delete() {  // last�� ����Ű�� ����� ���� ��带 ����
		if (isEmpty()) throw new NoSuchElementException();
		// �����̵� �κ��� �ڵ带 �Է��ϼ���~
		if(isEmpty()) throw new NoSuchElementException();
		CNode<E> x = last.getNext();
		if(x==last) last=null;
		else {
			last.setNext(x.getNext());
			x.setNext(null);
		}
		size--;
		return x;
		
	}
	public void insert(E newItem) {  // last�� ����Ű�� ����� ������ ����� ����
		// �����̵� �κ��� �ڵ带 �Է��ϼ���~
		CNode<E> newNode=new CNode<E>(newItem,null);
			if(last==null) {
				newNode.setNext(newNode);
				last=newNode;
			}else {
				newNode.setNext(last.getNext());
				last.setNext(newNode);
			}
			size++;
	}

	
	public boolean isEmpty() { return size == 0;}
	
	public void print(){  // ���� ����Ʈ ������ �׸���� ���ʷ� ���
		if (size > 0){
			int i = 0;
			for (CNode<E> p = last.getNext(); i<size ; p = p.getNext(), i++) 
					System.out.print(p.getItem()+"\t ");
		}
		else
			System.out.println("����Ʈ �������.");
	}

	public int size() { return size;}
}
