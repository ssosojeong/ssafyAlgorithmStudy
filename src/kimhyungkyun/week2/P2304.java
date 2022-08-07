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
