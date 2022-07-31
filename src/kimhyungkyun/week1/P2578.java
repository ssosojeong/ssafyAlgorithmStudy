package studybaek;

import java.util.Scanner;

public class P2578 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 빙고 sheet 작성
		// 입력값 1행부터 5행까지 받기
		int[][] bingoSheet = new int[5][5];
		for (int i = 0; i < 5; i++) {
			// 입력값 1열부터 5열까지 받기
			for (int j = 0; j < 5; j++) {
				bingoSheet[i][j] = sc.nextInt();
			}
		}

		// 빙고 답안 작성
		int[][] bingoAnswer = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				bingoAnswer[i][j] = sc.nextInt();
			}
		}
		
		// bingoAnswer의 1행1열부터 5행5열까지 값체크하면서 빙고 있는지 체크하기
		// 사회자가 부른 값을 넣을 변수
		int check = 0;
		// 빙고가 몇 줄 인지 체크할 변수
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				// bingoAnswer 차래대로 값 받아오기
				check = bingoAnswer[i][j];
				int count = 0;
				// 저장한 check값과 bingo의 값이 같은 값이 있으면 그 값을 0으로 만들어서 지워준다.
				bA: for (int m = 0; m < 5; m++) {
					for (int n = 0; n < 5; n++) {
						if (bingoSheet[m][n] == check) {
							bingoSheet[m][n] = 0;

							// 0으로 체크해줬으니까 bingo가 되었는지 체크해준다.
							// 행체크
							
							for (int l = 0; l < 5; l++) {
								// 하나의 줄에 0이 아닌 수가 한개라도 있으면 false로 변환해서 한줄 빙고가 안됨을 알림
								boolean lineCheck = true;
								for (int k = 0; k < 5; k++) {
									if (bingoSheet[l][k] != 0) {
										lineCheck = false;
										break;
									}
								}
								// 만약 false로 안바뀌고 true로 나왔으면 그 줄은 다 0이므로 bingo! 카운트를 하나 늘려준다.
								if (lineCheck)
									count++;
							}
							// 열체크
							for (int k = 0; k < 5; k++) {
								// 하나의 줄에 0이 아닌 수가 한개라도 있으면 false로 변환해서 한줄 빙고가 안됨을 알림
								boolean lineCheck = true;
								for (int l = 0; l < 5; l++) {
									if (bingoSheet[l][k] != 0) {
										lineCheck = false;
										break;
									}
								}
								// 만약 false로 안바뀌고 true로 나왔으면 그 줄은 다 0이므로 bingo! 카운트를 하나 늘려준다.
								if (lineCheck)
									count++;
							}
							// 좌상우하 대각선체크
							boolean lineCheckLeftDia = true;
							for (int l = 0; l < 5; l++) {
								if (bingoSheet[l][l] != 0) {
									lineCheckLeftDia = false;
									break;
								}
							}
							if (lineCheckLeftDia) count++;

							// 우상좌하 대각선체크
							boolean lineCheckRightDia = true;
							for (int k = 0; k < 5; k++) {
								if (bingoSheet[k][4 - k] != 0) {
									lineCheckRightDia = false;
									break;
								}
							}
							if (lineCheckRightDia) count++;

							// 3줄 빙고시 첫번 째 수 부른 후 몇번째 만에 빙고가 나왔는지 출력하고 프로그램을 종료
							if (count >= 3) {
								System.out.printf("%d", 5 * (i) + j + 1);
								sc.close();
								return;
							}
							//카운트를 0으로 초기화 해주지 않으면 카운트 하였던 빙고줄이 계속 카운트 되기 때문에 처음으로 3줄이 빙고일 때를 기준으로 찾기위해 0을 대입해준다.
							count = 0;
							
							break bA;
						}
					}
				}
				

				// 0으로 다 바꾸고 하니까 문제가 생기지. 그럼 0으로 바꿀 때마다 확인을 해주어야 하는데
			}
		}
		sc.close();
	}
}