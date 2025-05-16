package ch18_최단경로알고리즘;

import java.io.*;
import java.util.*;

public class boj11265_끝나지않는파티_다익스트라_3136ms {
    static int N;
    static int[][] adj_matrix;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 파티장의 크기 5~500
        int M = Integer.parseInt(st.nextToken()); // 서비스를 요청한 손님의 수 1~10,000

        adj_matrix = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){    
                adj_matrix[i][j] = Integer.parseInt(st.nextToken()); // 1~1,000,000
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 서비스를 요청한 손님이 위치한 파티장 번호 
            int B = Integer.parseInt(st.nextToken()); // 다음 파티가 열리는 파티장의 번호
            int C = Integer.parseInt(st.nextToken()); // 지금으로부터 다음 파티가 열리는데 걸리는 시간 1~1,000,000,000

            int min_distance = dijkstra(A, B);
            if(C >= min_distance) sb.append("Enjoy other party\n");
            else sb.append("Stay here\n");
       }

    //    br.close();
       System.out.println(sb.toString());
    }

    static int dijkstra(int from, int to){
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[from] = 0;

        PriorityQueue<Party> pq = new PriorityQueue<>();
        pq.add(new Party(from, 0));
        boolean[] visited = new boolean[N+1];

        int result = 0;
        while(!pq.isEmpty()){
            Party cur = pq.poll();
            visited[cur.n] = true;

            if(cur.n == to) {
                result = cur.time;
                break;
            }

            for(int i=1; i<=N; i++){
                if(!visited[i] && dist[i] > cur.time+adj_matrix[cur.n][i]){
                    dist[i] = cur.time+adj_matrix[cur.n][i];
                    pq.add(new Party(i, dist[i]));
                }
            }
        }

        return result;
   }

   static class Party implements Comparable<Party>{
        int n;
        int time;

        Party(int n, int time){
            this.n = n;
            this.time = time;
        }

        @Override
        public int compareTo(Party p){
            return this.time - p.time;
        }
   }
}