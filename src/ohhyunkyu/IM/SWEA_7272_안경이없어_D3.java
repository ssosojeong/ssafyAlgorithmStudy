package IMstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7272_안경이없어_D3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			char[] hole = {'A','D','O','P','Q','R'};
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			boolean chk = false;
			//두 문자열을 검사하는 동시에 비교
			int cnt = 0;
			if(str1.length() == str2.length()) {
				for(int i = 0; i < str1.length(); i++) {
					int a = str1.charAt(i);
					int b = str2.charAt(i);
					if(a == 'B' || b == 'B' ) {
						if(a == 'B' && b == 'B') {
							cnt++;
						}
					}
					else {
						boolean chk1 = false;
						for(int j = 0; j < hole.length; j++) {
							if(a == hole[j]) {
								chk1 = true;
								break;
							}
						}
						boolean chk2 = false;
						for(int j = 0; j < hole.length; j++) {
							if(b == hole[j]) {
								chk2 = true;
								break;
							}
						}
						if(chk1 != chk2) break;
						else cnt++;
					}
				}
				if(cnt == str1.length()) chk = true;
			}
			if(chk) System.out.println("#" + t + " SAME");
			else System.out.println("#" + t + " DIFF");
		}
	}
}
