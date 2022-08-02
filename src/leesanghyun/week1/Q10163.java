package src.leesanghyun.week1;

import java.util.*;
import java.io.*;

public class Q10163 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); // N개의 색종이
		int[] A = new int[4]; // 좌표값 저장하기 위해서
		int[][] board = new int[1001][1001]; // 0~1000, 0~1000
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				A[j] = Integer.parseInt(st.nextToken()); // 좌표값 너비 높이 저장
			}
			for (int j = A[0]; j < A[0] + A[2]; j++) {
				for (int k = A[1]; k < A[1] + A[3]; k++) {
					board[j][k] = i; // i번째 색종이에 i를 입력 -> 1번째 색종이 배열은 1로, 2번째 색종이 배열은 2로. 나중에 넣은 색종이의 값으로 재정의하여 덮어씌움.
				}
			}
		}
		int[] ans = new int[N + 1]; // 색종이가 N개이므로 ans[N]까지 구현
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				ans[board[i][j]]++; // ans[1]은 첫번째 색종이가 겉으로 보여지는 값
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			sb.append(ans[i] + "\n");
		}
		System.out.println(sb);
	}
}

/* 김형균
피드백할께 없나 오랫동안 봤는데 할게 없습니다.
굳이 한다면 변수명에 의미 담기, 주석의 섬세함, 그리고 31~34줄은 for(int i=1; i<N+1;i++) { System.out.println(ans[i]); } 만해도 같은 결과가 나와요.
*/
