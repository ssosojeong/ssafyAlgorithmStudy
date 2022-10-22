package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15710_시간초과 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		if(n==1) {//두 수를 곱해나가면서 나머지를 구해야 하기 때문에 1일 때는 그냥 값 반환
			System.out.println(1);
			return;
		}
		long mod = 1;//처음 나머지가 (2^31)^0으로 1이라서
		long r = (long)Math.pow(2, 31) % ((long)Math.pow(10, 9)+7);// 많이 사용할 숫자이니까 그냥 미리 한번 구해놓기
		for(int i=2;i<=n;i++) {
			mod = (mod * r)%((long)Math.pow(10, 9)+7);
		}//for
		
		System.out.println(mod);
		
		
		br.close();
	}//main
}//class
