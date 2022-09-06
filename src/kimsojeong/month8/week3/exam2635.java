package src.kimsojeong.month8.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam2635 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		//가장 긴 수열은 무조건 두번째 숫자가 N/2 이상일 때 존재함
		//N뒤에 N/2 미만의 값이 올 경우 무조건 수열은 3개에서 끝남
		//ex) 100 49 51 / 360 179 181 ...
		
		int max=3; //수열엔 무조건 3개 이상의 수가 존재하므로
		int ans=0;
		
		//n<N일경우 입력이 1일 때 오답..ㅎ
		for(int n=N/2; n<=N; n++) {
			int cnt = 2;
			int p1 = N;
			int p2 = n;
			
			//p1에 p2를, p2엔 p1-p2를 저장해준다.
			while(p1 >= p2) {
				int tmp = p1-p2;
				p1 = p2;
				p2 = tmp;
				cnt++;
			}
			
			//만들어진 수열의 크기가 max보다 크면 갱신해준다.
			if(cnt > max) {
				max = cnt;
				ans = n;
			}
		}
		
		
		
		//출력을 위해 다시 선언해준다.
		int p1 = N;
		int p2 = ans;
		
		sb.append(max + "\n" + p1 + " " + p2+" ");
		while(p1>=p2) {
			int tmp = p1-p2;
			p1 = p2;
			p2 = tmp;
			sb.append(tmp+" ");
		}
		
		System.out.println(sb);
		
	}
}
// 이상현 : N/2라니..!!
