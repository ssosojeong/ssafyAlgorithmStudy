import java.lang.reflect.Array;
import java.util.Scanner;

public class colorpaper_10163 {
	public static void main(String[] args) {

		int[][] bingo = new int[1001][1001]; // 빙고판 1001*1001 배열 만들기 초기값 0인것 활용
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 색종이 개수 구하기
		int[] overlab = new int[N]; // N번 동안 겹치는 부분 배열에 기록
		int sum = 0; // 면적 구할 변수
		int count = 0;//겹치는 부분 구할 변수
		for (int i = 0; i < N; i++) { // 색종이 개수의 순서대로 면적 구하기 위해서 반복문 돌리기
			int x = sc.nextInt(); //왼쪽 아래칸의 x 좌표
			int y = sc.nextInt();//왼쪽 아래칸의 y 좌표
			int xplus = sc.nextInt(); //가로 너비
			int yplus = sc.nextInt(); //세로 너비

			for (int j = x; j <= (x + xplus - 1); j++) { //가로 좌표
				for (int k = y; k <= (y + yplus - 1); k++) { //세로좌표
						sum += 1; // 면적구하기
					if (bingo[j][k] == 1) {
						count++; //겹치는 부분 구하기
					}
				}
			}
			overlab[i] = count;
			count =0;
			// 겹치는 부분을 1로 인식을 해서 빼려했는데 색종이가 늘어갈수록 구분이 안되어서 길을 잃었습니다
			
		}

	}

}


/* 김소정 
   케이스마다 돌려보지 않아서 잘 모르겠지만 우선, 만약 bingo[j][k]에서 겹치는 부분을 구하신다고 하셨는데, 그러기 위해선 우선
   bingo[][]에 해당 종이가 차지하는 부분을 1로 표시해주는 코드가 필요할 것 같습니다!
   bingo[][]에 단순히 종이가 덮여있다=1 / 빈 공간이다=0로만 표시해주고,
   무조건 라인23에서 1로 검사해주면, 색종이가 늘어도 괜찮아지지 않을까.. 하는 생각을 해봤습니당
*/
