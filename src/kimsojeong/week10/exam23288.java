package src.kimsojeong.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam23288 {
    static class Dice{
        //초기 상태
        int front=5, back=2, bottom=6, upper=1, right=3, left=4;

        public void rolling(int d){
            if(d==0){               //동
                int tmp = bottom;
                bottom = right;
                right = upper;
                upper = left;
                left = tmp;
            } else if(d==1){        //서
                int tmp = bottom;
                bottom = left;
                left = upper;
                upper = right;
                right = tmp;
            } else if(d==2){        //남
                int tmp = bottom;
                bottom = front;
                front = upper;
                upper = back;
                back = tmp;
            } else{                 //북
                int tmp = bottom;
                bottom = back;
                back = upper;
                upper = front;
                front = tmp;
            }
        }

    }

    static int[][] newDir = {{2,3,1,0},{3,2,0,1}};
    static int[][] map, visit;
    static int[] di = {0, 0, 1, -1}, dj={1,-1,0,0}; //동서남북
    static int N, M, K, ans, score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        for(int n=1; n<=N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=1; m<=M; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        Dice dice = new Dice();

        moving(1,1,0, dice, 0);
        System.out.println(ans);



    }

    //i,j: 현재 위치
    //k: 현재 몇번 이동했는가
    //dice: 현재 주사위
    //d: 현재 방향
    public static void moving(int i, int j, int k, Dice dice, int d){
        if(k==K) return;
        else{
            //1. 주사위를 이동시킨다. 이동방향에 칸이 없다면, 이동방향을 반대로 바꿔 굴러간다.
            int newI = i+di[d]; int newJ = j+dj[d];
            if(newI<1 || newI>N || newJ<1 || newJ>M){
                if(d%2==0) d++;
                else d--;

                newI = i+di[d];
                newJ = j+dj[d];
            }
            dice.rolling(d);

            //2. 점수를 획득한다.
            score = map[newI][newJ];
            visit = new int[N+1][M+1];
            visit[newI][newJ] = 1;
            counting(newI,newJ,map[newI][newJ]);
            ans += score;

            //3. 이동방향을 결정한다.
            if(dice.bottom>map[newI][newJ]){
                d = newDir[0][d];
            } else if(dice.bottom<map[newI][newJ]){
                d = newDir[1][d];
            }

            moving(newI, newJ, k+1, dice, d);
        }
    }

    public static void counting(int i, int j, int num){
        for(int d=0; d<4; d++){
            int newI = i+di[d];
            int newJ = j+dj[d];

            if(newI<1 || newI>N || newJ<1 || newJ>M || map[newI][newJ]!=num || visit[newI][newJ]==1){
                continue;
            }

            visit[newI][newJ] = 1;
            score += num;
            counting(newI, newJ, num);
        }
    }
}
