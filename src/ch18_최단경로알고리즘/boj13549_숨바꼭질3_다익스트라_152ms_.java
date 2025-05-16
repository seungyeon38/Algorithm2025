package ch18_최단경로알고리즘;

import java.io.*;
import java.util.*;

public class boj13549_숨바꼭질3_다익스트라_152ms_ {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수빈이가 있는 위치 0~100,000
        int M = Integer.parseInt(st.nextToken()); // 동생이 있는 위치 0~100,000

        int DIST_MAX = 100001;
        int[] dist = new int[DIST_MAX]; // index: 위치, 위치마다의 최단 시간
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[N] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(N, 0));

        int result = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.pos == M) {
                result = cur.time;
                break;
            }

            int next = cur.pos*2;
            if(next < DIST_MAX && dist[next] > cur.time) {
                dist[next] = cur.time;
                pq.offer(new Node(next, cur.time));
            }
            next = cur.pos+1;
            if(next < DIST_MAX && dist[next] > cur.time+1){
                dist[next] = cur.time+1;
                pq.offer(new Node(next, cur.time+1));
            }
            next = cur.pos-1;
            if(next >= 0 && dist[next] > cur.time+1){
                dist[next] = cur.time+1;
                pq.offer(new Node(next, cur.time+1)); 
            }
        }

        System.out.println(result);
    }

    static class Node implements Comparable<Node>{
        int pos;
        int time;

        Node(int pos, int time){
            this.pos = pos;
            this.time = time;
        }

        @Override
        public int compareTo(Node n){
            return this.time-n.time;
        }
    }
}
