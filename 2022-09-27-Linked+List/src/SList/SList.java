package SList;

import java.util.NoSuchElementException;


//Slide 8
public class SList <E extends Comparable<E>> {
	
	protected SNode<E> head;  // ���� ����Ʈ�� ù ��� ����Ŵ
	private   int  size;
	public SList(){       // ���� ����Ʈ ������
		head = null;
		size = 0;
	}

	// Slide 16
	public void deleteAfter(SNode<E> p){ // p�� ����Ű�� ����� ���� ��带 ����
		if (p == null) throw new NoSuchElementException();
		// �����̵� �κ��� �ڵ带 �Է��ϼ���~
		SNode<E> t=p.getNext();
		p.setNext(t.getNext());
		t.setNext(null);
		size--;		
	}

	// Slide 14
	public void deleteFront(){       // ����Ʈ�� ù ��� ����
		if (isEmpty()) throw new NoSuchElementException();
		// �����̵� �κ��� �ڵ带 �Է��ϼ���~
		if(size==-0) throw new NoSuchElementException();
		head = head.getNext();
		size--;
	}
	
	public SNode<E> getHead() { return head; }
	
	// Slide 12
	public void insertAfter(E newItem, SNode<E> p){ // ��� p �ٷ� ������ �� ��� ����
		// �����̵� �κ��� �ڵ带 �Է��ϼ���~
		p.setNext(new SNode<E>(newItem, p.getNext()));
		size++;
	}

	// Slide 11
	public void insertFront(E newItem){ // ���Ḯ��Ʈ �� �տ� �� ��� ����
		// �����̵� �κ��� �ڵ带 �Է��ϼ���~
		head=new SNode<E>(newItem,head);
		size++;
		
	}
	 
	 public boolean isEmpty() { return size == 0; }

	 public void print(){  // ���� ����Ʈ ������ �׸���� ���ʷ� ���
		for (SNode<E> p = head; p != null; p = p.getNext()) 
			System.out.print(p.getItem()+"\t ");
		System.out.println();
	}

	 // Slide 6
	 public int search(E target) {   // target�� Ž��  
		// �����̵� �κ��� �ڵ带 �Է��ϼ���~
		 SNode<E> p = head;
		 for(int k=0;k<size;k++) {
			 if(target==p.getItem()) return k;
			 p=p.getNext();
		 }
		 return -1;
	 }

	 public void setHead(SNode<E> n) { head= n;}
	 
	 public int size() { return size; }
}



 /*
	//�������� 2-17 �ΰ��� ���ĵ� ����Ʈ �պ�
	public SNode<Integer> mergeTwoLists(SNode<Integer> p1, SNode<Integer> p2){ 
		 SNode<Integer> head = new SNode<Integer>(0, null);
		 SNode<Integer> p = head;
		 while(p1!=null && p2!=null){
			 int c =  p1.getItem().compareTo(p2.getItem());
			 if (c < 0) {
				 p.setNext(p1);
				 p1=p1.getNext();
			 }
			 else{
				 p.setNext(p2);
				 p2=p2.getNext();
			 }
			 p = p.getNext();
		 }
		 if(p1 != null) p.setNext(p1);
		 if(p2 != null) p.setNext(p2);
		 return head.getNext();
	 }
	
	//�������� 2-19 ������ ����Ʈ
	public static SNode reverseList(SNode currentSNode){  
			 SNode previousSNode=null;  
			 SNode nextSNode;  
			 while(currentSNode!=null){  
				 nextSNode=currentSNode.getNext();  
				 currentSNode.setNext(previousSNode);  // ��ũ ������
				 previousSNode=currentSNode;  
				 currentSNode=nextSNode;  
			 }  
			 return previousSNode;  
	}
	
	//�������� 2-20 k�� ���ų� ���� ����Ʈ�� k���� ū ����Ʈ�� �и�
	 public void splitList(SNode<Integer> p, int k, SList<Integer> l1, SList<Integer> l2){ 
		 SNode<Integer> head1 = new SNode<Integer>(0, null);
		 SNode<Integer> head2 = new SNode<Integer>(0, null);
		 SNode<Integer> p1 = head1;
		 SNode<Integer> p2 = head2;
		 while(p !=null){
			 int c =  p.getItem().compareTo(k);
			 if (c <= 0) {
				 p1.setNext(p);
				 p1=p1.getNext();
			 }
			 else{
				 p2.setNext(p);
				 p2=p2.getNext();
			 }
			 p = p.getNext();
		 }
		 p1.setNext(null);
		 p2.setNext(null);
		 l1.setHead(head1.getNext());
		 l2.setHead(head2.getNext());
	 }
	 
	 // �������� 2-21 ����� ������ ��
	 public int commonSum(SList l2){ 
		 int sum = 0;
		 SNode<E> p1 = head;
		 SNode p2 = l2.getHead();
		 while(p1 !=null && p2 != null){
			 int c =  p1.getItem().compareTo(p2.getItem());
			 if (c == 0) {
				 sum += (int) p1.getItem();
				 p1=p1.getNext();
				 p2=p2.getNext();
			 }
			 else if (c  < 0) 	p1=p1.getNext();
			 else 				p2=p2.getNext();  
		 }
		 return sum;
	 }
	 
	 // �������� 2-22 �߰� ��� ã��
	 public SNode findMiddleSNode(SNode head){  
		 SNode slowPointer, fastPointer;   
		 slowPointer = fastPointer = head;    
		 while(fastPointer != null) {   
			 fastPointer = fastPointer.getNext();   
			 if(fastPointer != null && fastPointer.getNext() != null) {   
				 slowPointer = slowPointer.getNext();   
				 fastPointer = fastPointer.getNext();   
			 }   
		 }   
		 return slowPointer;
	}

	// ȯ������Ʈ ����� 
	public void createCycle(){  
		 SNode<E> p = head;
		 SNode<E> q = null;
		 while(p != null){
			 q = p;
			 p = p.getNext();
		 }
		 q.setNext(head);
	 }
	
	// �������� 2-23 ����Ŭ �˻�
	 public boolean cycleDetector() {  
		 SNode<E> fastPtr = head;  
		 SNode<E> slowPtr = head;  
		 while (fastPtr != null && fastPtr.getNext() != null) {  
			 fastPtr = fastPtr.getNext().getNext();  
			 slowPtr = slowPtr.getNext();  
			 if (slowPtr == fastPtr)  
				 return true;  	  
		 }  
		 return false;  
	 }
	 
	 */

