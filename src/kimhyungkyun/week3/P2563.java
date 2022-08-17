package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2563 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] papers = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			papers[i][0] = Integer.parseInt(st.nextToken());
			papers[i][1] = Integer.parseInt(st.nextToken());
		} // 정보 입력 받기 끝
		int sum=0;
		int[][] plane = new int[100][100];
		for(int n=0;n<N;n++) {
			for(int i=0;i<10;i++) {
				for(int j=0;j<10;j++){
					if(plane[papers[n][0]+i][papers[n][1]+j]==0) {
						plane[papers[n][0]+i][papers[n][1]+j]=1;
						sum++;
					}
				}
			}
		}//N개 다 색칠
		
		System.out.println(sum);
	
		br.close();
	}
}

// 김소정: 저는 색칠한 다음에 다시 칠해진 부분의 면적을 구했는데, 칠하면서 동시에 구하는 방법도 좋은 것 같습니다 ㅎㅎ
//P소정 : 저번에 제가 말씀드린 팁을 적용하신건가?아닐수도 있지만 ! 만약 그런거면 뿌듯하고 감사하네요!!
