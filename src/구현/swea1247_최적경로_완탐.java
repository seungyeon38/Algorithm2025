package 구현;

import java.io.*;
import java.util.*;

public class swea1247_최적경로_완탐 {
    static int N;
    static int[] company_pos;
    static int[] home_pos;
    static int[][] customer_pos;
    static boolean[] visited;
    static int[] result;
    static int min_distance;

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

            // 1~9 
            visited = new boolean[N];
            result = new int[N];
            min_distance = Integer.MAX_VALUE;

            calc(0);

            sb.append("#").append(t).append(" ").append(min_distance).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void calc(int cnt){
        if(cnt == N){
            int temp = 0;

            temp += getDistance(company_pos, customer_pos[result[0]]);
            for(int i=1; i<N; i++){
                temp += getDistance(customer_pos[result[i]], customer_pos[result[i-1]]);
            }
            temp += getDistance(customer_pos[result[N-1]], home_pos);

            if(min_distance > temp) min_distance = temp;

            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            result[cnt] = i;
            calc(cnt+1);
            visited[i] = false; 
        }
    }

    public static int getDistance(int[] pos1, int[] pos2){
        return Math.abs(pos1[0]-pos2[0]) + Math.abs(pos1[1]-pos2[1]);
    }
}
