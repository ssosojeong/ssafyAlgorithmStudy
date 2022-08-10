package sj;

import java.util.Arrays;
import java.util.Scanner;

public class switch1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 스위치의 현 상황 배열에 담기
		int N = sc.nextInt();
		int[] switchs = new int[N];
		for (int i = 0; i < N; i++) {
			switchs[i] = sc.nextInt();
		}

		// 학생수와 여학생 남학생 수,그리고 성별과 스위치번호의 수들을 저장할 변수 선언
		int students = sc.nextInt();
		int GCount = 0;
		int BCount = 0;
		int[] studentsNum = new int[students * 2];

		// 여학생과 남학생을 구분하면서 수를 저장하고 전체 수를 배열에 저장한다.
		for (int i = 0; i < studentsNum.length; i += 2) {
			studentsNum[i] = sc.nextInt();
			if (studentsNum[i] == 1) {
				BCount++;
				studentsNum[i + 1] = sc.nextInt();
			} else if (studentsNum[i] == 2) {
				GCount++;
				studentsNum[i + 1] = sc.nextInt();
			}
		}

		// 여학생 수만큼 배열 만들고 남학생 수만큼 배열 만든다.
		int[] girls = new int[GCount];
		int[] boys = new int[BCount];
		// 남학생 배열과 여학생 배열에 각각 스위치를 저장한다
		for (int i = 0; i < studentsNum.length; i += 2) {
			if (studentsNum[i] == 1) {
				for (int j = 0; j < BCount; j++) {
					boys[j] = studentsNum[i + 1];
				}
			}
			if (studentsNum[i] == 2) {
				for (int j = 0; j < GCount; j++) {
					girls[j] = studentsNum[i + 1];
				}
			}
		}
		// 남학생의 스위치 조절
		for (int i = 0; i < BCount; i++) {
			int SB = switchs[boys[i] - 1];
			if (SB == 0) {
				SB = 1;
			} else if (SB == 1) {
				SB = 0;
			}

		}
		// 여학생의 스위치 조절
		for (int i = 0; i < GCount; i++) {
			int SG = switchs[girls[i] - 1];
			if (SG == 0) {
				SG = 1;
			} else if (SG == 1) {
				SG = 0;
			}
			for (int j = 1; j <= switchs.length / 2; j++) {
				if ((girls[i] - 1 - j) >= 0 && (girls[i] - 1 + j) < switchs.length) {
					if (switchs[girls[i] - 1 - j] == 0 && switchs[girls[i] - 1 + j] == 0) {
						switchs[girls[i] - 1 - j] = 1;
						switchs[girls[i] - 1 + j] = 1;
					} else if (switchs[girls[i] - 1 - j] == 1 && switchs[girls[i] - 1 + j] == 1) {
						switchs[girls[i] - 1 - j] = 0;
						switchs[girls[i] - 1 + j] = 0;
					} else {
						break;
					}
				}

			}
		}
		System.out.println(Arrays.toString(switchs));
	}
}
//틀렸다고하는데 컴텨 정답보다 제것이 정답이라 생각하는데 질문을 잘못읽은건가 싶습니다
