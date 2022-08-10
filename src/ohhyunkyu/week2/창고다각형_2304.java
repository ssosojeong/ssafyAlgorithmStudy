// 실패해서 재도전 중.

package week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 창고다각형_2304 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 기둥 개수

		int[] wh = new int[1001];

		for (int i = 0; i < N; i++) {
			wh[sc.nextInt()] = sc.nextInt(); // 기둥 위치에 높이 입력
		}

		// 가장 높은 기둥 찾기;
		int max = 0;

		List<Integer> maxIdx = new ArrayList<>();

		int idx = 0;

		for (int i = 0; i < 1001; i++) {
			if (wh[i] >= max) {
				max = wh[i]; // 기둥 최고점 높이
				maxIdx.add(idx++, i); // 가장 높은 기둥들 위치
			}
		}

		int lh = 0; // 왼쪽에서 기둥 높이 측정

		List<Integer> lIdx = new ArrayList<>();

		int lidx = 0; 

		for (int i = 0; i < maxIdx.get(0); i++) {
			if (wh[i] > lh) {
				lh = wh[i];
				lIdx.add(lidx++, i); // 높이가 달라질 때 기둥 위치 저장
			}
		}

		int lsum = 0; // 왼쪽면적 총합

		for (int i = 0; i < lIdx.size(); i++) {
			lsum += wh[lIdx.get(i)] * (lIdx.get(i + 1)- lIdx.get(i));
		}
		

		int rh = 0; // 오른쪽에서 기둥 높이 측정

		List<Integer> rIdx = new ArrayList<>();

		int ridx = 0;

		for (int i = 1000; i > maxIdx.get(maxIdx.size()-1); i--) {
			if (wh[i] > rh) {
				rh = wh[i];
				rIdx.add(ridx++, i); // 높이가 달라질 때 기둥 위치 저장
			}
		}

		int rsum = 0; // 오른쪽 면적 총합

		for (int i = 1; i < rIdx.size(); i++) {
			rsum += wh[rIdx.get(i-1)] * ((rIdx.get(i-1)+1) - rIdx.get(i));
		}
		
		//가장 높은 기둥들 추가해서 면적구하기
		
		int res = lsum + rsum;
		
		if(maxIdx.size() == 1) { // 가장 높은 기둥이 하나
			res += max;
		}else { // 둘 이상
			res += max * ((maxIdx.get(maxIdx.size()-1)+1)-maxIdx.get(0));
		}
		
		System.out.println(res);
		
	} // main
} // class

// 가장 높은 기둥은 기둥 자체 높이만큼, 여러개이면 사이 면적만큼 더하기.
// 가장 큰 기둥부터 찾기.
