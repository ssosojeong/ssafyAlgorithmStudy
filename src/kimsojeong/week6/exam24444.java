package src.kimsojeong.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam24444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] visited = new int[N];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a-1).add(b-1);
            graph.get(b-1).add(a-1);
        }
        for(int i=0; i<N; i++){
            Collections.sort(graph.get(i));
        }

        int cnt = 1;
        visited[R-1] = cnt++;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(R-1);
        while(!queue.isEmpty()){
            int tar = queue.poll();

            for(int node:graph.get(tar)){
                if(visited[node]==0) {
                    visited[node] = cnt++;
                    queue.offer(node);
                }
            }
        }

        for(int i:visited){
            sb.append(i+"\n");
        }

        System.out.print(sb);


    }
}
// 김형균 : 읽기 너무 편하네요 ~ 가독성 짱짱! 36~49번째 줄은 do while문으로 하면 첫번째 상황을 먼저 넣어주는 코드를 안 적어도 되지 않을까 싶어요~
