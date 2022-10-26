import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        outer:
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] R = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                R[i] = Integer.parseInt(st.nextToken());
            }
            boolean[] visited = new boolean[N + 1];
            int[] res = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                int idx = -1;
                for (int j = N; j >= 1; j--) {
                    int cnt = 0;
                    for (int k = 1; k <= j; k++) {
                        if (visited[k]) cnt++;
                    }
                    if (cnt == R[j]) {
                        idx = j;
                        break;
                    }
                }
                if (idx == -1) {
                    sb.append("IMPOSSIBLE\n");
                    continue outer;
                }
                res[idx] = i;
                visited[idx] = true;
            }
            for (int i = 1; i <= N; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}