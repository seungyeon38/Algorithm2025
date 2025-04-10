package ch1_1차원배열;

import java.io.*;
import java.util.*;

public class boj1806_부분합_260ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수열 길이 10~100000
        int S = Integer.parseInt(st.nextToken()); // 합 S 이상

        int[] sum_arr = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++){
            sum_arr[i] = sum_arr[i-1] + Integer.parseInt(st.nextToken());
        }

        int min_length = 100001;
        
        int idx1 = 0;
        int idx2 = 1;
        
        while(idx2 <= N){
            int val = sum_arr[idx2]-sum_arr[idx1];

            if(val > S){
                min_length = Math.min(min_length, idx2-idx1);
                idx1++;
            } else if(val == S){
                min_length = Math.min(min_length, idx2-idx1);
                idx1++; 
                idx2++;
            } else idx2++;
        }

        System.out.println(min_length==100001 ? 0 : min_length); // 합이 S 이상이 될 수 없으면 0 출력
        // br.close();
    }
}
