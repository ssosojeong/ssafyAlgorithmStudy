package IMstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이렇게 푸니까 런타임 에러 //메모리 에러 발생
public class SWEA_1860_진기의최고급붕어빵_D3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		outer: for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //인원
			int M = Integer.parseInt(st.nextToken()); //제작시간
			int K = Integer.parseInt(st.nextToken()); //회당 붕어빵
			int[] arr = new int[11112]; //각 시간별 도착 인원
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int a = Integer.parseInt(st2.nextToken());
				if(a == 0) { //0초에 손님이 오면 실패
					System.out.println("#" + t + " Impossible");
					continue outer;
				}
				arr[a]++;
			}
			boolean chk = true;
			
			int bread = 0;
			
			for(int i = 1; i < 11112; i++) {
				if(i % M == 0) bread += K;
				bread -= arr[i];
				if(bread < 0) {
					chk = false;
					break;
				}
			}
			
			if(chk) System.out.println("#" + t + " Possible");
			else System.out.println("#" + t + " Impossible");
		}
	}
}
