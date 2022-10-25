package week11;

import java.util.Scanner;

public class BOJ_9011_순서_골드5 {
	static int n;
	static int[] arr;
	static boolean[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		outer: for (int t = 1; t <= T; t++) {
			n = sc.nextInt();// 정수의 개수
			arr = new int[n + 1];// R배열
			for (int i = 1; i <= n; i++)
				arr[i] = sc.nextInt();
			sel = new boolean[n + 1];// 1부터 n까지를 받기 위해 n+1
			// 입력 끝
			for (int i = n; i > 0; i--) {
				int cnt = 0;
				boolean sign = false;// S 찾기 불가능 여부 체크
				for (int j = 1; j <= n; j++) {
					if (!sel[j])
						cnt++;
					if (cnt == arr[i] + 1) {
						arr[i] = j;
						sel[j] = true;
						sign = true;
						break;
					}
				}
				if(!sign) {
					//오타에 주의
					System.out.println("IMPOSSIBLE");
					continue outer;
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 1; i <= n; i++) sb.append(arr[i]).append(" ");
			System.out.println(sb);
		}//T
	}//main
}
// si != sj 이고 1<=si<=n 이므로 1부터 n까지의 수가 들어가는 것.
// ri > i-1 이면 불가
// ri > n-1 이면 불가
// 뒤에서부터 확인하면 편할 것 같다
// 방문처리한 친구들을 제외하고 ri+1번째의 수를 픽한다. 만약 남은 선택지가 부족하다면 impossible