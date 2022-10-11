import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q23288 {
    static int N, M, K, ans;
    static int[][] arr;
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0}; // 동 남 서 북

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //여기까지 입력
        Dice dice = new Dice(); // 주사위 하나 객체생성해주고
        for (int i = 0; i < K; i++) {
            dice.move(); //K번 움직인다.
        }
        System.out.println(ans); // 정답 출력
    }

    private static class Dice {
        int top, up, right, left, down, bottom;
        int dir;
        int r, c;

        public Dice() { // 초기값은 문제에 주어짐.
            top = 1;
            up = 2;
            right = 3;
            left = 4;
            down = 5;
            bottom = 6;
            dir = 0;
            r = 0;
            c = 0;
        }

        public void move() {
            r += dr[dir];
            if (r < 0 || r >= N) {
                r -= 2 * dr[dir];
                dir = (dir + 2) % 4;
            } // 우선 다음 r값을 구해줌. 만약 범위가 벗어났으면 그 반대방향으로 이동해줘야하므로 2를 곱한 값을 -해주고 dir를 2증가시킴.
            c += dc[dir];
            if (c < 0 || c >= M) {
                c -= 2 * dc[dir];
                dir = (dir + 2) % 4;
            } // c도 동일
            int tmp = bottom; // 공통적으로 bottom의 값은 항상 바뀌기때문에 tmp에 저장해둠
            switch (dir) { // dir에 따라 바뀌는 값들을 switch로 설정
                case 0:
                    bottom = right;
                    right = top;
                    top = left;
                    left = tmp;
                    break;
                case 1:
                    bottom = down;
                    down = top;
                    top = up;
                    up = tmp;
                    break;
                case 2:
                    bottom = left;
                    left = top;
                    top = right;
                    right = tmp;
                    break;
                case 3:
                    bottom = up;
                    up = top;
                    top = down;
                    down = tmp;
                    break;
            }
            //이동하고 난 뒤 그곳의 숫자로 점수를 내고, 방향을 바꾸므로
            if (bottom > arr[r][c]) { // 방향을 바꿔준다
                dir = (dir + 1) % 4; // %4를 하면 쉽게 해결가능
            } else if (bottom < arr[r][c]) {
                dir = (dir + 3) % 4; // 반시계는 +3을 하고 %4를 하면 된다.
            }
            getAnswer(); // 그리고 도착지점에서 점수를 구한다.
        }

        public void getAnswer() { // bfs를 사용한다. 밑은 전형적인 bfs이다.
            boolean[][] visited = new boolean[N][M];
            Queue<Node> que = new LinkedList<>();
            visited[r][c] = true;
            que.offer(new Node(r, c));
            int cnt = 0;
            while (!que.isEmpty()) {
                Node curNode = que.poll();
                cnt++;
                for (int i = 0; i < 4; i++) {
                    int nr = curNode.r + dr[i];
                    int nc = curNode.c + dc[i];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                        if (!visited[nr][nc] && arr[nr][nc] == arr[r][c]) { // 초기자리와 값이 같은것만
                            visited[nr][nc] = true;
                            que.offer(new Node(nr, nc));
                        }
                    }
                }
            }
            ans += arr[r][c] * cnt; // 정답에 더해준다.
        }

    }

    private static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}