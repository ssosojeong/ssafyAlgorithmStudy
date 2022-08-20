package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2477 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int rowMax = Integer.MIN_VALUE;
		int colMax = Integer.MIN_VALUE;
		//가장긴 길이에서 3칸 뒤로 돌아가면 빼야할 사각형의 넓이이기 때문에 가장 큰 변의 길이와 가장 짧은 변의 길이를 구해준다.
		
		int[] direction = new int[6];
		int[] length = new int[6];
		int idxCol=0;
		int idxRow=0;
		for(int i=0;i<6;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			direction[i] = Integer.parseInt(st.nextToken());
			length[i] = Integer.parseInt(st.nextToken());
			
			if(direction[i]<=2 && colMax<length[i]) { //세로 길이를 측정
				colMax = length[i];
				idxCol = i; //가로가 가장 길때 
			} else if(direction[i]>=3 && rowMax<length[i]){ // 가로길이를 측정
				rowMax = length[i];
				idxRow = i;
			}
		}//방향과 길이에 대한 정보 입력 받기
		//우선 시작을 어느 방향으로 하느냐에 따라서 경우를 나누기
		
		if(idxCol-3<0) idxCol += 3; // 3빼고 음수가 되니까 6을 더해줘서 최종적으로 3을 더해주어야 한다.
		else idxCol -= 3; //음수가 안될때는 그냥 뒤로 3칸만 보내주면된다.
		if(idxRow-3<0) idxRow += 3;
		else idxRow -= 3;
		
		int area = colMax*rowMax - length[idxCol]*length[idxRow];
		System.out.println(area*K);
		br.close();
	}
}
