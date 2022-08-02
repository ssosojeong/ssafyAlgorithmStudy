import java.util.Scanner;

public class areaOfRectangle_2669 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[100][100]; // 100*100 좌표를 2차원 배열로 표현
		int sum = 0; // 면적을 담을 변수
		for (int i = 0; i < 4; i++) { //4개의 사각형이기에 반복문을 돌린다
			int x = sc.nextInt();
			int y = sc.nextInt();
			int xplus = sc.nextInt();
			int yplus = sc.nextInt();
			for (int j = x; j <= xplus - 1; j++) { //한칸을 좌표로 보고 칸칸마다 1를 표기하며 sum에 더해간다.
				for (int k = y; k <= yplus - 1; k++) {
					if (arr[j][k] == 0) { // 만약 이미 1이라면 아무행동도 안한다.
						arr[j][k] = 1;
						sum += 1;
					}
				}
			}
		}
		System.out.println(sum);//sum 출력
	}
}
