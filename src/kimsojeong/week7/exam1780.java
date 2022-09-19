package src.kimsojeong.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1780 {
    static int[][] map;
    static int[] ans = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++) {
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
     * 구역의 시작점과 그 크기를 받아 하나의 숫자로 채워지는지 체크한다.
     * 가능할 경우 해당 구역의 숫자에 해당하는 ans 배열 값을 증가시키고, 불가능할 경우 분할하여 재귀호출한다.
     *
     * @param sI 탐색을 시작할 i값
     * @param sJ 탐색을 시작할 j값
     * @param size 탐색 범위. 절반으로 줄이며 탐색할것이기 때문에 인자로 넘겨줘야 함
     */
    public static void divide(int sI, int sJ, int size){
        //지금 들어온 애가 하나의 색갈로 통일된다면 -> ans[해당숫자+1]의 값을 1 증가
        if(check(sI,sJ, size)){
            ans[map[sI][sJ]+1]++;
        } else{
            //불가능할 경우 -> 9개로 분할한다.
            int newS = size/3;
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    divide(sI+i*newS, sJ+j*newS, newS);
                }
            }
        }
    }

    /**
     * 구역의 시작점과 그 크기를 받아 해당 구역이 하나의 숫자로 채워지는지 검사한다.
     *
     * @param sI 탐색을 시작할 i값
     * @param sJ 탐색을 시작할 j값
     * @param size 탐색 범위. 1/3로 줄이며 탐색할것이기 때문에 인자로 넘겨줘야 함
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


