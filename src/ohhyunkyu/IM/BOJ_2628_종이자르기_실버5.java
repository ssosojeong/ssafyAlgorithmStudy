package IMstudy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_2628_종이자르기_실버5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt(); //가로
		int H = sc.nextInt(); //세로
		int N = sc.nextInt(); //자르는 횟수
		//받아서 높은 숫자 순으로 뽑아낼 것
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		pq.add(W);
		pq.add(0);
		pq2.add(H);
		pq2.add(0);
		for(int i = 0; i < N; i++) {
			int chk = sc.nextInt();
			if(chk == 0) pq2.add(sc.nextInt());
			else pq.add(sc.nextInt());
		}
		//가로, 세로 별 최대 길이 찾기 //반복문 돌리는 방법 유의. for문 pq.size()는 당연히 안 됨.
		int wmax = 0;
		int hmax = 0;
		while(pq.size() != 1)
			//하나는 뽑아내고, 하나는 값만 이용
			wmax = Math.max(wmax, pq.poll()-pq.peek());
		while(pq2.size() != 1)
			hmax = Math.max(hmax, pq2.poll()-pq2.peek());
		System.out.println(wmax*hmax);
	}
}
