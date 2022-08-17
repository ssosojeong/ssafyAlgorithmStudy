package src.kimsojeong.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2563 {
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		map = new int[101][101];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			coloring(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		//색종이가 덮어진(값이 1인) 부분을 센다.
		int ans=0;
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(map[i][j]==1) ans++;
			}
		}
		
		System.out.println(ans);
		
		
		
	}
	
	//해당 색종이가 덮어질 위치의 값을 1로 변경한다.
	public static void coloring(int a, int b) {
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				map[a+i][b+j] = 1;
			}
		}
	}
}
// 김형균 : 코드가 정말 깔끔하고 이해하기 쉬워요! 그런데 하나 의문인 점은 배열을 101x101로 만들어야했나라는 생각이 드는데 점을 보는게 아니라
//          넓이를 보는 것이기 때문에 100까지만 하면 된다고 생각하는데 혹시 100x100으로 하신 이유를 조금 더 자세히 알 수 있을까요??
//		ㄴ김소정: 앟.. 아뇨 이유 없습니다 ㅋㅋㅋㅋㅋㅋ 100까지만 해도 됩니다.. 그냥 습관적으로 1 더해서 했네요 ㅎㅎ