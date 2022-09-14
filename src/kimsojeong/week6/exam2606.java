package src.kimsojeong.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class exam2606 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph.get(v1-1).add(v2-1);
            graph.get(v2-1).add(v1-1);
        }

        visited[0] = true;
        dfs(0);

        System.out.println(ans);


    }

    public static void dfs(int cur){
        for(int node:graph.get(cur)){
            if(!visited[node]){
                ans++;
                visited[node] = true;
                dfs(node);
            }
        }
    }
}