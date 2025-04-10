package ch1_1차원배열;

import java.io.*;
import java.util.*;

public class boj10986_나머지합_452ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수의 개수 1~1,000,000
        int M = Integer.parseInt(st.nextToken()); // 2 ~ 1000

        int[] sum_arr = new int[N+1]; // 구간합 배열
        int[] cnt = new int[M]; // 나머지 카운트 배열
        st = new StringTokenizer(br.readLine()); // 수의 값 0~1,000,000,000
        for(int i=1; i<=N; i++){
            sum_arr[i] = (sum_arr[i-1]+Integer.parseInt(st.nextToken()))%M; // 구간합 구해서 M으로 나눈 나머지
            cnt[sum_arr[i]]++; // 나머지 카운트
        }

        // System.out.println(Arrays.toString(sum_arr));
        // System.out.println(Arrays.toString(cnt));

        long result = cnt[0]; // 나머지가 0인 경우 (1~N까지의 수가 M으로 나누어 떨어지는 경우)
        
        for(int i=0; i<M; i++){ // 나머지가 같을 경우
            result += (long)cnt[i]*(cnt[i]-1)/2;
        }
        
        System.out.println(result);
        // br.close();
    }
}
