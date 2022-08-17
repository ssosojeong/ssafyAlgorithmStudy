package week3;


import java.util.Scanner;

public class P10157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();//가로(열)
		int R = sc.nextInt();//세로(행)
		
		int K = sc.nextInt();
		
		int[][] arr = new int[R][C];
		
		if (C*R>=K) { // 대기 인원이 자리보다 더 크지 않을 때만 아래와 같은 과정 실행 아니면 그냥 0출력
			//왼쪽 아래부터 달팽이 식으로 값 대입
			int[] dr = {-1,0,1,0}; //상우하좌 탐색
			int[] dc = {0,1,0,-1}; //상우하좌 탐색
			int direction = 0;
			int StartIndexR = R-1;
			int StartIndexC = 0;
			int num=1; // 배열 안에 대입할 값
			int beforeX=0; //문제가 x,y를 정의한대로 바꾸기 전의 x(=인덱스)를 담을 변수
			int beforeY=0; //문제가 x,y를 정의한대로 바꾸기 전의 y(=인덱스)를 담을 변수
			while(num<=R*C) { //돌아가면서 값 대입
				
				if (direction==0 || direction==2) {
					if(num==K) {
						beforeX=StartIndexC;
						beforeY=StartIndexR;
						break; // K를 만족하는 위치만 찾으면 더 달팽이를 만들 필요 없으니까 while문 break
					}
					arr[StartIndexR][StartIndexC]=num++;
					StartIndexR += dr[direction];
					StartIndexC += dc[direction];
				}
				
				if(StartIndexR<0 ||StartIndexR>=R ||arr[StartIndexR][StartIndexC]!=0) { //행을 변환하던 중 벽 or 값이 있는 곳에 부딪힐 때
					
					StartIndexR += dr[(direction+2)%4]; // Row를 한칸 오버하게 이동 했기 때문에 반대 방향으로 다시 조정해주는 것
					StartIndexC += dc[(direction+1)%4]; // 방향이 0이여서 위로 올라가야할 때는 오른쪽으로 이동, 방향이 2이여서 아래로 내려갈 때는 왼쪽으로
					direction += 1;
					direction = direction%4;
				}
				
				if (direction==1 || direction==3) {
					if(num==K) {
						beforeX=StartIndexC;
						beforeY=StartIndexR;
						break;
					}
					arr[StartIndexR][StartIndexC]=num++;
					StartIndexR += dr[direction];
					StartIndexC += dc[direction];
				}
				
				if(StartIndexC<0 ||StartIndexC>=C ||arr[StartIndexR][StartIndexC]!=0) { /열을 변환하던 중 벽 or 값이 있는 곳에 부딪힐 때
					StartIndexR += dr[(direction+1)%4]; // 방향이 1이여서 오른쪽으로 가야할 때는 아래쪽으로 이동, 방향이 3이여서 왼쪽으로 갈 때는 위쪽으로
					StartIndexC += dc[(direction+2)%4]; // Col를 한칸 오버하게 이동 했기 때문에 반대 방향으로 다시 조정해주는 것
					direction += 1;
					direction = direction%4;
				}
				
				
			}
			
			//K가 있는 곳을 찾은 beforeX(열), beforeY(행)를 통해서 문제에서 원하는 X,Y값으로 변환해주기
			int afterX = beforeX+1;
			int afterY = R - beforeY;
			
			System.out.printf("%d %d",afterX,afterY);
		} else {
			System.out.println(0);
		}
		
		sc.close();
	}
}

//오현규: 변수명도 친절하게 작성되어서 잘 보았습니다. while문 내에서 num == K이면 break하는 것이 반복되는 것으로 보이는데, 
//        아예 while문의 조건을 num !=K로 주어서 탈출하는 건 어떨까요?
//김형균 : 음~ 그렇네요 생각지 못한 부분이네요. 다음 코드 짤 때는 그런 방법도 한번 사용해 볼게요! 감사합니다~
