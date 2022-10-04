package src.kimsojeong.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] plans = new int[2][N];  //plans[0][0]: 1일차의 상담 걸리는 시간 / plans[1][0]: 1일차 상담 급여
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            plans[0][n] = Integer.parseInt(st.nextToken());
            plans[1][n] = Integer.parseInt(st.nextToken());
        }

        //N+1일에 수령하는 금액까지 생각해줘야함
        int[] dp = new int[N+1];
        //dp[n]: n+1번째날에 내가 얻은 수입
        //dp[0]: 첫째날에 내가 얻은 수입 -> 무조건 0 (Ti 최소값 1)
        //dp[1]: 둘째날에 내가 얻은 수입 -> 만약 첫째날에 1일 걸리는 일을 수행했다면 그 값
        //...
        //dp[0]은 dp[0+그 날의 상담이 걸리는 일자]의 값을 갱신해줘야 한다.
        // 3	5	1	1	2	1	2
        // 10	20	10	20	15	40	200
        //dp[0] = 0 -> dp[3] = 10
        //dp[1] = 0 -> dp[6] = 20
        //dp[2] = 0 -> dp[3] = 10 (max(dp[3],dp[2]+10)=10)
        //dp[3] = 10 -> dp[4] = 30
        //dp[4] = 30 -> dp[6] = 45
        //(x) dp[5] = 0 -> dp[6] = 45( max(dp[6],dp[5]+40)
        //  -> 여기서 문제 발생
        //  -> 앞에서 딱 6일에 끝나는 상담이 없었기때문에 dp[5]의 값이 0으로 남았기때문에
        //  -> dp[5]+40=40으로 dp[6]이 갱신되지 않았지만,
        //  -> 원래는 5일에 일을 하지 않고, 4일까지(5일에 끝난) 일했던 비용을 가진채로 6일에 1일짜리 상담을 진행해야한다
        //  -> max로 갱신할 때 dp[5]+40이 아닌 dp[4]+40을 해줘야한다.
        //  -> 즉, 갱신할 땐 지금 일자까지 수령이 가능한 최대 급여를 가지고 갱신해줘야 함
        //dp[5] = 0 -> dp[6] = 70 (max(dp[6], MAX+40)
        //dp[6] = 70 -> dp[8] -> 9일에 수령하는건 고려할 필요 없음
        //최종 답안 -> MAX값(70)

        int max = -1;
        for(int n=0; n<N; n++){
            if(dp[n]>max) max = dp[n];

            if(n+plans[0][n]<N+1){
                dp[n+plans[0][n]] = Math.max(dp[n+plans[0][n]], max+plans[1][n]);
            }
        }

        //마지막에 dp[N]은 max에 반영되지 않았으므로
        System.out.println(Math.max(max,dp[N]));

    }
}
