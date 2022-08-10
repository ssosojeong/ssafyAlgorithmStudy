package week2;

import java.util.Scanner;

public class P2304 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//기둥의 갯수 N 
		int N = sc.nextInt();
		//좌표에 정보를 담고 있을 2차원 배열 생성
		int [][] infoArray = new int[N][2];
		
		//제일 높은 기둥의 정보를 저장해둘 변수 생성
		int heightest=0;
		int heightestX=0;
		//정보 입력 및 hieghtest의 정보 저장
		for (int i=0; i<N ; i++) {
			infoArray[i][0] = sc.nextInt();
			infoArray[i][1] = sc.nextInt();
			if (heightest< infoArray[i][1]) {
				heightest=infoArray[i][1];
				heightestX=infoArray[i][0];
			}
		}
		
		//들어오는 값 x값 기준 오름차순으로 정렬
		for (int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(infoArray[i][0]>infoArray[j][0]) {
					//일시적으로 값을 저장해줄 변수 x,y
					int x = infoArray[i][0];
					int y = infoArray[i][1];
					//i번째 있는 배열과 j번째 있는 배열값 변경
					infoArray[i][0] = infoArray[j][0];
					infoArray[i][1] = infoArray[j][1];
					infoArray[j][0] = x;
					infoArray[j][1] = y;
				}
			}
		}
		
		//제일 높은 곳의 인덱스 찾기
		int heightestIndex = -1;
		for(int i=0;i<N;i++) {
			if(infoArray[i][0] == heightestX) {
				heightestIndex = i;
				break;
			}
		}
		
//		//2중배열 중간점검 삭제 필
//		for(int i=0;i<N;i++) {
//			System.out.printf("%2d %2d\n",infoArray[i][0],infoArray[i][1]);
//		}
		//전체 넓이
		int area = 0;
		//heightestIndex 전까지 넓이 구하기
		int beforeArea = 0;
		int nextIndexBefore=-1;
		for (int i=0;i<heightestIndex;i=nextIndexBefore) {
			//다음 막대기가 전의 막대기 보다 길이가 긴지 확인 짧으면 패스
			for(int j =i+1;j<=heightestIndex;j++) {
				//i번째보다 긴 막대기 찾기
				if(infoArray[i][1]<infoArray[j][1]) {
					nextIndexBefore = j;
					break;
				}
			}
			int width = infoArray[nextIndexBefore][0]-infoArray[i][0];
			beforeArea += width*infoArray[i][1];
			if (nextIndexBefore == heightestIndex) break;
		}
		area += beforeArea;
		
		//heightest 까지 더하기
		area += heightest;
		
		//heightest 이후의 넓이 더하기
		int afterArea =0;
		int nextIndexAfter=-1;
		for (int i=N-1;i>heightestIndex;i=nextIndexAfter) {
			//다음 막대기가 전의 막대기 보다 길이가 긴지 확인 짧으면 패스
			for(int j =i-1;j>=heightestIndex;j--) {
				//i번째보다 긴 막대기 찾기
				if(infoArray[i][1]<infoArray[j][1]) {
					nextIndexAfter = j;
					break;
				}
			}
			int width = infoArray[i][0]-infoArray[nextIndexAfter][0];
			afterArea += width*infoArray[i][1];
			
			if (nextIndexAfter == heightestIndex) break;
		}
		
		area += afterArea;
		
		
		System.out.println(area);
		
		sc.close();
		
	}
}
// runtime 에러가 떴어요 ㅜ 혹시 다 완성되기전에 런타임이 에러가 날 방법인지 아닐지 예측하는 방법들이 있으신가요? 
// 이상현 : 61번째, 82번째 3번째 i++부분에 다른게 입력되어있어서 그런거 아닐까요?
// 김형균 : 앗.. 런타임에러가 아니라 시간초과가 떴어요. 말실수 했어요. 죄송해요 ㅜㅜ 문제 풀기전에 시간초과가 되는지 미리 알고 싶어요!
// 이상현 : 코드가 있는거로는 아는데.. 그게 정확하진 않다고 들었어요. 그것보다 해당 문제의 제한시간을 보고, 입력받는 변수의 갯수를 따져봤을때
//         시간복잡도를 통해서 자신이 생각했던 방식이 시간이 초과될 방식인지 아닌지 계산하고 코딩을 시작하는게 맞긴해요.
//         이문제는 N=1000이기때문에 2중for문을 돌려도 N^2 = 1000000이라서 시간초과될일은 없는데, 위에 말씀드린 저 부분에 i가 고정이 되어버리면 무한for문이 되어서 시간초과가 떠요.
//         해당 코드같은경우는 if문에 nextIndexAfter를 바꿔주는 부분이 있어서 표면상 괜찮을 것 같지만, 만약 가장 높은 막대가 2개라면 두개의 값 highest[1] highest[2]가 설정되어야 하는데
//         뒤의 highest[2]로 고정되어버리기 때문에 61번째 for문으로 실행시키면 중간에 highest[1]을 만나서 무한루프가 되어버립니다.
//         그리고 가장 높은 건물의 높이와 인덱스를 한번에 저장하면 for문을 2번 돌릴 필요가 없어서 시간이 단축될 것으로 보입니다. 
// 김형균 : 강사하셔도 되겠어요. 상현님.. ㄷㄷ 쩌시네요 피드백을 바탕으로 열심히 수정해 보겠습니다. 감사합니다~

// 김소정 : 최고높이의 건물이 2개 있을 경우 무조건 왼쪽에 있는 인덱스가 반환되는 것 같은데 그러면 그 사이의 넓이는 어디서 계산되는건지 궁금합니다. 뭔가 86이나 65에서
//			높이 비교할 때 이상으로 비교해줘야 하는게 아닌가..? 싶기도 해서요!