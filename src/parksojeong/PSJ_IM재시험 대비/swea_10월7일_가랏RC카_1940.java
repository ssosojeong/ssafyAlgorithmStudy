package october_Practice;

import java.util.Scanner;

public class swea_10월7일_가랏RC카_1940 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // command의 개수 N
			int count = 0;
			int speed = 0;
			for (int n = 0; n < N; n++) {
				int gear = sc.nextInt(); // 1이면 가속 2이면 감속 0이면 유지
				if (gear == 1 || gear == 2) { // 1,2이면 다음 입력값을 받는다.
					int plus = sc.nextInt(); // 이번 기어의 속도 plus

					if (gear == 1) { // 이번 기어가 1이면
						speed += plus; // 전체 속도에 더해준다.
					} else if (gear == 2) {// 이번기어가 2이면
						speed -= plus;// 전체 속도에서 빼준다.
					}
				}
				if (speed < 0) {
					speed = 0;
				}
				count += speed;// 전체 얼마갔는지에 이번 스피드를 더해준다.
			}
			System.out.println("#" + tc + " " + count);
		}
	}
}
