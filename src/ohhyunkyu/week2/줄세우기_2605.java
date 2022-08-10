package week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 줄세우기_2605 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 숫자
		int N = sc.nextInt();
		
		// 학생들을 담을 리스트 생성
		List<Integer> arr = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) { // 첫번째(1번) 학생이므로 1부터 시작.
			arr.add(sc.nextInt(), i); 
			// 어레이리스트를 통해 뽑은 숫자에 맞게 학생을 집어넣는다.
		} // 자동적으로 학생들을 순서에 맞게 정렬
		
		for(int i = N - 1; i >= 0; i--) { // 문제 조건 상 거꾸로 출력한다.
			System.out.print(arr.get(i) + " ");
		}
		
	} //main
} //class
