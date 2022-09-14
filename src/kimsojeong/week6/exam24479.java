package src.kimsojeong.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class exam24479 {
    static int N, M, cnt;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N];
        graph = new ArrayList<>();
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

        visited[R-1]=++cnt;
        dfs(R-1);
        for(int i:visited){
            sb.append(i+"\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int cur){
        for(int node:graph.get(cur)){
            if(visited[node]==0){
                visited[node] = ++cnt;
                dfs(node);
            }
        }
    }
}
