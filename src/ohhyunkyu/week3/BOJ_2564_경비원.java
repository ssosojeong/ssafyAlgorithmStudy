package week3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2564_경비원 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int c = sc.nextInt(); // 블록 가로 길이
		
		int r = sc.nextInt(); // 블록 세로 길이
		
		int N = sc.nextInt(); // 상점의 개수
		
		// 동근이의 위치와 상점까지의 거리를 비교
		// 경계만을 볼 것이므로 끝이 연결된 하나의 선이라고 봐도 무방
		// 상점이 위치한 면에 따라 위치 지정 후 거리 비교
		// 만약 거리 측정 시 선을 넘어가면 반대 방향끝에서부터 나머지 거리 측정
		// line 배열에서 방향의 순서는 북 동 남 서 로 일직선으로 되어 있다고 생각
		
//		int[] line = new int[c * r]; // 필요가 없네..?
		
		int[] search = new int[N + 1]; // 가게, 동근이 위치 저장
		
		// 북 1 남 2 서 3 동 4
		// 방면별 위치 확인을 위한 dir 배열 작성
		
		int[] dir = {0, 2 * c + r, 2 * (c + r), c};
		
		for(int i = 0; i < N + 1; i++) { // 여기서 search[N]은 동근임
			
			int d = sc.nextInt(); // 상점 방향 + 동근 방향
			int p = sc.nextInt(); // 상점 위치 + 동근 위치
			
			if(d == 1) {
				search[i] = dir[0] + p; 
			} else if(d == 2) {
				search[i] = dir[1] - p; 
			} else if(d == 3) {
				search[i] = dir[2] - p; 
			} else if(d == 4) {
				search[i] = dir[3] + p; 
			}
		}
		System.out.println(Arrays.toString(search));
		// 동근이와 각 상점 사이 최단 거리의 합 구하기
		
		int sum = 0;
		
		// 동근이의 위치와 상점의 위치를 비교
		// 만약 거리가 c*r / 2 보다 크다면 반대방향 탐색
		
		for(int i = 0; i < N; i++) {
			
			int abs = Math.abs(search[N] - search[i]); // 선 내에서 거리 절대값
			
			if(abs <= 2 * (c + r) / 2) {
				sum += abs;
			} else {
				if(search[N] > search[i]) {
					sum += (2 * (c + r) - search[N]) + search[i];
				} else {
					sum += (2 * (c + r) - search[i]) + search[N];
				}
			}
		}
		
		
		System.out.println(sum);
	} // main
} // class
