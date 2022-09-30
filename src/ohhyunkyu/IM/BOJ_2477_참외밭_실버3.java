package IMstudy;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2477_참외밭_실버3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> h = new ArrayList<>();
		ArrayList<Integer> v = new ArrayList<>();
		int[][] map = new int[6][2];
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 2; j++) {
				map[i][j] = sc.nextInt();
				if(j == 0) {
					if(map[i][j] == 1 || map[i][j] == 2) {
						h.add(i);
					}else {
						v.add(i);
					}
				}
					
			}
		}
		//초기화에 유의토록 하자. 0으로 무지성 초기화는 안 됨.
		int maxidx1 = h.get(0);
		int maxidx2 = v.get(0);
		for(int i = 1; i < 3; i++) {
			int a = h.get(i);
			int b = v.get(i);
			if(map[maxidx1][1] < map[a][1]) maxidx1 = a;
			if(map[maxidx2][1] < map[b][1]) maxidx2 = b;
		}
		int smallidx1;
		int smallidx2;
		if(maxidx1 + 3 < 6) smallidx1 = maxidx1 + 3; 
		else smallidx1 = maxidx1 + 3 - 6;
		if(maxidx2 + 3 < 6) smallidx2 = maxidx2 + 3; 
		else smallidx2 = maxidx2 + 3 - 6;
		
		int ans = N * (map[maxidx1][1]*map[maxidx2][1] - map[smallidx1][1]*map[smallidx2][1]);
		
		System.out.println(ans);
	}
}