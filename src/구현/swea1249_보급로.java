package 구현;

import java.io.*;
import java.util.*;

public class swea1249_보급로 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; // 갈 수 있는 방향

        StringBuilder sb = new StringBuilder();

        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine()); // 지도의 크기 (최대 100)
            int[][] map = new int[N][N];

            for(int i=0; i<N; i++){
                char[] row = br.readLine().toCharArray();
                for(int j=0; j<N; j++){
                    map[i][j] = row[j] - '0';
                }
            }

            boolean[][] visited = new boolean[N][N];
            int[][] time = new int[N][N]; // 해당 지점까지 걸린 시간
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    time[i][j] = Integer.MAX_VALUE;
                }
            }

            // visited[0][0] = true;
            time[0][0] = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, 0));
            
            while(!pq.isEmpty()){
                Node cur = pq.poll();
                visited[cur.r][cur.c] = true;

                if(cur.r == N-1 && cur.c == N-1) {
                    sb.append("#").append(t).append(" ").append(time[N-1][N-1]).append("\n");
                    break;
                }

                for(int d=0; d<4; d++){
                    int nr = cur.r + dir[d][0];
                    int nc = cur.c + dir[d][1];

                    if(!isValid(nr, nc, N) || visited[nr][nc]) continue;

                    if(time[nr][nc] > cur.time+map[nr][nc]){
                        time[nr][nc] = cur.time+map[nr][nc];
                        pq.offer(new Node(nr, nc, time[nr][nc]));
                    }
                }
            }
        }

        System.out.println(sb.toString());
    }   

    static boolean isValid(int r, int c, int N){
        if(r<0 || c<0 || r>=N || c>=N) return false;

        return true;
    } 

    static class Node implements Comparable<Node>{
        int r;
        int c;
        int time;

        Node(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }

        @Override
        public int compareTo(Node n){
            return this.time - n.time;
        }
    }

}
