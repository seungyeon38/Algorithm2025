package ch13_그래프;

import java.io.*;
import java.util.*;

public class boj11403_경로찾기 {
    static int N;
    static int[][] adj_matrix;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        N = Integer.parseInt(br.readLine()); // 정점의 개수 1~100
        adj_matrix = new int [N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                adj_matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            visited = new boolean[N];
            dfs(i, i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(adj_matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }

        br.close();
        System.out.println(sb.toString());
    }

    public static void dfs(int cur, int fp){
        for(int i=0; i<N; i++){
            if(adj_matrix[cur][i] == 1 && !visited[i]){
                visited[i] = true;
                adj_matrix[cur][i] = 1;
                dfs(i, fp);
            }
        }
    }
}