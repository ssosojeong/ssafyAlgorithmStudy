package sol_220807;

import java.util.Scanner;

public class 스위치켜고끄기_1244 {

	public static Scanner sc = new Scanner(System.in);

	public static int size = sc.nextInt(); // 스위치 개수

	public static int[] status = new int[size]; // 스위치 배열

	public static void main(String[] args) {

		for (int i = 0; i < size; i++) {
			status[i] = sc.nextInt();
		} // 스위치 배열 생성

		int stdSize = sc.nextInt(); // 학생 수

		for (int i = 0; i < stdSize; i++) {

			if (sc.nextInt() == 1) {
				stdM();
			} else {
				stdW();
			}

		} // 메서드를 이용한 스위치 상태 변경

		for (int i = 1; i < size + 1; i++) {
			if (!(i % 20 == 0)) {
				System.out.print(status[i - 1] + " ");
			} else {
				System.out.println(status[i - 1]);
			}
		} // 한줄에 스위치 20개씩 출력
		
		sc.close();
	} // main

	public static void stdM() {
		int t = sc.nextInt();
		for (int i = 1; i < size + 1; i++) {
			if (i % t == 0) {
				if (status[i - 1] == 0) {
					status[i - 1] = 1;
				} else {
					status[i - 1] = 0;
				}
			}
		}  // 나머지를 활용한 배수 스위치 변경
	} // 남학생일 경우

	public static void stdW() {
		int t = sc.nextInt() - 1;
		if (status[t] == 0) {
			status[t] = 1;
		} else {
			status[t] = 0;
		} // 주어진 위치 스위치 상태 변경
		if ((t+1) <= size / 2) {
			for (int i = t - 1, j = t + 1; i >= 0; i--, j++) {
				if (!(status[i] == status[j])) {
					break;
				} else {
					if (status[i] == 0) {
						status[i] = 1;
						status[j] = 1;
					} else {
						status[i] = 0;
						status[j] = 0;
					}
				}
			}
		}else {
			for (int i = t - 1, j = t + 1; j < size; i--, j++) {
				if (!(status[i] == status[j])) {
					break;
				} else {
					if (status[i] == 0) {
						status[i] = 1;
						status[j] = 1;
					} else {
						status[i] = 0;
						status[j] = 0;
					}
				}
			}			
		} // 순차적 좌우 탐색을 통한 스위치 상태 변경
	} // 여학생일 경우
} // class
