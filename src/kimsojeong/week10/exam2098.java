package src.kimsojeong.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1. 시작점은 0으로 삼는다. -> 어차피 사이클이므로 어디서 시작하든 최소 비용은 같다
// 2. dp[i][visit] -> 지금 i번 노드에 visit에 표시된 노드들을 거쳐 도착했을 때 나머지 도시를 거쳐 0번 노드로 돌아가는 최소 비용
//     -> dp[i][visit] = MIN(다음 노드들로 이동했을때의 dp)
// ==========================================================
//     -> 0->1->3->4->5->2->0
//     -> 0->3->1->4->5->2->0
//     -> 두 경우에서 4번 노드로 도착하면 TSP(4, 001011)이 중복 호출됨
//     -> dp[4][001011]이 4->5->2->0의 비용값을 저장하고, 반환하도록
public class exam2098 {
    static int N;
    static final int INF = 100000100;
//    static final int INF = 16000001;
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][(1<<N)-1];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[n],INF);
            for(int m=0; m<N; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(TSP(0,1));
    }


    public static int TSP(int cur, int visit) {

        //모든 노드를 다 방문했다면 -> N=4일 경우 1111(=15=(1<<4)-1)이면 끝
        if (visit == (1<<N)-1) {
            //순회가 불가능하다면 (시작점=0)
            if (map[cur][0] == 0) {
                return 100000000;
//                return 987654321;
            } else {
                return map[cur][0];
            }
        }

        //이미 dp가 존재하는 경우
        if(dp[cur][visit]!=INF) {
            return dp[cur][visit];
        }

        //이동 가능한 노드 경우의 수에 대해 dfs를 수행해줘야한다.
        for(int i=0; i<N; i++){
            //내가 이미 방문했거나, 못가는 경우엔 패스
            if( (visit&(1<<i)) > 0 || map[cur][i]==0) continue;
            dp[cur][visit] = Math.min(dp[cur][visit], TSP(i, visit|(1<<i))+map[cur][i]);
        }
        //최종적으로 계산된 dp 반환해주기
        return dp[cur][visit];

    }
}

//김소정: 최대 거리는 1600만이니까 INF 16000001로 초기화하고 불가능할땐 1억 리턴때렸는데 왜 시간초과일까요.....?
