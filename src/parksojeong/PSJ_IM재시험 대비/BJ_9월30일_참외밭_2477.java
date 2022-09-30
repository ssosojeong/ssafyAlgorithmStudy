package practice0930;

import java.util.ArrayList;
import java.util.Scanner;

public class swea_0930_참외밭_2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] way = new int[6];
		int[] length = new int[6];
		int maxX = 0, maxY = 0; // 최대값구하기
		int Xidx = 0, Yidx = 0; // 인덱스구하기

		for (int i = 0; i < 6; i++) {
			way[i] = sc.nextInt();
			length[i] = sc.nextInt();
			// 입력값의 방향은 방향대로 길이는 길이대로 받았다.
			if (way[i] == 1 || way[i] == 2) { // 최대길이는 곧 전체 변이니 저장한다.
				maxX = Math.max(length[i], maxX);
				if (maxX == length[i]) {
					Xidx = i;
				} // 인덱스 미리 저장
			} else {
				maxY = Math.max(length[i], maxY);
				if (maxY == length[i]) {
					Yidx = i;
				} // 인덱스 미리 저장
			}
		} // 6번동안 입력값 받기
		int size = (maxX * maxY) - length[(Xidx + 3) % 6] * length[(Yidx + 3) % 6];	
		//큰 사각형에서 작은 사각형을 뺀다. 큰 변에서 3칸 이동하면 빼는 변이 나온다.	
		System.out.println(size*num);

	}
}
