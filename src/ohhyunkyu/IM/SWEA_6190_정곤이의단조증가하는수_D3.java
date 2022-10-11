package IMstudy;

import java.util.Scanner;

public class SWEA_6190_정곤이의단조증가하는수_D3 {
	static int N, ans, tmp;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N];
			for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
			ans =0;
			boolean sign = false;
			//곱이 단조 증가하는 수인지를 확인하고 지금까지 구한 결과와 비교
			for(int i = 0; i < N-1; i++) {
				for(int j = i+1; j < N; j++) {
					tmp = arr[i] * arr[j];
					if(chk()) {
						sign = true;
						ans = Math.max(ans, tmp);
					}
				}
			}
			if(!sign) ans = -1; //출력조건 잘 확인하자
			System.out.println("#" + t + " " + ans);
		}//T
	}//main
	
	static boolean chk() {
		String str = String.valueOf(tmp);
		for(int i = 0; i < str.length()-1; i++) {
			if(str.charAt(i) > str.charAt(i+1)) return false;
		}
		return true;
	}
}
