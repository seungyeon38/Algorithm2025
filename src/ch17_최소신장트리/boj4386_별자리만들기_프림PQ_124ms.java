package ch17_최소신장트리;

import java.io.*;
import java.util.*;

public class boj4386_별자리만들기_프림PQ_124ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int n = Integer.parseInt(br.readLine()); // 별의 개수 1~100

        double[][] node_list = new double[n][2];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            node_list[i] = new double[]{x, y};
        }

        List<Edge>[] adj_list = new ArrayList[n];
        
        for(int i=0; i<n; i++){
            adj_list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                double dist = calcDist(node_list[i], node_list[j]);
                adj_list[i].add(new Edge(j, dist));
                adj_list[j].add(new Edge(i, dist));
            }
        }

        boolean[] visited = new boolean[n];
        int cnt = 0; // 선택한 간선 수
        double result = 0; // 최소 비용 

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0.0));
        
        while(!pq.isEmpty()){
            Edge cur_edge = pq.poll();
            if(visited[cur_edge.to]) continue;

            visited[cur_edge.to] = true;
            result += cur_edge.weight;
            cnt++;

            if(cnt == n) break;

            for(Edge next : adj_list[cur_edge.to]){
                if(visited[next.to]) continue;
                
                pq.add(next);
            }
        }

        // br.close();
        System.out.printf("%.2f", result);
    }

    public static double calcDist(double[] p1, double[] p2){
        return Math.sqrt(Math.pow(p2[0]-p1[0], 2) + Math.pow(p2[1]-p1[1], 2));
    }

    static class Edge implements Comparable<Edge>{
        int to;
        double weight;

        Edge(int to, double weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e){
            return Double.compare(this.weight, e.weight);
        }
    }
}
