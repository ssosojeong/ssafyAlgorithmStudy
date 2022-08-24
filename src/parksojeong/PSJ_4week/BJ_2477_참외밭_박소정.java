import java.util.Arrays;
import java.util.Scanner;

public class BJ_2477_참외밭_박소정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Kmelon = sc.nextInt();
		int[] all = new int[12];// 전체 입력값 받을 배열입니다
		int[] way = new int[5]; // 인덱스로 1부터 4까지 방향이 나오면 1씩 늘릴 배열이에요

		for (int i = 0; i < 12; i++) {// 전체 입력값 받아요
			all[i] = sc.nextInt();
		} // 전체 입력값 받아요 end

		int idx = 0;
		for (int i = 0; i < 6; i++) {// 인덱스로 1부터 4까지 방향이 나오면 1씩 늘릴 배열
			way[all[i * 2]] += 1;
		} // 인덱스로 1부터 4까지 방향이 나오면 1씩 늘릴 배열 end
//		System.out.println(Arrays.toString(way));확인 테스트

		int[] empty = new int[2]; // 빈곳 방향 숫자 저장할 배열
		int Eidx = 0;

		for (int i = 1; i < 5; i++) {// 만약 2로 표기되면 그부분의 방향에 빈부분이 생긴것
			if (way[i] == 2) {
				empty[Eidx++] = i; // 2로 표기된 인덱스가 그 방향이라 배열에 저장한다.
			}
		} // for문 end
		System.out.println(Arrays.toString(empty));
		for (int i = 0; i < 6; i++) {
			if (empty[0] == 1) {

			}
		}
	}

}
