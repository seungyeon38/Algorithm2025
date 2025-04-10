package ch1_1차원배열;

import java.io.*;
import java.util.*;

public class boj11659_구간합구하기4_544ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수의 개수 (1~100000)
        int M = Integer.parseInt(st.nextToken()); // 합을 구하는 횟수 (1~100000)

        int[] sum_arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        sum_arr[1] = Integer.parseInt(st.nextToken()); // 1~1000 자연수

        for(int i=2; i<=N; i++){
            sum_arr[i] = sum_arr[i-1] + Integer.parseInt(st.nextToken()); // 구간합 구하기
        }
        
        StringBuilder sb = new StringBuilder();
        for(int tc=0; tc<M; tc++){
            st = new StringTokenizer(br.readLine());
            int sp = Integer.parseInt(st.nextToken());
            int ep = Integer.parseInt(st.nextToken());

            sb.append(sum_arr[ep]-sum_arr[sp-1]).append("\n");
        }

        System.out.println(sb.toString());
        // br.close();
    }
}
