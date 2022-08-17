package week3;

import java.util.Scanner;

public class BOJ_2491_수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 주어진 수열의 길이

		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		int max = 1; // 가장 긴 연속 증감 수열의 길이
		
		// ?? max 초기값이 2면 틀리고 1이면 맞네.. 왜지
		// 그건 주어진 수열의 길이 N이 1일 경우를 포함하기 때문.
		
		int cnt = 1; // 자기 자신부터 시작
		
		// 증가하는 수열 찾기
		
		// 두개씩 비교해서 확인, cnt 조정으로 max와 비교. 
		
		for(int i = 0; i < N - 1; i++) {
			if(nums[i] <= nums[i+1]) {
				cnt++;
			}else {
				if(max < cnt) {
					max = cnt;
				}
				cnt = 1; // 한번 걸리면 비교 후 초기화
			}
			if(max < cnt) { // 마지막 한번도 확인할 수 있게
				max = cnt;
			}
		}
		
		// 감소하는 수열 찾기(위와 부등호만 다르게)
		
		cnt = 1; // 초기화
		
		for(int i = 0; i < N - 1; i++) {
			if(nums[i] >= nums[i+1]) {
				cnt++;
			}else {
				if(max < cnt) {
					max = cnt;
				}
				cnt = 1;
			}
			if(max < cnt) {
				max = cnt;
			}
		}

		System.out.println(max);
	}
}

//김소정: 37~39, 55~57이 마지막 한번도 확인하게 하는 구문이라면 for문 밖으로 빼서 연산횟수를 줄이면 더 좋을 것 같습니다!