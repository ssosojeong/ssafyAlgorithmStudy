package src.kimsojeong.month8.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2477 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		
		//가장 긴 가로와 세로변, 주어진 변 길이를 저장할 변수
		int maxHor = -1;
		int maxHorIdx = -1;
		int maxVer = -1;
		int maxVerIdx = -1;
		int[] inputs = new int[6];
		
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());

			int dir = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			
			if(dir==1 || dir==2) {
				if(val>maxHor) {maxHor = val; maxHorIdx=i;}
			} else {
				if(val>maxVer) {maxVer = val; maxVerIdx=i;}
			}
			
			inputs[i] = val;
		}
		
		
		//가장 긴 변의 양쪽 변의 차이를 통해 빠지는 면적을 구할 수 있다
		int emptyArea=1;
		emptyArea*=Math.abs(inputs[(maxHorIdx+1)%6]-inputs[(maxHorIdx+5)%6]);
		emptyArea*=Math.abs(inputs[(maxVerIdx+1)%6]-inputs[(maxVerIdx+5)%6]);
			
		System.out.println(((maxHor*maxVer)-emptyArea)*K);
		

	}

}
