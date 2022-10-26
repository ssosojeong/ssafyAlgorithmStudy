import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int beforeX = Integer.parseInt(st.nextToken());
        int beforeY = Integer.parseInt(st.nextToken());
        int ans = beforeY - beforeX;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x < beforeY && y >= beforeY) {
                ans += y - beforeY;
            } else if (x >= beforeY) {
                ans += y - x;
            }
            if (y > beforeY) {
                beforeY = y;
            }
        }
        System.out.println(ans);
    }
}