import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14890 {
    static int N, L, ans;
    static int[][] map;
    static boolean[] stair;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //여기까지 입력

        check();
        System.out.println(ans);

    }

    static boolean up(int start, boolean dir, int idx) { // true = row, false = col, idx = 지점
        if (start - L < 0) return true; // 올려야하는데 그 경사로가 범위를 초과함
        if (stair[start - 1]) return true; // 이미 그 자리에 경사로가 있다 이거 왜했지?
        if (dir) {
            for (int i = start - 1; i > start - L; i--) {
                if (map[idx][i] != map[idx][i - 1] || stair[i - 1])
                    // 계단이 이미 놓여져있는 자리이거나, 계단을 놓아야하는 범위의 높이가 다른경우
                    return true;
                stair[i - 1] = true;//계단이 놓여져있음을 알려주기위해서
            }
        } else {
            for (int i = start - 1; i > start - L; i--) {
                if (map[i][idx] != map[i - 1][idx] || stair[i - 1])
                    return true;
                stair[i - 1] = true;
            }
        }
        return false;
    }

    static boolean down(int start, boolean dir, int idx) {
        //up과 동일한 로직
        if (start + L - 1 >= N) return true;
        if (stair[start]) return true;
        stair[start] = true;
        if (dir) {
            for (int i = start; i < start + L - 1; i++) {
                if (map[idx][i] != map[idx][i + 1] || stair[i + 1])
                    return true;
                stair[i + 1] = true;
            }
        } else {
            for (int i = start; i < start + L - 1; i++) {
                if (map[i][idx] != map[i + 1][idx] || stair[i + 1])
                    return true;
                stair[i + 1] = true;
            }
        }
        return false;
    }

    static void check() {
        //가로줄 검사
        outer:
        for (int i = 0; i < N; i++) {
            stair = new boolean[N];
            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] == map[i][j + 1] + 1) { // j+1이 j보다 한칸 낮은경우
                    if (down(j + 1, true, i)) { //낮추는게 불가능하다면 (인텔리제이에서 시키는데로 했을뿐..)
                        continue outer; // 다음 행을 검사한다
                    }
                } else if (map[i][j] == map[i][j + 1] - 1) {// j+1이 j보다 한칸 높은경우
                    if (up(j + 1, true, i)) {//낮추는게 불가능하다면
                        continue outer;// 다음 행을 검사한다
                    }
                } else if (map[i][j] != map[i][j + 1]) { // 같지도 않고 차이가 1이상나면
                    continue outer; // 다음 행을 검사한다.
                }
            }
            ans++;//위의 for문을 통과했다면 가능한 경우의 수이므로 ++해준다.
        }
        //세로줄 검사도 동일하다
        outer:
        for (int i = 0; i < N; i++) {
            stair = new boolean[N];
            for (int j = 0; j < N - 1; j++) {
                if (map[j][i] == map[j + 1][i] + 1) {
                    if (down(j + 1, false, i)) {
                        continue outer;
                    }
                } else if (map[j][i] == map[j + 1][i] - 1) {
                    if (up(j + 1, false, i)) {
                        continue outer;
                    }
                } else if (map[j][i] != map[j + 1][i]) {
                    continue outer;
                }
            }
            ans++;
        }
    }
}