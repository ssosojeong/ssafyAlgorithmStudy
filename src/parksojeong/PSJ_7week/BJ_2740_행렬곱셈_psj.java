import java.util.Scanner;

public class BJ_2740_행렬곱셈_psj {
	//이건 백프로 제 힘으로 푼건데 너무 뿌듯하네용 히히
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// A행렬 입력받습니다
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] A = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		// B행렬 입력받습니다
		M = sc.nextInt();
		int K = sc.nextInt();
		int[][] B = new int[M][K];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < K; j++) {
				B[i][j] = sc.nextInt();
			}
		}
		
		// 행렬의 곱 출력합니다
		for(int i =0;i<N;i++) { 
			for(int j=0;j<K;j++) {
				int sum = 0;
				// 행렬의 곱 인덱스를 다 써봤더니 다음과 같은 규칙이 나왔습니다
				for(int k=0;k<M;k++) {
					sum+=A[i][k]*B[k][j];
				}
				System.out.print(sum+" ");
			}
			System.out.println();
		}
	}
}
