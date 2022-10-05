import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15486 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 2];
        int[] t = new int[N + 1];
        int[] p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        } // 맨 밑부터 시작할 것이기 때문에 배열에 받아둠

        for (int i = N; i > 0; i--) {
            if (i + t[i] > N + 1) { // 현재 날짜+걸리는 시간이 N+1이면 어차피 못하기때문에.
                dp[i] = dp[i + 1];
            } else { //dp[i+1]은 그 일을 안할때의 값, p[i]+dp[i+t[i]]는 그 일을 할때의 값
                dp[i] = Math.max(dp[i + 1], p[i] + dp[i + t[i]]);
            }
        }

        System.out.println(dp[1]);

    }
}
