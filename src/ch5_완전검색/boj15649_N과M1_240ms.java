package ch5_완전검색;

import java.util.*;
import java.io.*;

public class boj15649_N과M1_240ms {
    static int N, M;
    static boolean[] is_selected;
    static int[] selected_arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 1~8 자연수
        M = Integer.parseInt(st.nextToken()); // 고르는 수의 개수

        // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 (사전순 정렬)
        is_selected = new boolean[N+1];
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
            if(is_selected[i]) continue;

            is_selected[i] = true;
            selected_arr[cnt] = i;
            calc(cnt+1);
            is_selected[i] = false;
        }
    }
}