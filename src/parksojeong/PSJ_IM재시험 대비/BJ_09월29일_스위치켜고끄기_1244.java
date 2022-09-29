package practice0929;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_스위치켜고끄기_1244 {
	static int count;
	static int[] switchs;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		count = sc.nextInt();
		switchs = new int[count + 1];
		for (int i = 1; i <= count; i++) { // 스위치 입력받기
			switchs[i] = sc.nextInt();
		} // 스위치 입력받기

		int students = sc.nextInt();

		// 학생별로 수를 입력받고 각 함수로 연결해준다.
		for (int tc = 1; tc <= students; tc++) {// 테케
			int sex = sc.nextInt();
			int num = sc.nextInt();
			if (sex == 1) {
				boy(num);
			} else {
				girl(num);
			}
		} // 테케
		for (int i = 1; i < switchs.length; i++) {
			System.out.print(switchs[i]+" ");
			if(i%20 == 0) {
			System.out.println();
			}
		}

	}

	private static void girl(int num) { // girl 함수
		switchs[num] = 1 - switchs[num]; //스위치 바꿔주기
		int range = 0;
		if (num <= count / 2) { // 좌우대칭을 확인하는 범위를 알아내기 위해서 1과 뒷숫자중에 어디에 제일 가깝나 확인
			range = num - 1;
		} else {
			range = count - num;
		}
		for (int i = 0; i <= range; i++) {//좌우대칭 확인
			if (switchs[num - i] == switchs[num + i]) {
				switchs[num - i] = 1 - switchs[num - i];
				switchs[num + i] = 1 - switchs[num + i];
			} else {//좌우대칭 아니면 빠져나온다.
				break;
			}
		}

	}

	private static void boy(int num) { // boy
		for (int i = 1; i <= count / num; i++) { // 배수가 될때 스위치를 바꿔준다.
			switchs[i * num] = 1 - switchs[i * num];
		}

	}
}
