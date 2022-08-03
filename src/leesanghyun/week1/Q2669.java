package src.leesanghyun.week1;

import java.util.Scanner;

public class Q2669 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] A = new int[4]; // 좌표값 2개 저장용.
		int[][] ans = new int[101][101]; // 좌표의 최대치 0~100, 0~100
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				A[j] = sc.nextInt(); // 좌표값 저장
			}
			for (int j = A[0]; j < A[2]; j++) {
				for (int k = A[1]; k < A[3]; k++) {
					ans[j][k] = 1; // 해당 배열에 1을 저장. 
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				sum += ans[i][j]; // 다 더해줌.
			}
		}
		System.out.println(sum);
	}
}
// 박또덩 : 아니...!! 해당 배열에 1 저장하면서 동시에 sum에 더해주면 코드가 더 간결해집니당 이거슨 나밖에 모르는건가! 역시 나인건가!! 음하하하 ..왜 같이 웃나요?
