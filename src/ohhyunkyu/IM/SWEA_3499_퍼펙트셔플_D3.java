package IMstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_3499_퍼펙트셔플_D3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			Queue<String> q = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			//큐를 활용해 입력
			for(int i = 0; i < N; i++) {
				if(N%2 == 1 && i <= N/2) {
					q.add(st.nextToken()); 
				} else if(N%2 == 0 && i < N/2){
					q.add(st.nextToken());
				} else {
					q2.add(st.nextToken());
				}
			}
			//인덱스에 유의 //홀수일 때를 대비해 N/2까지 반복문 돌리기로 설정하고 조건을 통해 통제
			System.out.print("#" + t + " ");
			for(int i = 0; i <= N/2; i++) {
				if(i == N/2 && N%2 == 0) break;
				System.out.print(q.poll() + " ");
				if(N % 2 == 1 && q.isEmpty()) break;
				System.out.print(q2.poll() + " ");
			}
			System.out.println();
		}
	}
}
