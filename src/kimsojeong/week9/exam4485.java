package src.kimsojeong.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam4485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] di = {0,1,0,-1}, dj={1,0,-1,0};
        int t=0;

        while(true){
            t++;
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;

            int[][] map = new int[N][N];
            int[][] costs = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //다익스트라로 풀기~
            PriorityQueue<int[]> pQueue = new PriorityQueue<>((o1,o2) -> o1[2]-o2[2]);
            pQueue.offer(new int[] {0,0,map[0][0]});
            for(int[] arr : costs){
                Arrays.fill(arr,Integer.MAX_VALUE);
            }

            while(!pQueue.isEmpty()){
                int[] cur = pQueue.poll();

                //pQueue에서 poll됐다는 건 결국 해당 노드의 최소비용이 픽스됐다는 것을 의미!
                //더이상 탐색할 필요가 없다
                if(cur[0]==N-1 && cur[1]==N-1){
                    break;
                }

                //일단 사방탐색으로 다음 탐색 노드 만들고
                for(int d=0; d<4; d++){
                    int newI = cur[0]+di[d];
                    int newJ = cur[1]+dj[d];

                    if(newI<0 || newI>=N || newJ<0 || newJ>=N) continue;

                    //지금 구해놓은 가중치랑 비교해주고 더 작으면 pQueue에 넣기
                    if(costs[newI][newJ]>cur[2]+map[newI][newJ]){
                        costs[newI][newJ] = cur[2]+map[newI][newJ];
                        pQueue.offer(new int[] {newI, newJ, costs[newI][newJ]});
                    }
                }

            }

            sb.append("Problem "+ t+ ": "+costs[N-1][N-1]+"\n");

        }

        System.out.println(sb);

    }
}
