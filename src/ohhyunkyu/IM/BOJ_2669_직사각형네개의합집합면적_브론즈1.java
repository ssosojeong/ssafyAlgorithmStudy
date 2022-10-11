package IMstudy;

import java.util.Scanner;

public class BOJ_2669_직사각형네개의합집합면적_브론즈1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[101][101];
		int ans = 0;
		for(int i = 0; i < 4; i++) {
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			int ex = sc.nextInt();
			int ey = sc.nextInt();
			
			for(int j = sx; j < ex; j++) {
				for(int k = sy; k < ey; k++) {
					if(map[j][k] != 1) ans++;
					map[j][k] = 1;
				}
			}
		}
		System.out.println(ans);
	}
}
