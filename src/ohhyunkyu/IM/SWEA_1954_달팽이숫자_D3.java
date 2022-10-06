package IMstudy;

import java.util.Scanner;

public class SWEA_1954_달팽이숫자_D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
 
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
 
            // 델타 우하좌상
            int[] dr = { 0, -1, 0, 1 }; // 행
            int[] dc = { 1, 0, -1, 0 }; // 열
 
            // 1부터 시작
            int n = 1;
            // 델타 적용을 위한 카운트
            int cnt = 0;
            // 시작 좌표 // 행렬의 인덱스에 주의
            int x = 0;
            int y = 0;
            arr[x][y] = n++;
            // 숫자를 넣기 위한 반복문
            while (n <= N * N) {
                int dx = x + dr[cnt % 4];
                int dy = y + dc[cnt % 4];
                // 조건 설정에 유의, 범위, 그리고 이미 값이 주어진 영역 고려
                if (dx < 0 || dx >= N || dy < 0 || dy >= N || arr[dx][dy] != 0) {
                    cnt += 1;
                    continue;
                }
                x = dx;
                y = dy;
                arr[x][y] = n++;
            }
 
            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }// T
    }
}