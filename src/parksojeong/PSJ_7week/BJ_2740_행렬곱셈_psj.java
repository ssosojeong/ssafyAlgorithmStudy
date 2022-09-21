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

//김형균 :	우선은 행렬을 입력 받을 때 비슷한 코드가 반복되는데 이거는 for문을 통해서 받으면 반복을 없앨 수 있습니다.
//	  그 과정에서 if, else if 문이나 3차원 배열을 사용해 보아도 좋을것 같아요! 코드 깔끔하니 좋아요~!
//	  뿌듯할 기회가 3문제나 더 남았네요~ ^^ 파이팅~
