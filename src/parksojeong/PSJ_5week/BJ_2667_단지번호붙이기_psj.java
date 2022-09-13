package BJ_Study_7;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_2667_단지번호붙이기_psj {// class
	static int[][] arr; // 구역표시
	static boolean[][] visited; // 한번왔다갔는지 표기
	static int[] dirX = { 0, 0, -1, 1 };// 사방탐색
	static int[] dirY = { -1, 1, 0, 0 };
	static int count = 0, number = 0;// count는 각 구역마다 집이 몇개인지, number는 구역의 개수
	static int nowX, nowY, N; // 현재 사방탐색을 시작하는 중심이 nowX nowY , N은 전체 땅크기의 변

	public static void main(String[] args) {// main

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		List<Integer> list = new ArrayList<>(); // List ~ ArrayList 하는 이유는 뭘까용 그냥 Arraylist ~ Arraylist 하면되는데..

		arr = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) { // 2차원 배열 arr 채우기
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j)-'0'; //이거 -'0'안했다가 오류 계속 못잡았습니당 ㅠ 
			}
		} // 2차원 배열 arr 채우기 끝


		for (int i = 0; i < N; i++) {// 2차원 배열 arr돌면서 1인거 발견하고 그게만약 visit false이면 DFS돌리기
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false && arr[i][j] == 1) {
					count = 0;// count 다시 0으로 바꿔준 후 dfs 돌려준다.
					number++;
					DFS(i, j);
					list.add(count);// DFS에서 count 나온거 리스트에 저장한다
				}
			}
		} // 2차원 배열 arr 채우기 끝

		Collections.sort(list);
		System.out.println(number);
		for (int num : list) {
			System.out.println(num);
		}

	}// main end

	static void DFS(int x, int y) { // DFS
		visited[x][y] = true; //일단 true로 바꿔주고
//		arr[x][y] = number; // 넘버안찍어도 되지않지않음
		count++;

		for (int i = 0; i < 4; i++) {//사방 탐색
			nowX = x + dirX[i];
			nowY = y + dirY[i];

			if (Range_check() && visited[nowX][nowY] == false && arr[nowX][nowY] == 1) {//재귀
				DFS(nowX, nowY);
			}//재귀 end
			
		}// 사방탐색 end
		
	}// DFS end

	static boolean Range_check() { // Range_check
		return (0 <= nowX && nowX < N && 0 <= nowY && nowY < N);
	}// Range_check end

}// class end
