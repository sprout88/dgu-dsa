package recursion_JJH;

public class Recursion {
	public void recurse(int count) {
		
		if(count<=0)
			System.out.println(".");
		else {
			System.out.println(count+" *");
			recurse(count-1);
		}
	}
	
	public static void main(String[] args) {
		Recursion r = new Recursion();
		r.recurse(5);
		
	}
}
