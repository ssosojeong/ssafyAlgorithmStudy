package IMstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_7087_문제제목붙이기_D3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			boolean[] arr = new boolean[26]; //알파벳
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				arr[str.charAt(0)-'A'] = true; //첫 문자 확인
			}
			int ans = 0;
			for(int i = 0; i < 26; i++) {
				if(!arr[i]) break;
				ans++;
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
