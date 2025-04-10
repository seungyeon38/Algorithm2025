package ch1_1차원배열;

import java.util.*;
import java.io.*;

public class boj10811_바구니뒤집기_104ms{
    public static void main(String[] args) throws Exception{
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 바구니 수 1~100
        int M = Integer.parseInt(st.nextToken()); // 횟수 1~100

        int[] basket_arr = new int[N+1]; // 바구니 번호
        for(int i=1; i<=N; i++){ // 숫자 채우기 
            basket_arr[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for(int cnt=0; cnt<M; cnt++){
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            basket_arr = calc(i, j, basket_arr);
        }

        for(int i=1; i<=N; i++){
            sb.append(basket_arr[i]).append(" ");
        }

        System.out.println(sb.toString());
        // br.close();
    }

    // 뒤집기
    public static int[] calc(int from, int to, int[] arr){
        int cnt = (to-from+1)/2;

        for(int i=0; i<cnt; i++){
            int temp = arr[to-i]; 
            arr[to-i] = arr[from+i];
            arr[from+i] = temp;
        }

        return arr;
    }
}