package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2564 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[row+1][col+1]; //꼭짓점을 기준으로 계산해주기 위해서 칸을 한칸씩 늘려주었디.
		
		int number = Integer.parseInt(br.readLine());
		int[] cols = new int[number+1];//상점들과 동근이의 열 정보를 저장할 배열
		int[] rows = new int[number+1];//상점들과 동근이의 행 정보를 저장할 배열
		int[] directions = new int[number+1]; //동서남북 방향을 저장해둘 배열 
		int[] arrNearest = new int[number+1];//상점들 마다 거리를 저장해줄 배열(사실 Nearest에는 동근이 위치와 거리가 얼마나 되는지 이기 때문에 +1이 없어도됩니다.)
		for(int n=1;n<=number+1; n++) { //동근이의 위치는  number+1로 해서 표시해준다. n이 1부터인 이유는 배열안에 상점들의 위치값을 나타내기 위함
			StringTokenizer stDS = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(stDS.nextToken());
			directions[n-1] = direction;
			int step = Integer.parseInt(stDS.nextToken());
			setPoint(arr,n,direction,step,cols,rows);
		}
		// 여기까지가 상점과 동근이의 위치 셋팅
		
		
		for(int i=1;i<=number;i++) {//arrNearesr 배열에 각 상점마다 근거리 값 넣기
			arrNearest[i] = nearest(arr,directions,cols,rows,i);
		}
		
		int sum =0;
		for(int i=1;i<=number;i++) {
			sum += arrNearest[i];
		}
		
		System.out.println(sum);
		
		
		br.close();
	}
	public static void setPoint(int[][] arr,int n,int direction,int step,int[] cols, int[] rows) { //2차원 배열에다가 상점과 동근이의 위치를 찍어줄 함수
		if(direction==1) {
			arr[0][step] = n;
			rows[n-1] = 0;
			cols[n-1] = step;
		}else if(direction==2) {
			arr[arr.length-1][step] = n;
			rows[n-1] = arr.length-1;
			cols[n-1] = step;
		}else if(direction==3) {
			arr[step][0] = n;
			rows[n-1] = step;
			cols[n-1] = 0;
		}else { //direction==4
			arr[step][arr[0].length-1] = n;
			rows[n-1] = step;
			cols[n-1] = arr[0].length-1;
		}
	}
	public static int nearest(int[][] arr,int[] directions,int[] cols , int[] rows ,int i) {//cols와 rows는 0인덱스도 사용하기 때문에 다른 배열과 다르게 i-1해서 사용해야합니다.
		int donggeunCol = cols[cols.length-1];
		int donggeunRow = rows[rows.length-1];
		int donggeunDirection = directions[directions.length-1];
		int nearest=0;
		if (directions[i-1]==donggeunDirection) { //같은 방향에 있는 경우
			if(donggeunDirection<=2) nearest += Math.abs(cols[i-1]-donggeunCol);
			else nearest += Math.abs(rows[i-1]-donggeunRow);
		} else if((directions[i-1]<=2 && donggeunDirection<=2) || (directions[i-1]>=3 && donggeunDirection>=3)) { //서로 반대 방향에 있는 경우
			nearest += Math.abs(cols[i-1]-donggeunCol);
			nearest += Math.abs(rows[i-1]-donggeunRow);
			if(directions[i-1]<=2) { //col을 기준으로 계산하는 경우
				nearest += 2*Math.min(Math.min(donggeunCol, cols[i-1]),(arr[0].length-1)-Math.max(donggeunCol, cols[i-1]));
			} else { //row를 기준으로 계산하는 경우
				nearest += 2*Math.min(Math.min(donggeunRow, rows[i-1]),(arr.length-1)-Math.max(donggeunRow, rows[i-1]));
			}
		} else { // 그 외 경우
			nearest += Math.abs(cols[i-1]-donggeunCol);
			nearest += Math.abs(rows[i-1]-donggeunRow);
		}
		
		return nearest;
	}
}
