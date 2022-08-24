package week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2628_종이자르기_실버5 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int c = sc.nextInt(); // 가로 길이
		int r = sc.nextInt(); // 세로 길이
		
		int N = sc.nextInt(); // 자르는 횟수
		
		List<Integer> carr = new ArrayList<>(); // 가로 
		List<Integer> rarr = new ArrayList<>(); // 세로
		
		// 위의 두 리스트를 사용해 가로 세로 조각별 길이의 최대값을 구할 것
		// 그것을 위해 리스트에 0과 주어진 최대 길이를 추가해줌
		carr.add(0);
		rarr.add(0);
		
		for(int i = 0; i < N; i++) {
			
			int D = sc.nextInt(); // 식별자(가로 0, 세로 1)
			
			if(D == 0) {
				carr.add(sc.nextInt());
			} else {
				rarr.add(sc.nextInt());
			}
		}
		
		carr.add(r);
		rarr.add(c);
		
		// 오름차순 정렬로 계산하기 쉽게 함
		carr.sort(null);
		rarr.sort(null);
		
		int cmax = 0;
		int rmax = 0;
		
		// 최댓값 구하기
		for(int i = 1; i < carr.size(); i++) {
			int tmp;
			tmp = carr.get(i) - carr.get(i - 1);
			if(cmax < tmp) {
				cmax = tmp;
			}
		}
		for(int i = 1; i < rarr.size(); i++) {
			int tmp;
			tmp = rarr.get(i) - rarr.get(i - 1);
			if(rmax < tmp) {
				rmax = tmp;
			}
		}
		
		// 출력부
		System.out.println(cmax * rmax);
	}
}

// 끝까지 자르기 때문에, 가로 세로에서 각각 가장 큰 부분 길이를 구해 곱하면 해결.
// p 소정입니다 : 코드가 깔끔해서 보기 좋습니당 가로세로 각각이 꼭 최대가 아니여도 
// 곱한값이 최대가 될 수 있다고 생각했는데 각각 최대를 구하고 되는 줄 몰랐어요! 완벽하게 이해는 안되는데 설명 부탁드립니다!
