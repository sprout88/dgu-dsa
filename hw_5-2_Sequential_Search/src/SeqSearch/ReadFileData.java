package SeqSearch;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileData {

	// 파일에서 데이터를 읽어 오기
	static int[] ReadData(String fname) throws IOException {
		int rdata[];
		int size = 0;
			
		rdata = new int[1];     // 최초로 1개의 원소를 가진 배열 생성
		size = 0;               // 항목 수를 0으로 초기화
		
		BufferedReader br = new BufferedReader(new FileReader(fname));
		
		while(true) {
			
			// 한 줄 단위로 읽어 온다.
            String line = br.readLine();
            if (line==null) break;  // 더 이상 읽을 라인이 없을 경우 while 문을 빠져나간다.
            System.out.println(line);
            
            // String 문자열을 구분자 문자열을 기준으로 분리한다.
            String[] result = line.split(" ");  // result는 " "를 구분자로 단어를 분리한다.
            // System.out.println(result.length);
            
            // 요소 수에 맞게 결과 데이터 rdata 길이 조정
            size = size + result.length + 1; 
            int[] t = new int[size];   // newSize 크기의 새로운 배열 t 생성
    		for (int i = 0; i < rdata.length; i++)
    			t[i] = rdata[i];                    // 배열 s를 배열 t로 복사 
    		rdata = (int[]) t;     
    		
            // 문자열을 정수로 변환하는 코드
            for (int i=0; i < result.length; i++) {
            	 try {
                     int number = Integer.parseInt(result[i]);
            		 // Integer number = Integer.valueOf(result[i]);
                     // System.out.println(number);
                     rdata[i] = number;
                 }
                 catch (NumberFormatException ex) {
                     // 정수형이 아닌 경우 예외처리 메시지를 출력한다.
                	 // ex.printStackTrace();
                 }
            }
        }
        br.close();
        return rdata;
	}

}
