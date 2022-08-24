package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2628 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer cr = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(cr.nextToken()); //가로
		int row = Integer.parseInt(cr.nextToken()); //세로
		int num = Integer.parseInt(br.readLine()); //자르는 횟수
		
		
		
		//문제 해결 방법 : 한줄로 쭉 자르기 때문에 결국 잘리고 나서 가장 긴 가로와 세로만 구해주면 된다.
		int[] arrCol = new int[col+1];// 인덱스의 차로 길이를 구해줄 예정이라 +1을 해줌
		int[] arrRow = new int[row+1];
		
		for(int i=0; i<num;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("1")) arrCol[Integer.parseInt(st.nextToken())]=1;
			else arrRow[Integer.parseInt(st.nextToken())]=1;
		} //자르는 정보를 바탕으로 가장 잘린 부분의 값을 1로 바꿈

		//인덱스의 차이로 종이의 길이를 구할 것이기 때문에 인덱스를 저장해줄 변수 필요(0의 갯수로 하면 오답이 나옴)
		int idxOneCol =0;
		int idxOneRow =0;
		int lenCol=0;
		int lenRow=0;
		int maxCol =Integer.MIN_VALUE;
		int maxRow =Integer.MIN_VALUE;
		for(int i=0;i<=col;i++) {//가로 최대값 찾기
			if(arrCol[i]==1) {
				lenCol = i-idxOneCol;
				maxCol = Math.max(maxCol, lenCol);
				idxOneCol=i;
			}
			if(i==col) { //마지막 부분에는 1이 아니니까 따로 길이를 구해주어야한다.
				lenCol = col-idxOneCol;
				maxCol = Math.max(maxCol, lenCol);
			}
		}//가로 최댓값 구하기 for문 끝
		for(int i=0;i<=row;i++) {//세로 최대값 찾기
			if(arrRow[i]==1) {
				lenRow = i-idxOneRow;
				maxRow = Math.max(maxRow, lenRow);
				idxOneRow=i;
			}
			if(i==row) { //마지막 부분에는 1이 아니니까 따로 길이를 구해주어야한다.
				lenRow = row-idxOneRow;
				maxRow = Math.max(maxRow, lenRow);
			}
		}//세로 최댓값 구하기 for문 끝
		
		System.out.println(maxCol*maxRow);
		
		br.close();
	}
}

//김소정: 인덱스를 활용하면 굳이 정렬할 필요가 없으니까 좋은 것 같습니다! 어차피 입력값의 범위도 100까지라
//		엄청 크지 않으니까...
