package ch13_그래프;

import java.io.*;
import java.util.*;

public class boj2617_구슬찾기_172ms {
    static boolean[][] adj_matrix;
    static boolean[][] reverse_adj_matrix;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 구슬의 개수 1~99
        int M = Integer.parseInt(st.nextToken()); // 저울에 올려 본 쌍의 개수 1~N(N-1)/2

        adj_matrix = new boolean[N+1][N+1]; // 가벼운거 -> 무거운거
        reverse_adj_matrix = new boolean[N+1][N+1]; // 무거운거 -> 가벼운거

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int sp = Integer.parseInt(st.nextToken());
            int ep = Integer.parseInt(st.nextToken());
            adj_matrix[sp][ep] = true;
            reverse_adj_matrix[ep][sp] = true;
        }

        int result = 0; // 무게가 중간이 될 수 없는 구슬의 수 
        int mid = (N+1)/2;

        // 구슬별로 하나씩 깊이 계산
        for(int i=1; i<=N; i++){ // 출발 구슬 번호
            int count = dfs(i, N, adj_matrix);
            int reverse_count = dfs(i, N, reverse_adj_matrix);
            if(count>=mid || reverse_count>=mid) result++;
        }

        // br.close();
        System.out.println(result);
    }

    public static int dfs(int sp, int N, boolean[][] matrix){
        boolean[] visited = new boolean[N+1];
        Stack<Integer> stack = new Stack<>(); // index 0: 구슬 번호, 1: 깊이
        stack.push(sp);
        visited[sp] = true;
        int count = 0;

        while(!stack.isEmpty()){
            int cur = stack.pop();

            for(int j=1; j<=N; j++){
                if(matrix[cur][j] && !visited[j]){
                    visited[j] = true;
                    stack.push(j);
                    count++;
                }
            }
        }

        return count;
    }
}
