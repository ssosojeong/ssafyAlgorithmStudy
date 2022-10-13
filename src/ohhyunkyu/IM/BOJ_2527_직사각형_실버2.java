package IMstudy;

import java.util.Scanner;

public class BOJ_2527_직사각형_실버2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 0; t < 4; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int p = sc.nextInt();
			int q = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();
			
			//무접점
			if(x > p2 || p < x2 || y > q2 || q < y2)
				System.out.println("d");
			//점
			else if(p==x2 && q==y2 || p==x2 && y==q2 || x==p2 && y==q2 || x==p2 && q==y2)
				System.out.println("c");
			//선분(무접점도 아니고 점도 아니면)
			else if(p==x2 || y==q2 || x==p2 || q==y2)
				System.out.println("b");
			//직사각형(나머지)
			else System.out.println("a");
		}
	}
}
