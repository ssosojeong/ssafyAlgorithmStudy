package studybaek;

import java.util.Scanner;

public class P14696 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//딱지놀이의 총 라운드 수 받기
		int N = sc.nextInt();
		
		for (int i=0; i<N ; i++) {
			
			//A와 B의 그림들 갯수 카운팅해서 보관해둘 배열(index 0 부터 별 , 동그라미 , 네모 , 세모)
			int[] aOfArray = new int[4];
			int[] bOfArray = new int[4];
			
			//A가 몇개의 그림 정보를 줄 지 입력받기
			int aNumber = sc.nextInt();
			//A의 그림에 대한 정보 입력받기
			for(int j=0;j<aNumber;j++) {
				int convas = sc.nextInt();
				if (convas==4) aOfArray[0]++;
				else if (convas==3) aOfArray[1]++;
				else if (convas==2) aOfArray[2]++;
				else if (convas==1) aOfArray[3]++;
				else System.out.println("값이 잘못입력되었습니다.");
			}
			//B가 몇개의 그림 정보를 줄 지 입력받기
			int bNumber = sc.nextInt();
			//B의 그림에 대한 정보 입력받기
			for(int j=0;j<bNumber;j++) {
				int convas = sc.nextInt();
				if (convas==4) bOfArray[0]++;
				else if (convas==3) bOfArray[1]++;
				else if (convas==2) bOfArray[2]++;
				else if (convas==1) bOfArray[3]++;
				else System.out.println("값이 잘못입력되었습니다.");
			}
			
			
			//aOfArray 배열과 bOfArray를 비교해서 누가 승자인지 표시
			//별로 승패 비교
			if (aOfArray[0]>bOfArray[0]) {
				System.out.println("A");
			} else if (aOfArray[0]<bOfArray[0]) {
				System.out.println("B");
			} else {
				//동그라미로 승패 비교
				if (aOfArray[1]>bOfArray[1]) {
					System.out.println("A");
				} else if (aOfArray[1]<bOfArray[1]) {
					System.out.println("B");
				} else {
					//네모로 승패 비교
					if (aOfArray[2]>bOfArray[2]) {
						System.out.println("A");
					} else if (aOfArray[2]<bOfArray[2]) {
						System.out.println("B");
					} else {
						//세모로 승패 비교
						if (aOfArray[3]>bOfArray[3]) {
							System.out.println("A");
						} else if (aOfArray[3]<bOfArray[3]) {
							System.out.println("B");
						} else {
							System.out.println("D");
						}
					}
				}
			}
			//승패 비교 위한 if문 끝남
					
		}
		
		sc.close();
	}
}
