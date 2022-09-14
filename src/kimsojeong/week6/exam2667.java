package src.kimsojeong.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class exam2667 {
    static int N, ans, cnt;
    static int[] di={0,1,0,-1}, dj={1,0,-1,0};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        char[] input;
        for(int i=0; i<N; i++) {
            input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = input[j] - '0';
            }
        }

        ArrayList<Integer> counts = new ArrayList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==1 && !visited[i][j]){
                    ans++;
                    cnt = 1;
                    visited[i][j] = true;
                    dfs(i,j);
                    counts.add(ans-1,cnt);
                }
            }
        }

        Collections.sort(counts);

        StringBuilder sb = new StringBuilder(ans+"\n");
        for(int c:counts){
            sb.append(c+"\n");
        }

        System.out.print(sb);


    }

    public static void dfs(int sI, int sJ){
        for(int d=0; d<4; d++){
            int newI = sI+di[d];
            int newJ = sJ+dj[d];

            if(newI<0 || newI>=N || newJ<0 || newJ>=N || map[newI][newJ]==0 || visited[newI][newJ]){
                continue;
            }

            cnt++;
            visited[newI][newJ] = true;
            dfs(newI,newJ);

        }
    }

}
