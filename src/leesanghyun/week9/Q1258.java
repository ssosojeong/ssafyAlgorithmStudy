import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1258 {
    static int[][] arr;
    static boolean[][] visited;
    static List<Matrix> list;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visited = new boolean[N][N]; // 방문배열
            list = new ArrayList<>(); // 답을 넣어줄 리스트
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //여기까지 입력

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && arr[i][j] != 0) { // 방문하지 않고 0이 아닌곳이 나오면
                        findMatrix(i, j); // 크기를 찾기 시작
                    }
                }
            }
            list.sort((o1, o2) -> { // 출력형식에 맞게 정렬
                if (o1.r * o1.c == o2.r * o2.c) {
                    return o1.r - o2.r;
                }
                return o1.r * o1.c - o2.r * o2.c;
            });
            //출력하기
            sb.append("#").append(t).append(" ").append(list.size()).append(" ");
            for (Matrix mtx : list) {
                int r = mtx.r;
                int c = mtx.c;
                sb.append(r).append(" ").append(c).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void findMatrix(int r, int c) {
        int nr = r;
        int nc = c;
        while (nr + 1 < N && arr[nr + 1][nc] != 0) { // arr을 벗어나지 않으면서, 0이 아니면 계속 nr을 증가시킴.
            nr++;
        }
        while (nc + 1 < N && arr[nr][nc + 1] != 0) {// arr을 벗어나지 않으면서, 0이 아니면 계속 nc을 증가시킴.
            nc++;
        }
        for (int i = r; i <= nr; i++) { // 찾은 nr,nc값을 방문처리 하고
            for (int j = c; j <= nc; j++) {
                visited[i][j] = true;
            }
        }
        list.add(new Matrix(nr - r + 1, nc - c + 1)); // 답을 리스트에 집어넣음.
    }

    private static class Matrix {
        int r;
        int c;

        public Matrix(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

//김형균 : 이미 알고 사용하신거라 생각이 들지만 정렬이 주 목적이기 때문에 List말고 PriorityQueue를 사용하면 좀 더 시간이 단축될꺼 같습니다.
