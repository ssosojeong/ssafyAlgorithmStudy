import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam15922 {
	static class Line{
		int start;
		int end;
		public Line(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	
		int N = Integer.parseInt(br.readLine());
		Line[] lines = new Line[N];
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			lines[n] = new Line(s,e);
		}
		
		//선분들을 시작점을 기준으로 정렬해준다. -> 원래부터 정렬된 순으로 주어짐
		//이후 순차적으로 탐색하며, 시작점과 끝점을 탐색한다
		//예시
		//-5 -2
		//-3 0
		//2 5
		//6 10
		//8 12
		//1) (-5,-2)	-> start: -5, end: -2
		//2) (-3,0)		-> start: -5(이전 end보다 2의 start가 더 앞이므로), end: 0
		//3) (2,5)		-> 총 길이에 우선 +=5 (선분이 끊기므로
		//				-> start: 2, end: 5
		//4) (6,10)		-> 총 길이에 += 3
		//				-> start: 6, end: 10
		//5) (8,12)		-> start: 6, end: 12
		//=> 총 길이 : 5+3+6 = 14

		int start = -1000000001;
		int end = -1000000001;
		long ans = 0;
		for(Line l: lines) {
			//만약 이전까지 주어진 끝 점보다 현재 선분의 시작점이 크다면
			//선분이 끊기고 다시 시작하는 것이므로
			if(l.start>end) {
				ans += (end-start);
				start = l.start;
				end = l.end;
			} 
			//그게 아니라면 선분이 계속 이어지는 것이므로
			else {
				end = Math.max(end, l.end);
			}
		}
		
		//마지막에 더해지지 않은 선분의 길이를 더해준다.
		System.out.println(ans+(end-start));
		
	}
	
}
