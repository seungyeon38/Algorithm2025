package 구현;

import java.io.*;
import java.util.*;

public class swea1247_최적경로_dfs {
    static int N;
    static int[] company_pos;
    static int[] home_pos;
    static int[][] customer_pos;
    static int min_distance;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine()); // 고객의 수 (2~10)

            StringTokenizer st = new StringTokenizer(br.readLine());
            company_pos = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; // 회사 좌표
            home_pos = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; // 집의 좌표
            customer_pos = new int[N][2]; // 손님들의 좌표
            for(int i=0; i<N; i++){
                customer_pos[i][0] = Integer.parseInt(st.nextToken());
                customer_pos[i][1] = Integer.parseInt(st.nextToken());
            }

            min_distance = Integer.MAX_VALUE;
            visited = new boolean[N];

            dfs(company_pos[0], company_pos[1], 0, 0);

            sb.append("#").append(t).append(" ").append(min_distance).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void dfs(int cur_x, int cur_y, int cnt, int distance){
        if(distance >= min_distance) return;

        if(cnt == N){
            distance += getDistance(cur_x, cur_y, home_pos[0], home_pos[1]);
            min_distance = Math.min(min_distance, distance);
            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(customer_pos[i][0], customer_pos[i][1], cnt+1, distance+getDistance(cur_x, cur_y, customer_pos[i][0], customer_pos[i][1]));
            visited[i] = false;
        }
    }

    public static int getDistance(int pos1_x, int pos1_y, int pos2_x, int pos2_y){
        return Math.abs(pos1_x-pos2_x) + Math.abs(pos1_y-pos2_y);
    }
}
