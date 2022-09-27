package CList;

import java.util.NoSuchElementException;

public class CList <E> {
	private CNode<E> last; // 리스트의 마지막 노드(항목)을 가리킨다. 
	private int  size; // 리스트의 항목(노드) 수
	
	public CList() {  // 리스트 생성자
		// 슬라이드 부분의 코드를 입력하세요~
		
	}
	
	public CNode<E> delete() {  // last가 가리키는 노드의 다음 노드를 제거
		if (isEmpty()) throw new NoSuchElementException();
		// 슬라이드 부분의 코드를 입력하세요~
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
	public void insert(E newItem) {  // last가 가리키는 노드의 다음에 새노드 삽입
		// 슬라이드 부분의 코드를 입력하세요~
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
	
	public void print(){  // 연결 리스트 노드들의 항목들을 차례로 출력
		if (size > 0){
			int i = 0;
			for (CNode<E> p = last.getNext(); i<size ; p = p.getNext(), i++) 
					System.out.print(p.getItem()+"\t ");
		}
		else
			System.out.println("리스트 비어있음.");
	}

	public int size() { return size;}
}
