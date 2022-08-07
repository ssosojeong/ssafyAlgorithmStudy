package week2;

import java.util.*;

public class Q10158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int p = sc.nextInt();
		int q = sc.nextInt();
		int t = sc.nextInt();
		//개미가 2*w 혹은 2*h 만큼 가면 0으로 온것과 같다는 점을 이용.
		int x = (p + t) % (2 * w);
		int y = (q + t) % (2 * h);
		System.out.println(Math.min(x, 2 * w - x) + " " + Math.min(y, 2 * h - y)); 
		// x는 2w보다 작은수이므로(나머지이기때문) w보다 클 수 있음. 그렇기때문에 거울에 반전을 시키듯 둘 중 최솟값을 선택하여 출력
	}
}