package src.kimsojeong.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam10157{
	//운동 방향: 시계방향
	static int[] di= {-1,0,1,0}, dj= {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		//어떤 사람의 대기 번호가 배열에 들어갈 수 없는 경우 -> 연산 불필요하므로 바로 return
		if(K>C*R) {
			System.out.println("0");
			return;
		}

		int i=0, j=-1, dir=0, num=1;
		int[][] map = new int[C][R];
		
		//계산이 가능한 상황
		while(num<=K) {
			int newI = i+di[dir];
			int newJ = j+dj[dir];
			
			//운동방향 순환하도록
			if(newI<0 || newI>=C || newJ<0 || newJ>=R || map[newI][newJ]!=0) {
				dir = (dir+1)%4;
				continue;
			}
			
			map[newI][newJ]=num++;
			i=newI;
			j=newJ;
		}
		
		//위에서 구해진 배열은 문제가 원하는 답이 오른쪽으로 90도 회전된 모습임
		//따라서 x에 i, y에 j를 맞춰 출력해주고, 
		//또한 계산에 사용한 배열은 1,1이 아닌 0,0부터 시작됐으므로 각각 1을 더하여 출력하준다.
		System.out.println((i+1) + " " + (j+1));
		
	}
}
// P소정 : 연산이 불필요한 경우를 맨위로 빼서 바로 return하신게 되게 좋은 생각이신거 같아요! 그리고 ||로 한꺼번에 if 문의 경우의 수를 다룬것도 깔끔해용
//아 이건 살짝 헷갈려서 여쭤봅니다 j는 왜 초기값이 -1인가요!? 그리고 di와 dj를 static으로 main 밖으로 뺀 이유가 궁금합니다.!
