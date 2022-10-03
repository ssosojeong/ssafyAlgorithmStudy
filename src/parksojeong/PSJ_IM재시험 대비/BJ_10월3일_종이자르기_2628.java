package pracitce_1002;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_10월3일_종이자르기_2628 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		ArrayList<Integer> listR = new ArrayList<>();
		ArrayList<Integer> listC = new ArrayList<>();
		// listR과 listC에는 각각 잘리는 꼭지점을 저장하기 때문에 처음과 끝인 0과 변의 길이도 넣어준다.
		listR.add(0);
		listR.add(R);
		listC.add(0);
		listC.add(C);

		int T = sc.nextInt();
		// 잘리는 수만큼 반복문을 돌려서 꼭지점을 저장해준다.
		for (int t = 1; t <= T; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (x == 0) {
				listC.add(y);
			} else {
				listR.add(y);
			}
		}
		// 순서대로 길이의 최대값을 확인해야하니 나열을 해준다.
		Collections.sort(listR);
		Collections.sort(listC);

		// 가로세로의 최대값을 구하기 위해 지금 꼭지점에서 앞의 꼭지점값을 빼준것의 max를 구한다.
		int maxR = 0, maxC = 0;
		for (int i = 1; i < listR.size(); i++) {
			int tmp = listR.get(i) - listR.get(i - 1);
			maxR = Math.max(maxR, tmp);
		}
		for (int i = 1; i < listC.size(); i++) {
			int tmp = listC.get(i) - listC.get(i - 1);
			maxC = Math.max(maxC, tmp);
		}
		System.out.println(maxR * maxC);

	}
}
