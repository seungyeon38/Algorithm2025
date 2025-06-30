package 구현;

import java.io.*;
import java.util.*;

public class boj11438_LCA2_768ms {
    static int[][] parent;
    static int[] level;
    static int MAX_LEVEL;

    public static void main(String[] args) throws Exception{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine()); // 정점 개수 2~100,000
        ArrayList<Integer>[] adj_list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            adj_list[i] = new ArrayList<>();
        }

        for(int i=1; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            adj_list[p1].add(p2);
            adj_list[p2].add(p1);
        }

        MAX_LEVEL = 0;
        while((1<<MAX_LEVEL) <= N){
            MAX_LEVEL++;
        }

        parent = new int[N+1][MAX_LEVEL+1];
        level = new int[N+1];

        Stack<Integer> stack = new Stack();
        stack.push(1);
        level[1] = 0;
        boolean[] visited = new boolean[N+1];

        while(!stack.isEmpty()){ // dfs
            int cur = stack.pop();
            visited[cur] = true;

            for(int next : adj_list[cur]){
                if(visited[next]) continue;

                parent[next][0] = cur;
                level[next] = level[cur]+1;
                stack.push(next);
            }
        }

        for(int i=1; i<=MAX_LEVEL; i++){
            for(int v=1; v<=N; v++){
                parent[v][i] = parent[parent[v][i-1]][i-1];
            }
        }

        int M = Integer.parseInt(br.readLine()); // lca 쌍의 개수 1~100,000
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            sb.append(lca(p1, p2)).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int lca(int p1, int p2){
        // level[p1] >= level[p2] 가 되도록
        if(level[p1] < level[p2]){
            int temp = p1;
            p1 = p2;
            p2 = temp;
        }
    
        for(int i=MAX_LEVEL; i>=0; i--){
            if((level[p1]-level[p2]) >= (1<<i)){
                p1 = parent[p1][i];
            }
        }

        if(p1 == p2) return p1;

        for(int i=MAX_LEVEL; i>=0; i--){
            if(parent[p1][i] != parent[p2][i]){
                p1 = parent[p1][i];
                p2 = parent[p2][i];
            }
        }

        return parent[p1][0];
    }
}
