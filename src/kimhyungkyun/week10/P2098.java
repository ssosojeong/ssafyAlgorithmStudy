package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2098 {
	static int N;//정 2차원 행렬의 길이를 받을 변수 
	static int[][] W;//비용을 나타내주는 행렬
	static int[][] dp;
	static final int INF = 100000100; //1억 10
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) 
				W[i][j] = Integer.parseInt(st.nextToken());
		}//for
		
		dp = new int[N][(1<<N)-1];//현재 위치한 도시와, 지금까지 방문한 도시의 2진수 표현
		
		// 각 경우를 최소값으로 기록해주기 위해서 MAX_VAL을 가져왔지만 0인지아닌지로가능
		for(int i=0;i<N;i++) Arrays.fill(dp[i], INF); 
		
		/////////////입력값 받기 끝
		
		
		//현재  위치한 도시의 인덱스 , visitBitMask(지금까지 방문한 도시의 2진수 표기)
		//1번째 도시를 0001 방문했다고 체크한 BitMask가 된다.(0번째 인덱스를 사용하고 첫번째 도시라고 하는 이유는 W의 인덱스와 맞추기 위해서 0이라고 하는것)
		System.out.println(dfs(0,1)); 
		// 위 dfs의 의미가 현재 내가 1번 도시에 있을 때 모든 정점을 들른 후 1번 도시로 돌아 오는데 필요한 최소 비용을 의미한다.
		
		br.close();
	}//mian

	private static int dfs(int city, int visitBitMask) {
		if(visitBitMask == (1<<N) - 1) {//모든 도시를 돌고 11111이 되어서 왔던곳으로 돌아가기만 하면 될 때
			if(W[city][0] == 0) {
				return 100000000; //1억 
				//1로 들어갈 수 있는 간선이 없어서 무효화 시키기 위해서 큰 수를 넣어준다.
				//INF(2억)으로 처리하는 경우가 많은데 시간초과에러
				//왜냐하면, (61줄)dp를 사용하기 위해서 INF가 아닐때 조건을 사용하는데 INF가 들어가게 되면 (70줄)min값을 찾을 때 문제가 생긴다.
				//정확히 문제가 무엇이냐하면 min을 해서 가져와도 둘 다 INF 이기 때문에 return 되지 못하게 검사 안한 값이라고 판단하여 재귀가 계속 돌게된다. 그래서 시간초과가 뜸!
				
				//그러면 의문 점이 위 값은 그대로 1억이고 INF 값이 1이라도 크면 잘 작동해야하는데 INF가 1억1이면 시간초과가 뜬다.
				//INF가 1억10이상일 때는 빠르게 동작이되고 1억 5 이하일 때는 시간초과가 난다.
				//1억10 미만일 때는 작동은 되지만 시간이 좀 더 오래 걸리며 1억 10 이후부터는 속도가 최고점을 찍고  1억5천 쯤에는 오래걸리고 2억을 하면 다시 속도가 빨라진다.(???)
				// => 이거에 대한 추측은 그냥 그 상황 컴퓨터 상황에 따라서도 좀 다른듯..?
			}

			return W[city][0];
		}
		
		//이미 방문한 곳들을 토대로 골인 지점까지의 가중치의 최소값을 구해둔 상태
		if(dp[city][visitBitMask] != INF) {//(전에 계산한 것과 중복 dp를 이용) 이전에 이미 계산한 
			return dp[city][visitBitMask];
		}
		
		//
		for(int i=0;i<N;i++) {
			if((visitBitMask & (1<<i)) == 0 && W[city][i] != 0) {
				//dp의 값을 결정하는데 있어서 dp[city][visitBitMask]의 값이 될 수 있는 후보들 중 가장 작은 값을 선택하겠다.
				//후보라 함은 
				dp[city][visitBitMask] = Math.min(dp[city][visitBitMask], dfs(i,visitBitMask | (1 << i)) + W[city][i]);
				//이전 계산 과정에서 
			}
		}

		//여기까지 와서 return되는건 dp[0][1] 밖에 없다. 나머지는 위 두 if문에서 다 걸려서 return된다.
		return dp[city][visitBitMask]; 
	}//dfs
	
}//class
//이상현: N이 16이고 거리 최댓값이 백만이므로 최대 거리는 1600만이 됩니다. 그렇기때문에 INF는 이보다 커야하고, 
//       71번째줄에서 min값을 낼때, INF가 1억5라면 dp[city][visitBitMask]=1억 5 , dfs(i,visitBitMask | (1 << i))=1억, W[city][i]가 5보다 큰 상황이 나온다면 Math.min이
//       dp의 값을 갱신하지 못하게 됩니다. 그러면 해당 부분으로 갈 수 없다는 것을 제대로 표현할수 없게됩니다. 그러면 갔던 곳을 또 가게되고 시간이 오래걸립니다.
