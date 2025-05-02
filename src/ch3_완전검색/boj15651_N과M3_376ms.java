package ch3_완전검색;

import java.util.*;
import java.io.*;

public class boj15651_N과M3_376ms {
    static int N, M;
    static int[] selected_arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 1~7 자연수
        M = Integer.parseInt(st.nextToken()); // 뽑는 수의 개수

        selected_arr = new int[M];

        calc(0);
        System.out.println(sb.toString());

        // br.close();
    }

    public static void calc(int cnt){
        if(cnt == M){
            for(int i=0; i<M; i++){
                sb.append(selected_arr[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i=1; i<=N; i++){
            selected_arr[cnt] = i;
            calc(cnt+1);
        }
    }
}
