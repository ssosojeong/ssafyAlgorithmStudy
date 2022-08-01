package src.leesanghyun.week1;

import java.util.*;
import java.io.*;

public class Q2578 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] A = new int[26]; // A[25]까지 구현하기 위해서.
		int[] ver = new int[5]; // 수직 빙고 검사용
		int[] ho = new int[5]; // 수평 빙고 검사용
		int[] di = new int[2]; // 대각선 빙고 검사용
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				A[tmp] = 5 * i + j; // A[1]A[2]A[3]순이 아닌, A[값]=주소 를 대입한다. ->빙고를 하려면 값을 토대로 위치를 찾아야하는데, 배열에서 위치를 찾으려면 최대 25번의 검사를 거치기 때문에 처리시간을 줄이기 위함.
			}
		}
		int cnt = 0;
		int bingo = 0;
		end: for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				cnt++;
				if (++ver[A[tmp] % 5] == 5) // 해당 값의 세로위치의 값을 +1해줌.
					bingo++;
				if (++ho[A[tmp] / 5] == 5) // 해당 값의 가로위치의 값을 +1해줌.
					bingo++;
				if (A[tmp] % 6 == 0)
					if (++di[0] == 5) // 왼쪽 위에서 오른쪽 아래로 내려오는 대각선의 위치에 존재할경우 그곳에 +1
						bingo++;
				if (A[tmp] % 4 == 0 && A[tmp] != 0 && A[tmp] != 24)
					if (++di[1] == 5) // 오른쪽 위에서 왼쪽 아래로 내려오는 대각선의 위치에 존재할경우 그곳에 +1
						bingo++;
				if (bingo >= 3)
					break end; // 빙고가 3이되면 종료.
			}
		}
		System.out.println(cnt);
	}
}

/* 김소정
	처음부터 주소값을 저장하는게 확실히 메모리 면에서 더 효율적이니 좋은 것 같습니다!

 */