import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] c1 = br.readLine().toCharArray();
        char[] c2 = br.readLine().toCharArray();
        //여기까지 입력

        int[][] dp = new int[c1.length + 1][c2.length + 1];
        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                if (c1[i - 1] == c2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1; // i번째와 j번째가 같은 문자를 갖고있으면 대각선 방향보다 +1 시켜줌
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 다른문자면 위아래에서 큰값을 넣어줌.
            }
        }
        //여기까지 LCS 길이를 구했음. 이제 역추적을 해야함.

        int r = c1.length, c = c2.length; //맨 밑부터 시작함.
        while (dp[r][c] != 0) {
            if (dp[r][c] == dp[r - 1][c]) r--; // 위의 행이랑 값이 같으면 그곳으로 이동
            else if (dp[r][c] == dp[r][c - 1]) c--; // 위의 행이랑 값이 다른데 왼쪽 열이랑 값이 같으면 그곳으로 이동
            else { // 둘다 다를경우 그곳이 17번째줄에서 +1 시켜준곳이기 때문에 해당 문자열을 넣고 대각선 방향으로 이동함.
                sb.append(c1[r - 1]);
                r--;
                c--;
            }
        }
        System.out.println(dp[c1.length][c2.length]);
        System.out.println(sb.reverse()); // 맨 뒤부터 넣어줬기 때문에 거꾸로 출력
    }
}