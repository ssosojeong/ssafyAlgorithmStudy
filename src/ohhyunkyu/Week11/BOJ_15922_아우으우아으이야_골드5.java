package week11;

import java.util.Scanner;

public class BOJ_15922_아우으우아으이야_골드5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 그릴 선분 개수
		long ans = 0;
		long st = sc.nextInt();//구간 시작
		long ed = sc.nextInt();//끝
		for(int i = 1; i < N; i++) {
			long x = sc.nextInt();
			long y = sc.nextInt();
			//현재 가진 선분의 끝점과 다음 선분의 시작점  비교
			if(x > ed) {
				ans += ed - st;
				st = x;
				ed = y;
			}
			//겹쳐져 있다면
			else {
				if(ed < y) ed = y;
			}
			//종료 시점
			if(i == N - 1) ans += ed - st;
		}
		//예외범위 확인하자
		if(N == 1) ans = ed - st;
		System.out.println(ans);
	}
}
//범위 안에 다음 선분의 시작점이 있으면 그대로 이어가기
//더 이상 이어가기가 불가능하면 ans에 더하기