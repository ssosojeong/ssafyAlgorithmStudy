// 왜 안될까..

import java.util.ArrayList;
import java.util.Arrays;
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

		for (int i = 0; i < 1001; i++) {
			if (wh[i] >= max) {
				max = wh[i]; // 기둥 최고점 높이
//				maxIdx.add(idx++, i); // 가장 높은 기둥들 위치
				//.... 를 따로 구해야 하네. 여기서 하면 max 바뀔 때마다 들어감.
			}
		}
		System.out.println(max);
		
		int idx = 0; // 최고 높이 기둥들의 위치를 찾아보자.

		List<Integer> maxIdx = new ArrayList<>();
		
		for (int i = 0; i < 1001; i++) {
			if (wh[i] == max) {
				maxIdx.add(idx++, i);
			}
		} // 이제야 제대로 위치 잡힘.
		
		
		int lh = 0; // 왼쪽에서 기둥 높이 측정

		List<Integer> lIdx = new ArrayList<>();

		int lidx = 0;

		for (int i = 0; i <= maxIdx.get(0); i++) {
			if (wh[i] > lh) {
				lh = wh[i];
				lIdx.add(lidx++, i); // 높이가 달라질 때 기둥 위치 저장
			}
		}

		int lsum = 0; // 왼쪽면적 총합
		
		// 높이가 달라지는 경우의 수 별로 나누어 계산
		if(lidx >= 1) {
			for (int i = 0; i < lIdx.size()-1; i++) {
				lsum += wh[lIdx.get(i)] * (lIdx.get(i + 1) - lIdx.get(i));
			}
		}else if (lidx == 0) {
			lsum = wh[lIdx.get(0)] * (maxIdx.get(0) - lIdx.get(0));
		}
		System.out.println(lsum);
		
		int rh = 0; // 오른쪽에서 기둥 높이 측정

		List<Integer> rIdx = new ArrayList<>();

		int ridx = 0;

		for (int i = 1000; i >= maxIdx.get(maxIdx.size() - 1); i--) { 
			if (wh[i] > rh) {
				rh = wh[i];
				rIdx.add(ridx++, i); // 높이가 달라질 때 기둥 위치 저장
			}
		}
		
		int rsum = 0; // 오른쪽 면적 총합

		// 높이가 달라지는 경우의 수 별로 나누어 계산
		if(ridx >= 1) {
			for (int i = 0; i < rIdx.size()-1; i++) {
				rsum += wh[rIdx.get(i)] * ((rIdx.get(i)) - rIdx.get(i+1));
			}
		}else if(ridx == 0) {
			rsum = wh[rIdx.get(0)] * ((rIdx.get(0)) - maxIdx.get(maxIdx.size()-1));
		}
		System.out.println(rsum);
		
		// 가장 높은 기둥들 추가해서 면적구하기

		int res = lsum + rsum;

		if (maxIdx.size() == 1) { // 가장 높은 기둥이 하나
			res += max;
		} else { // 둘 이상
			res += max * ((maxIdx.get(maxIdx.size() - 1)) - maxIdx.get(0));
		}

		System.out.println(res);

	} // main
} // class

// 가장 높은 기둥은 기둥 자체 높이만큼, 여러개이면 사이 면적만큼 더하기.
// 가장 큰 기둥부터 찾기.
