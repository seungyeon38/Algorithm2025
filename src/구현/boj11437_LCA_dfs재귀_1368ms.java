package 구현;

import java.io.*;
import java.util.*;

public class boj11437_LCA_dfs재귀_1368ms {
    static ArrayList<Integer>[] adj_list;
    static int[] level;
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine()); // 정점 개수 2~50,000
        adj_list = new ArrayList[N+1]; // 인접 리스트 
        for(int i=0; i<=N; i++){
            adj_list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            adj_list[p1].add(p2);
            adj_list[p2].add(p1);
        }

        level = new int[N+1];
        parent = new int[N+1];
        visited = new boolean[N+1];
        visited[1] = true;

        dfs(1, 0);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            sb.append(LCA(p1, p2)).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void dfs(int cur, int lev){
        visited[cur] = true;
        level[cur] = lev;

        for(int next : adj_list[cur]){
            if(visited[next]) continue;
            parent[next] = cur;
            dfs(next, lev+1);
        }
    }

    public static int LCA(int n1, int n2){
        // level 맞추기
        if(level[n1] > level[n2]){
            while(level[n1]!=level[n2]) n1 = parent[n1];
        } else if(level[n1] < level[n2]){
            while(level[n1]!=level[n2]) n2 = parent[n2];
        }

        // 공통 부모 찾기
        while(n1 != n2){
            n1 = parent[n1];
            n2 = parent[n2];
        }

        return n1;
    }
}
