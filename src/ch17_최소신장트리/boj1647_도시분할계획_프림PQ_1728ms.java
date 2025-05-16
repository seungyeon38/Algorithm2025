package ch17_최소신장트리;

import java.io.*;
import java.util.*;

public class boj1647_도시분할계획_프림PQ_1728ms {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

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

        boolean[] visited = new boolean[N+1];
        int result = 0; // 최소 간선 비용의 합
        int max = 0; // 최대 간선 비용
        PriorityQueue<Edge> pq = new PriorityQueue();
        pq.add(new Edge(1, 0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            
            if(visited[cur.to]) continue;
            visited[cur.to] = true;
            result += cur.weight;
            max = Math.max(max, cur.weight);

            for(Edge next : adj_list[cur.to]){
                if(visited[next.to]) continue;
                pq.add(next);
            }
        }

        // br.close();
        System.out.println(result-max);
    }

    static class Edge implements Comparable<Edge>{
        int to;
        int weight;

        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }
}
