package ch5_완전검색;

import java.util.*;
import java.io.*;

public class boj15650_N과M2_104ms {
    static int N, M;
    static int[] selected_arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 1~8 자연수
        M = Integer.parseInt(st.nextToken()); // 고르는 수의 개수

        selected_arr = new int[M];

        calc(0, 1);

        System.out.println(sb.toString());
        // br.close();
    }

    public static void calc(int cnt, int sp) {
        if(cnt == M){
            for(int i=0; i<M; i++){
                sb.append(selected_arr[i]).append(" ");
            }
            sb.append("\n");

            return; 
        }

        for(int i=sp; i<=N; i++){
            selected_arr[cnt] = i;
            calc(cnt+1, i+1);
        }
    }
}
