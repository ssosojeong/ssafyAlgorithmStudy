package studysol_1;

import java.util.Scanner;

public class 딱지놀이_14696 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		
		int irnd = sc.nextInt();

		for (int i = 0; i < irnd; i++) {

			int ac = sc.nextInt();
			int[] A = new int[ac];
			for (int j = 0; j < ac; j++) {
				A[j] = sc.nextInt();
			} // 카드 입력

			int bc = sc.nextInt();
			int[] B = new int[bc];
			for (int j = 0; j < bc; j++) {
				B[j] = sc.nextInt();
			} // B 카드 입력
			
			game(A, B);

		}

	} // main

	public static void game(int[] a, int[] b) {
		for (int i = 4; i > 0; i--) {
			int a_ = 0;
			int b_ = 0;
			
			for(int j=0; j < a.length; j++) {
				if(a[j] == i) {
					a_++;
				}
			}
			for(int j=0; j < b.length; j++) {
				if(b[j] == i) {
					b_++;
				}
			}
			
			if (a_ > b_) {
				System.out.println("A");
				break;
			} else if (a_ < b_) {
				System.out.println("B");
				break;
			} else {
				if (i == 1) {
					System.out.println("D");
				}
			}
		}
	}

} // class
