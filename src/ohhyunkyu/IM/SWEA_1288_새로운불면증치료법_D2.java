package IMstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1288_새로운불면증치료법_D2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			boolean[] num = new boolean[10];
			int cnt = 0;
			outer: while(true) {
				cnt++;
				String str = String.valueOf(N*cnt);
				for(int i = 0; i < str.length(); i++) {
					num[str.charAt(i)-'0'] = true;
				}
				int chk = 0;
				for(int i = 0; i < 10; i++) {
					if(num[i]) chk++;
					if(chk == 10) break outer;
				}
			}
			System.out.println("#" + t + " " + N*cnt);
		}
	}
}
