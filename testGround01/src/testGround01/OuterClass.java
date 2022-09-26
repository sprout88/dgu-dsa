package testGround01;

public class OuterClass{
	private int a=10;
	OuterClass() {};
	
	public static class InnerClass{
		private int a = 20;
		public void print() {
			System.out.println(this);
		}
	}
}
