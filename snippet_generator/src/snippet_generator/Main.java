package snippet_generator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		snippet("14069박**수학",3);
		snippet("12051황**경영",4);
		snippet("15002백**디자인",2);
		snippet("12481박**영문",4);
		snippet("15505장**수학",2);
		snippet("16962정**경제",1);
		snippet("15376최**컴퓨터",2);
		snippet("16420진**경영",2);
		snippet("11293김**컴퓨터",4);
		snippet("10184강**경영",3);
		snippet("16104김**컴퓨터",1);
		snippet("10390한**경영",4);
		snippet("14758이**컴퓨터",2);


		

	}
	
	static void snippet(String str,int num) {
		
		String studentID=str.substring(0,5);
		String name=str.substring(5,8);
		String subject=str.substring(8,10);
		
		
		System.out.println("new Student ("+studentID+",\""+name+"\",\""+subject+"\","+num+"),");
		
	}

}
