package Student_Comparator_JJH;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] a= {
				new Student (14069,"박**","수학",3),
				new Student (12051,"황**","경영",4),
				new Student (15002,"백**","디자",2),
				new Student (12481,"박**","영문",4),
				new Student (15505,"장**","수학",2),
				new Student (16962,"정**","경제",1),
				new Student (15376,"최**","컴퓨",2),
				new Student (16420,"진**","경영",2),
				new Student (11293,"김**","컴퓨",4),
				new Student (10184,"강**","경영",3),
				new Student (16104,"김**","컴퓨",1),
				new Student (10390,"한**","경영",4),
				new Student (14758,"이**","컴퓨",2),
		};
		
		Arrays.sort(a,Student.WITH_DEPT);
		print(a,"학과");
		Arrays.sort(a,Student.WITH_NAME);
		print(a,"이름");
		Arrays.sort(a,Student.WITH_GRADE);
		print(a,"학년");
		
	}
	public static void print(Student[] a,String key) {
		int i=0;
		System.out.println();
		System.out.println("     "+key+"(으)로 정렬");
		System.out.println("--------------------");
		for(Student temp:a) {
			System.out.println(temp.getID()+" "+temp.getName()+" "+temp.getDept()+"\t"+temp.getGrade()+"\n");
		}
	}

}
