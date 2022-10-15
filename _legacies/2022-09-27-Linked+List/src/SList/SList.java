package SList;

import java.util.NoSuchElementException;


//Slide 8
public class SList <E extends Comparable<E>> {
	
	protected SNode<E> head;  // 연결 리스트의 첫 노드 가리킴
	private   int  size;
	public SList(){       // 연결 리스트 생성자
		head = null;
		size = 0;
	}

	// Slide 16
	public void deleteAfter(SNode<E> p){ // p가 가리키는 노드의 다음 노드를 삭제
		if (p == null) throw new NoSuchElementException();
		// 슬라이드 부분의 코드를 입력하세요~
		SNode<E> t=p.getNext();
		p.setNext(t.getNext());
		t.setNext(null);
		size--;		
	}

	// Slide 14
	public void deleteFront(){       // 리스트의 첫 노드 삭제
		if (isEmpty()) throw new NoSuchElementException();
		// 슬라이드 부분의 코드를 입력하세요~
		if(size==-0) throw new NoSuchElementException();
		head = head.getNext();
		size--;
	}
	
	public SNode<E> getHead() { return head; }
	
	// Slide 12
	public void insertAfter(E newItem, SNode<E> p){ // 노드 p 바로 다음에 새 노드 삽입
		// 슬라이드 부분의 코드를 입력하세요~
		p.setNext(new SNode<E>(newItem, p.getNext()));
		size++;
	}

	// Slide 11
	public void insertFront(E newItem){ // 연결리스트 맨 앞에 새 노드 삽입
		// 슬라이드 부분의 코드를 입력하세요~
		head=new SNode<E>(newItem,head);
		size++;
		
	}
	 
	 public boolean isEmpty() { return size == 0; }

	 public void print(){  // 연결 리스트 노드들의 항목들을 차례로 출력
		for (SNode<E> p = head; p != null; p = p.getNext()) 
			System.out.print(p.getItem()+"\t ");
		System.out.println();
	}

	 // Slide 6
	 public int search(E target) {   // target을 탐색  
		// 슬라이드 부분의 코드를 입력하세요~
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
	//연습문제 2-17 두개의 정렬된 리스트 합병
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
	
	//연습문제 2-19 역방향 리스트
	public static SNode reverseList(SNode currentSNode){  
			 SNode previousSNode=null;  
			 SNode nextSNode;  
			 while(currentSNode!=null){  
				 nextSNode=currentSNode.getNext();  
				 currentSNode.setNext(previousSNode);  // 링크 역으로
				 previousSNode=currentSNode;  
				 currentSNode=nextSNode;  
			 }  
			 return previousSNode;  
	}
	
	//연습문제 2-20 k와 같거나 작은 리스트와 k보다 큰 리스트로 분리
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
	 
	 // 연습문제 2-21 공통된 숫자의 합
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
	 
	 // 연습문제 2-22 중간 노드 찾기
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

	// 환형리스트 만들기 
	public void createCycle(){  
		 SNode<E> p = head;
		 SNode<E> q = null;
		 while(p != null){
			 q = p;
			 p = p.getNext();
		 }
		 q.setNext(head);
	 }
	
	// 연습문제 2-23 싸이클 검사
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

