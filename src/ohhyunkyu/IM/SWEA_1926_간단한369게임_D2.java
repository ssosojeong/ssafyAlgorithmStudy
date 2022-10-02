package IMstudy;

import java.util.Scanner;

public class SWEA_1926_간단한369게임_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 1; i <= N; i++) {
			//문자열로 변환해서 확인
			String str = Integer.toString(i);
			char[] num = str.toCharArray();
			boolean chk = false;
			for(int j = 0; j < str.length(); j++) {
				if(num[j] != '3' && num[j] != '6' && num[j] != '9')
					continue;
				else {
					chk = true;
					System.out.print("-");
				}
			}
			if(!chk) System.out.print(i + " ");
			else System.out.print(" ");
		}
	}
}
