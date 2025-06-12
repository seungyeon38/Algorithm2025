package 구현;

import java.io.*;
import java.util.*;

public class swea2001_파리퇴치{
    public static void main(String[] args) throws Exception{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        StringBuilder sb = new StringBuilder();

        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 5~15
            int M = Integer.parseInt(st.nextToken()); // 2~N

            int[][] grid = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine()); // ~30
                for(int j=0; j<N; j++){
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#").append(t).append(" ").append(calc(grid, N, M)).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int calc(int[][] grid, int N, int M){
        int ep = N-M+1;
        int max = 0;

        for(int i=0; i<ep; i++){
            for(int j=0; j<ep; j++){
                int result = 0;

                for(int r=i; r<i+M; r++){
                    for(int c=j; c<j+M; c++){
                        result += grid[r][c];
                    }
                }

                if(max < result) max = result;
            }
        }

        return max;
    }
}