import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2098 {
    static int N;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][1 << N]; // dp[방문도시][방문한도시(비트마스크)] 로 할거기 때문

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //여기까지 입력

        System.out.println(tsp(0, 1));
        // 0번도시 시작. 0번을 다시 방문할것이므로 0번도시를 방문체크함으로써(1) 0번을 방문하지 않도록 하기 위해서

    }

    private static int tsp(int idx, int visited) {
        if (visited == (1 << N) - 1) {
            if (arr[idx][0] == 0) return 100000000;
            //만약 0번도시로 갈수없다면 1억을 리턴해서 답이없다는걸 표현한다
            // (arr값은 백만까지고, 최대 거리는 1600만이다. 그렇기떄문에 1억이란 큰값을 리턴해버리면 해당 루트는 답이없다는걸 표시할수있다.)
            return arr[idx][0];
        }
        if (dp[idx][visited] != 0)
            return dp[idx][visited]; // dp값이 갱신된적이 있다면 그 값을 리턴한다.
        int min = 100000000; //최솟값을 찾기위해서(dp를 INF로 초기화했다면 이 과정이 필요없다)
        for (int i = 0; i < N; i++) {
            if ((visited & (1 << i)) == 0 && arr[idx][i] != 0) {
                //i번째 도시를 방문한 적이 없고, 길이 있다면
                min = Math.min(min, arr[idx][i] + tsp(i, visited | (1 << i)));
                //min값을 arr(i번째 도시까지 가는 비용)+tsp(i번째 도시에 있고, visited만큼 방문한 상태에서 나머지 도시들을
                //전부 방문한 후 0번도시로 다시 복귀하는데 까지 드는 비용)으로 갱신해준다.
            }
        }
        return dp[idx][visited] = min;
    }
}