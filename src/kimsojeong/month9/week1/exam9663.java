package src.kimsojeong.month9.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam9663 {
    static int N, ans;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N];

        nQueen(0);

        System.out.println(ans);

    }

    public static void nQueen(int row){
        //마지막 행까지 queen을 다 놓았다면 경우의 수를 증가시킨다.
        if(row==N){
            ans++;
            return;
        } else{
            for(int col=0; col<N; col++){
                //그 자리에 퀸을 놓는게 불가능하다면 그냥 덮어쓰도록
                map[row] = col;

                //해당 행(인자)의 해당 열(for문의 변수)에 퀸을 놓는 것이 가능하다면
                if(isQueen(row, col)){
                    //다음 행에 대한 탐색을 진행한다.
                    nQueen(row+1);
                }
            }
        }
    }

    public static boolean isQueen(int row, int col){
        //해당 행의 해당 열에 퀸을 놓을 수 없는 경우
        //1. 이미 다른 행에서 그 자리에 퀸을 놓았다.
        //      -> map[] 값이 col과 하나라도 동일하다면
        //2. 다른 행에 놓인 퀸의 대각선 공격 범위에 지금 놓으려는 자리가 포함된다.
        //      -> 대각선에 포함되는 자리들: 특정 자리로부터 i,j가 동일한 만큼 떨어져있는 자리들

        //0행부터 내가 놓으려는 행 전에 놓여진 퀸의 위치를 보고 판단
        for(int i=0; i<row; i++){
            if(map[i]==col || Math.abs(row-i)==Math.abs(col-map[i])){
                return false;
            }
        }
        return true;

    }
}
