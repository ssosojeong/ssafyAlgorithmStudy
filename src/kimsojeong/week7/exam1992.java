package src.kimsojeong.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1992 {
    static char[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        divide(0,0,N);
        System.out.println(sb);
    }

    /**
     * 구역의 시작점과 그 크기를 받아 하나의 색깔로 칠해지는지 체크한다.
     * 가능할 경우 해당 구역의 색깔을 출력문에 저장하고, 불가능할 경우 새로운 괄호문을 열어 제시된 순서대로 분할한다.
     *
     * @param sI 탐색을 시작할 i값
     * @param sJ 탐색을 시작할 j값
     * @param size 탐색 범위. 절반으로 줄이며 탐색할것이기 때문에 인자로 넘겨줘야 함
     */
    public static void divide(int sI, int sJ, int size){
        //지금 들어온 애가 하나의 색갈로 통일된다면 -> sb에 그 색깔을 붙인다.
        if(check(sI,sJ, size)){
            sb.append(map[sI][sJ]);
        } else{
            //하나의 구역을 분할해서 따질꺼니까 괄호를 열어주고, 마지막에 닫아준다.
            sb.append("(");
            divide(sI, sJ, size/2);
            divide(sI, sJ+size/2, size/2);
            divide(sI+size/2, sJ, size/2);
            divide(sI+size/2, sJ+size/2, size/2);
            sb.append(")");
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
//오현규: 형균님과 소정님 풀이가 유사하네요. 보고 더 공부해보겠습니다!
