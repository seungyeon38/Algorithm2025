package 구현;

import java.io.*;
import java.util.*;

public class swea1267_작업순서_위상정렬 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();

        for(int t=1; t<=10; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); // 정점의 개수 3~1000
            int E = Integer.parseInt(st.nextToken()); // 간선의 개수 2~3000

            List<Integer>[] adj_list = new ArrayList[V+1];
            for(int i=0; i<V+1; i++){
                adj_list[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            int[] indegree = new int[V+1]; // 진입차수

            for(int i=0; i<E; i++){
                int sp = Integer.parseInt(st.nextToken());
                int ep = Integer.parseInt(st.nextToken());

                adj_list[sp].add(ep);
                indegree[ep]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int i=1; i<=V; i++){
                if(indegree[i] == 0) queue.offer(i);
            }

            sb.append("#").append(t).append(" ");

            while(!queue.isEmpty()){
                int cur = queue.poll();
                sb.append(cur).append(" ");
                for(int next : adj_list[cur]){
                    indegree[next]--;
                    if(indegree[next] == 0){
                        queue.offer(next);
                    }
                }
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
