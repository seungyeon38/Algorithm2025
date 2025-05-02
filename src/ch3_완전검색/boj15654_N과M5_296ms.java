package ch3_완전검색;

import java.util.*;
import java.io.*;

public class boj15654_N과M5_296ms {
    static int N, M;
    static int[] numbers;
    static boolean[] is_selected;
    static int[] selected_arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        numbers = new int[N];
        is_selected = new boolean[N];
        selected_arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

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

        for(int i=0; i<N; i++){
            if(is_selected[i]) continue;

            selected_arr[cnt] = numbers[i];
            is_selected[i] = true;
            calc(cnt+1);
            is_selected[i] = false;
        }
    }
}
