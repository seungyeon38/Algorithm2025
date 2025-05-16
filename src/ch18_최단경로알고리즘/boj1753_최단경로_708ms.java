package ch18_최단경로알고리즘;

import java.io.*;
import java.util.*;

public class boj1753_최단경로_708ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점의 개수 1~20,000
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수 1~300,000

        int K = Integer.parseInt(br.readLine()); // 시작 정점의 번호 

        // int[][] adj_matrix = new int[V+1][V+1];
        List<Edge>[] adj_list = new ArrayList[V+1];
        for(int i=0; i<=V; i++){
            adj_list[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken()); 
            int w = Integer.parseInt(st.nextToken()); // 가중치 1~10 자연수

            // 서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수 있다.
            adj_list[u].add(new Edge(v, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(K, 0));

        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        boolean[] visited = new boolean[V+1];

        while(!pq.isEmpty()){
            Edge cur_edge = pq.poll();
            visited[cur_edge.n] = true;

            for(Edge next : adj_list[cur_edge.n]){
                if(visited[next.n]) continue;

                if(next.weight!=Integer.MAX_VALUE && dist[next.n] > cur_edge.weight+next.weight){
                    dist[next.n] = cur_edge.weight+next.weight;
                    pq.add(new Edge(next.n, dist[next.n]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=V; i++){
            sb.append(dist[i]!=Integer.MAX_VALUE ? dist[i] : "INF").append("\n");
        }

        // br.close();
        System.out.println(sb.toString());
    }

    static class Edge implements Comparable<Edge>{
        int n;
        int weight;

        Edge(int n, int weight){
            this.n = n;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }
}
