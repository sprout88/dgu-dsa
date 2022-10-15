package SeqSearch;

import java.util.Scanner;
import java.io.IOException;

public class ScanScreen {

	static int[] ScanFromScreen() throws IOException {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("요솟수: ");
		int num = stdIn.nextInt();
		int[] data = new int[num+1];              // 요솟수가 num인 배열

		for (int i = 0; i < num; i++) {
			System.out.print("data[" + i + "]: ");
			data[i] = stdIn.nextInt();
		}

		// System.out.print("검색할 값: ");       // 키값을 입력받음
		// int ky = stdIn.nextInt();
		return data;
	}
}