import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수_실버2 {
	static int N;
	static int[][] arr;
	// -1, 0, 1로만 채워진 종이의 개수를 구하기 위한 배열
	static int[] res = new int[3];
	
	// 분할된 종이가 모두 같은 수로 되어 있는지 확인하기 위한 함수
	public static boolean check(int row, int col, int num) {
		// 확인을 위한 기준점
		int chk = arr[row][col];
		// 반복문으로 체크
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < num; j++) {
				if(chk != arr[row+i][col+j]) return false;
			}
		}
		return true;
	}
	
	// 체크를 통해 종이를 분할하고, 각 수로 채워진 종이의 개수를 구하는 함수
	public static void split(int row, int col, int num) {
		// 체크가 참이면 종이의 개수++
		if(check(row, col, num)) {
			// -1, 0, 1 을 res의 인덱스 0, 1, 2에 저장하기 위해 +1
			res[arr[row][col]+1]++;
		} else {
			// 이차원 배열 9분할을 위해 한 변의 길이를 3으로 나눈다
			int size = num / 3;
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					split(row + size * i, col + size * j, size);
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		split(0, 0, N);
		
		for(int i = 0; i < 3; i++) System.out.println(res[i]);
	}
}
