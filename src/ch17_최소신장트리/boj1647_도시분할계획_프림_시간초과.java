package ch17_최소신장트리;

import java.io.*;
import java.util.*;

public class boj1647_도시분할계획_프림_시간초과 {
    public static void main(String[] args) throws Exception{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 집의 개수 2~100,000
        int M = Integer.parseInt(st.nextToken()); // 길의 개수 1~1,000,000

        List<Edge>[] adj_list = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            adj_list[i] = new ArrayList<Edge>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            adj_list[A].add(new Edge(B, C));
            adj_list[B].add(new Edge(A, C));
        }

        int[] min_edge = new int[N+1];
        for(int i=1; i<=N; i++){
            min_edge[i] = Integer.MAX_VALUE;
        }
        min_edge[1] = 0; 
        boolean[] visited = new boolean[N+1];
        int cnt = 0; // 지나간 간선 수
        int result = 0; // 최소 간선 비용의 합
        int max = 0; // 최대 간선 비용

        while(true){
            // 비용이 가장 작은 간선 찾기
            int cur_edge_idx = 0;
            int cur_edge_v = Integer.MAX_VALUE;
            for(int i=1; i<=N; i++){
                if(visited[i]) continue;
                if(cur_edge_v > min_edge[i]){
                    cur_edge_v = min_edge[i];
                    cur_edge_idx = i;
                }
            }

            visited[cur_edge_idx] = true;
            cnt++;
            result += min_edge[cur_edge_idx];
            max = Math.max(max, min_edge[cur_edge_idx]);

            for(Edge next : adj_list[cur_edge_idx]){
                if(visited[next.to]) continue;
                min_edge[next.to] = Math.min(min_edge[next.to], next.weight);
            }

            if(cnt == N) break;
        }

        br.close();
        System.out.println(result-max);
    }

    static class Edge{
        int to;
        int weight;

        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
}
