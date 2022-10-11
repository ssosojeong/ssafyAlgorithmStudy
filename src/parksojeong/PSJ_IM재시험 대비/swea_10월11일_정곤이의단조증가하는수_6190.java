package practice_1011;

import java.util.Scanner;

public class swea_10월11일_정곤이의단조증가하는수_6190 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			int max = -1;//값이 안나오면 -1이기때문에 기본값으로 해준다.
			for (int i = 0; i < N; i++) {//전체 곱을 탐색한다.
				for (int j = i + 1; j < N; j++) {
					boolean lager = true; //boolean을 true로 설정한 다음 만약 전숫자를 뒷숫자가 넘으면 false로 바꾼다.
					String num = Integer.toString(arr[i] * arr[j]);//한숫자씩 비교를 위해 Integer.toString으로 string으로 형변환
					for (int k = 1; k < num.length(); k++) {
						if (num.charAt(k - 1) - '0' > num.charAt(k) - '0' ) {//한숫자씩 비교하기때문에 charAt에서 '0'를뺀다.
							lager = false;
							break;//false가 되면 break를 해준다. 안하면 틀리더라...
						}
					}
					if (lager) {//만약 boolean이 true이면 맥스값을 비교해서 구해준다.
						max = Math.max(max, arr[i] * arr[j]);
					}

				}
			} ////전체 곱을 탐색한다.
			
				System.out.println("#" + tc + " " + max);


		} // tc

	}
}