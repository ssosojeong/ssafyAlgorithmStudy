package IMstudy;

import java.util.Scanner;

public class BOJ_2578_빙고_실버4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[5][5];
		int[][] call = new int[5][5];
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				map[i][j] = sc.nextInt();
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				call[i][j] = sc.nextInt();
		int bcnt = 0; //빙고까지 콜 수
		//빙고까지 반복
		//행, 열 , 그리고 대각선에 속해 있다면 대각선까지 검사
		int cnt = 0; //완성된 줄 수
		outer: for(int d = 0; d < 5; d++) {
			for(int z = 0; z < 5; z++) {
				bcnt++;
				int c = call[d][z]; //사회자 콜
				for(int i = 0; i < 5; i++) {
					for(int j = 0; j < 5; j++) {
						if(map[i][j] == c) {
							//행, 열, 대각선
							map[i][j] = 0;
							int cnt1 = 0;
							int cnt2 = 0;
							int cnt3 = 0;
							int cnt4 = 0;
							for(int k = 0; k < 5; k++) {
								//행, 열
								if(map[k][j] == 0) cnt1++;
								if(map[i][k] == 0) cnt2++;
								if(cnt1 == 5) cnt++;
								if(cnt2 == 5) cnt++;
								//대각선
								if(i == j) {
									if(map[k][k] == 0) cnt3++;
								}
								if(j == 4-i) {
									if(map[k][4-k] == 0) cnt4++;
								}
								if(cnt3 == 5) cnt++;
								if(cnt4 == 5) cnt++;
							}
							if(cnt >= 3) break outer;
						}
					}
				}
			}
		}
		System.out.println(bcnt);
	}
}
