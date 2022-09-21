import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2630 {
	static int blue, white; // 파란색종이면 blue++, 흰종이면 white++ 해주기 위한 변수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		check(arr, 0, 0, N);// arr행렬을 0,0을 시작점으로 NXN만큼의 범위를 검사
		System.out.println(white);
		System.out.println(blue);
	}

	static void check(int[][] arr, int r, int c, int size) {
		int ans = sum(arr, r, c, size); // 시작점 (r,c)에서 size x size만큼의 범위를 더해준다.
		if (ans == size * size) { // 더해준 값이 size^2이면 1로 가득찬 것이므로
			blue++;// 파란종이를 하나 더해준다.
		} else if (ans == 0) { // 더해준 값이 0이면 0으로 가득찬 것이므로
			white++; // 흰종이를 하나 더해준다.
		} else {// 그게 아니라면 다 나눠서 재귀를 돌린다.
			check(arr, r, c, size / 2);
			check(arr, r + size / 2, c, size / 2);
			check(arr, r, c + size / 2, size / 2);
			check(arr, r + size / 2, c + size / 2, size / 2);
		}
	}

	static int sum(int[][] arr, int r, int c, int size) {
		int tmp = 0;
		for (int i = r; i < r + size; i++)
			for (int j = c; j < c + size; j++)
				tmp += arr[i][j];
		return tmp;
	}
}
//김형균 : arr가 처음 입력받은 arr로 계속 사용이 되는거 같은데 static을 하지 않고 들고 다니게한 이유가 있으신지 궁금합니다.
//         그리고 지금 넓이를 기준으로 계산하기 때문에 중간에 값이 다른게 나와도 break하고 나오지 못해 이미 틀린 부분에 있어서도 더 계산을 하여 시간이 더 오래 걸릴것 같습니다.
//         if 조건문 안에 들어갈 조건을 boolean값을 반환하는 함수로 해서 중간에 다른 숫자가 나오면 break를 하고 false를 반환하는 함수를 하나 만들어주면 좋을것 같습니다.
//오현규 : 기준점을 설정해 검사하는 방식을 사용해봐도 좋을 것 같습니다!
