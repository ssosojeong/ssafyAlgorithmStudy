package pracitce_1002;

import java.util.Scanner;

public class swea_10월3일_간단한369게임_1926 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int n = 1; n <= N; n++) {
			String str = n + ""; // 숫자를 string으로 바꾸고
			boolean isThree = false;
			int count = 0; // 369 세줄 count 생성
			for (int i = 0; i < str.length(); i++) { // string으로 바꾼 숫자를 앞에서 부터 369의 유무를 확인한다.
				if (str.charAt(i) == '3' || str.charAt(i) == '6' || str.charAt(i) == '9') {
					isThree = true; // 369이면 숫자를 출력안해야함을 표시해야하니 true로 바꿔주고 카운트를 센다.
					count++;
				}
			}
			if (isThree) {// 369일때 카운트센대로 -출력
				for (int i = 0; i < count; i++) {
					System.out.print('-');
				}
				System.out.print(" ");

			} else { // 369가 아닐때 그냥 숫자출력
				System.out.print(str + " ");
			}
		}

	}

}
