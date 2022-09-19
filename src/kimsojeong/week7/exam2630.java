package src.kimsojeong.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2630 {
    static int[] ans = new int[2];
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0,0,N);

        for(int i:ans){
            System.out.println(i);
        }

    }

    /**
     * 구역의 시작점과 그 크기를 받아 하나의 색깔로 칠해지는지 체크하고, 칠해지지 않는다면 구역을 나눠 재귀호출한다.
     *
     * @param sI 탐색을 시작할 i값
     * @param sJ 탐색을 시작할 j값
     * @param size 탐색 범위. 절반으로 줄이며 탐색할것이기 때문에 인자로 넘겨줘야 함
     */
    public static void divide(int sI, int sJ, int size){
        //지금 들어온 애가 하나의 색갈로 통일된다면
        if(check(sI,sJ, size)){
            ans[map[sI][sJ]]++;     //그 색깔에 하나 더해준다
        } else{
            //시작점이 0,0 전체가 N일 때
            //왼쪽위구역: 그대로 0,0
            //왼쪽아래구역: 0+N/2, 0
            //오른쪽위구역: 0,0+N/2
            //오른쪽아래구역: 0+N/2, 0+N/2
            divide(sI, sJ, size/2);
            divide(sI+size/2, sJ, size/2);
            divide(sI, sJ+size/2, size/2);
            divide(sI+size/2, sJ+size/2, size/2);
        }
    }

    /**
     * 구역의 시작점과 그 크기를 받아 해당 구역이 하나의 색깔로 칠해지는지 검사한다.
     *
     * @param sI 탐색을 시작할 i값
     * @param sJ 탐색을 시작할 j값
     * @param size 탐색 범위. 절반으로 줄이며 탐색할것이기 때문에 인자로 넘겨줘야 함
     */
    public static boolean check(int sI, int sJ, int size){
        int color = map[sI][sJ];

        for(int i=sI; i<sI+size; i++){
            for(int j=sJ; j<sJ+size; j++){
                if(map[i][j]!=color) return false;
            }
        }

        return true;
    }
}
