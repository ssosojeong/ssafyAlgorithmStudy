package week2;

import java.util.*;
import java.io.*;

public class Q1244 {
	static int[] sw;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		sw = new int[N];
		int cnt = 0;
		for (int i = 0; i < (N % 20 == 0 ? N / 20 : N / 20 + 1) && cnt < N; i++) { 
			//20개씩 나누어서 입력받기. -->여기서 cnt < N를 빼면 Arrayoutofbound 에러가 남 왜지..?
			st = new StringTokenizer(br.readLine());//한 줄 읽기
			while (st.hasMoreTokens()) { // StringTokenizer에 남은 토큰이 있으면 받고, 없으면 while문 종료.
				sw[cnt++] = Integer.parseInt(st.nextToken());
			}
		}
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) { // 성별, 숫자를 입력받음
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			change(n, m - 1);
		}
		for (int i = 0; i < (N % 20 == 0 ? N / 20 : N / 20 + 1); i++) { // 20개 단위로 출력하기 위해서.
			for (int j = 0; j < 20; j++) {
				if (20 * i + j < N) {
					sb.append(sw[20 * i + j] + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void change(int n, int m) {
		if (n == 1) { // 남자가 킬경우 해당 스위치와 그 배수의 스위치 반전
			for (int i = m; i < N ; i += (m + 1)) {
				sw[i] = 1 - sw[i];
			}
		} else { // 여자가 킬경우
			int cnt = 0;
			for (int i = 1; (m - i) >= 0 && (m + i) < N; i++) { // Arrayoutofbound 에러가 안나도록 범위 설정
				if (sw[m - i] != sw[m + i]) { // 대칭되는 곳의 스위치가 같은 상태면 for문 종료.
					break;
				}
				cnt = i; // 몇번이나 대칭되는 곳의 스위치가 같았는지 카운트
			}
			sw[m] = 1 - sw[m]; // 고른 번호도 바꾸므로 바꿔줌.
			for (int i = 1; i <= cnt ; i++) { // 카운트 된 만큼 스위치 바꿔주기
				sw[m - i] = 1 - sw[m - i];
				sw[m + i] = 1 - sw[m + i];
			}
		}
	}
}