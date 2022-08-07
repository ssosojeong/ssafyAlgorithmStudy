package sj;

import java.util.Arrays;
import java.util.Scanner;

public class sevens2309 {
	public static void main(String[] args) {
		// 9명중에 2명씩 빼는 반복문을 돌린다.
		// 나머지 합이 100이되면 반복문을 멈추고 배열에 저장하여 오름차순으로 나열출력
		Scanner sc = new Scanner(System.in);
		int[] heights = new int[9];
		// 9명의 난장이들의 키를 배열에 나열한다.
		for (int i = 0; i < 9; i++) {
			heights[i] = sc.nextInt();
		}
		// 9명의 난장이들의 키의 합을 구한다.
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			sum += heights[i];
		}
		// 9명의 난장이들의 키의 합에서 100을 뺀다.
		int last = sum - 100;
		// 2명의 난장이들의 키의 합이 last가 나오는지 확인한다.
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				if (i != j) {
					if (heights[i] + heights[j] == last) {
						heights[i] = 0;
						heights[j] = 0;
						break;
					}
				}
			}
		}
		//오름차순으로 나열하고 앞에 두개는 0이기때문에 2 인덱스부터 차례대로 출력한다.
		Arrays.sort(heights);
		for(int i = 2 ; i <9;++i) {
		System.out.println(heights[i]);
		}
	}
}
//이게 틀렸다고 나오는데 왜 틀렸는지 모르겠으요.
//이상현 : for문에 break가 두번째 for문만 빠져나오기 때문입니다. 만약 last의 값이 23이고 7명의 난쟁이 중, 23인 난쟁이가 있으면, 이미0이 되어버린 height[j]+23 ==23 이 되기때문에
//        그 난쟁이도 0이 되어버려서 틀린 답이 됩니다.
