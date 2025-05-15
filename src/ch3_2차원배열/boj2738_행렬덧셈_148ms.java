package ch3_2차원배열;

import java.util.*;
import java.io.*;

public class boj2738_행렬덧셈_148ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 행렬의 크키 (<100)
        int M = Integer.parseInt(st.nextToken());
         
        int[][] arr1 = new int[N][M];
        int[][] arr2 = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(arr1[i][j]+arr2[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
        // br.close();
    }
}
