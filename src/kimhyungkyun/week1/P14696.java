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


/* 김소정
	라인 22부터 40번까지 A와 B의 카드 정보를 받아오시는데, 어차피 모양도 int로 받아오고 배열에 대한 접근도 int의 인덱스를 통해 이뤄지기 때문에,
	단순히 aOfArray[convas]++로 표현하면 더 좋을 것 같습니다!
	저의 경우에는 별이 4로 주어지기 때문에 arr[4]에는 별 갯수, arr[3]에는 동그라미 갯수.. 로 저장했는데
	aOfArray[4-convas]로 하시면 0,1,2,3 순으로 원하신대로 저장될 것 같아요!

	비교 역시 aOfArray[n] bOfArray[n]의 형태로 이뤄지기 때문에,
	for문으로 비교할 인덱스를 증가시키며 비교하면 더 좋을 것 같습니다!
 */