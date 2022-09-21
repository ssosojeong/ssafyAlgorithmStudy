package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2740 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] matrixA = null,matrixB = null; //행렬 A,B
		for(int n=0;n<2;n++) {//두 행렬 받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int NM = Integer.parseInt(st.nextToken());//A의 N,B의 M을바들 변수
			int MK = Integer.parseInt(st.nextToken());//A의 M,B의 K을바들 변수
			int[][] matrix = new int[NM][MK];
			for(int i=0;i<NM;i++) {//행의 갯수만큼 입력값이 들어오니까 NM보다 작음
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<MK;j++) {//열의 갯수만큼 뿌려주어야한다.
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}//for
			}//for
			if(n==0) matrixA = matrix;
			else matrixB = matrix;
		}//for
		
		//////////////////////입력값 받기 끝
		
		int[][] resMatrix = matProduct(matrixA,matrixB);
		int N = resMatrix.length;//행갯수
		int M = resMatrix[0].length;//열갯수
		for(int i=0;i<N;i++) {//행
			for(int j=0;j<M;j++) {//열
				System.out.printf("%d ",resMatrix[i][j]);
			}//for
			System.out.println();
		}//for
		
		br.close();
	}//main

	private static int[][] matProduct(int[][] matrixA, int[][] matrixB) {
		int N = matrixA.length;
		int M = matrixB[0].length;
		int K = matrixB.length;
		int[][] matrix = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int temp=0;
				for(int k=0;k<K;k++) {
				temp += matrixA[i][k]*matrixB[k][j];
				}//for
				matrix[i][j]=temp;
			}//for
		}//for
			
		return matrix;
	}//matProduct

}//class

//김소정: 어차피 N,M,K는 다 주어지니까 그냥 맨 처음에 static으로 선언해놓고 빼서 써도 될 것 같아요!