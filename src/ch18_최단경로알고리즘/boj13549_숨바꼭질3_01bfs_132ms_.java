package ch18_최단경로알고리즘;

import java.io.*;
import java.util.*;

public class boj13549_숨바꼭질3_01bfs_132ms_ {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수빈이가 있는 위치 0~100,000
        int K = Integer.parseInt(st.nextToken()); // 동생이 있는 위치 0~100,000

        Deque<Integer> queue = new LinkedList<>(); // index 0: 위치, 1: 걸린 시간
        queue.offerFirst(N);
        int result = 0; // 동생을 찾는 가장 빠른 시간
        // 거리 결과 배열
        int MAX = 100001;
        int[] dist = new int[MAX];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[N] = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            if(cur == K) {
                result = dist[cur]; 
                break;
            }
            
            int next = cur*2;
            if(next < MAX && dist[next]>dist[cur]){
                dist[next] = dist[cur];
                queue.offerFirst(next);
            }
            next = cur-1;
            if(next >= 0 && dist[next]>dist[cur]+1){
                dist[next] = dist[cur]+1;
                queue.offerLast(next);
            }
            next = cur+1;
            if(next < MAX && dist[next]>dist[cur]+1){
                dist[next] = dist[cur]+1;
                queue.offerLast(next);
            } 
        }     
        
        // br.close();
        System.out.println(result);
    }
}
