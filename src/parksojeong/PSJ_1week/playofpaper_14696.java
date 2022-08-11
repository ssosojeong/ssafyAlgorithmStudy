import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class playofpaper_14696 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 몇라운드 할 지 받습니다.
		for (int i = 0; i < N; i++) { // 라운드 횟수대로 반복

			String A = br.readLine(); // A카드 한줄읽기
			String B = br.readLine(); // B카드 한줄읽기

			int A_count = (A.length()) / 2 + 1; // A 카드 숫자개수
			int B_count = (B.length()) / 2 + 1; // B 카드 숫자개수

			int[] A_arr = new int[A_count]; // A 카드 숫자 담을 배열
			int[] B_arr = new int[B_count]; // B 카드 숫자 담을 배열

			StringTokenizer st_A = new StringTokenizer(A);
			StringTokenizer st_B = new StringTokenizer(B);
			for (int j = 0; j < A_count; j++) { // A카드 숫자를 배열에 담았다.
				A_arr[j] = Integer.parseInt(st_A.nextToken());

			}
			for (int j = 0; j < B_count; j++) { // B카드 숫자를 배열에 담았다.
				B_arr[j] = Integer.parseInt(st_B.nextToken());

			}
			Arrays.sort(A_arr);
			Arrays.sort(B_arr); // A와 B의 카드 숫자를 오름차순으로 정렬

			if (A_count > B_count) { // B 숫자개수가 적을때의 경우의 수 , index를 줄여나가면서 더 작은 수가 먼저나오는 쪽이 진다.
				for (int j = B_count - 1; j >= 0; j--) {
					if (A_arr[j] > B_arr[j]) {
						System.out.println("A");
						break;
					} else if (A_arr[j] < B_arr[j]) {
						System.out.println("B");
						break;
					} else if (A_arr[j] == B_arr[j] && j == 0) {
						System.out.println("A"); // 만약 마지막까지 같다면 요소가 더 많은 A 승리
					}

				}
			} else if (B_count > A_count) {// A 숫자개수가 적을때의 경우의 수 , index를 줄여나가면서 더 작은 수가 먼저나오는 쪽이 진다.
				for (int j = A_count - 1; j >= 0; j--) {
					if (A_arr[j] > B_arr[j]) {
						System.out.println("A");
						break;
					} else if (A_arr[j] < B_arr[j]) {
						System.out.println("B");
						break;
					} else if (A_arr[j] == B_arr[j] && j == 0) {
						System.out.println("B");// 만약 마지막까지 같다면 요소가 더 많은 B승리
					}

				}
			} else {// 둘다 숫자개수가 같을때의 경우의 수 , index를 줄여나가면서 더 작은 수가 먼저나오는 쪽이 진다.
				for (int j = A_count - 1; j >= 0; j--) {
					if (A_arr[j] > B_arr[j]) {
						System.out.println("A");
						break;
					} else if (A_arr[j] < B_arr[j]) {
						System.out.println("B");
						break;
					} else if (A_arr[j] == B_arr[j] && j == 0) {
						System.out.println("D");
					}// 만약 마지막까지 같다면 동점처리

				}

			}
		}

	}

}
//이상현 : 만약 마지막까지 같다면 요소가 더 많은 A,B 승리 이부분을 else if를 쓰지 않고 포문 밖으로 빼면 좀더 간결해질것같아요.
