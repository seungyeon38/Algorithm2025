package ch11_분할정복이분탐색;

import java.io.*;
import java.util.*;

public class boj1654_랜선자르기 {
    static int K, N;
    static int[] length_list;
    static int result = 0;
    public static void main(String[] args) throws Exception{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수 1~10,000
        N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수 1~1,000,000

        int max_length = 0;
        length_list = new int[K];
        for(int k=0; k<K; k++){
            length_list[k] = Integer.parseInt(br.readLine());
            max_length = Math.max(length_list[k], max_length);
        }

        calc(1, max_length);

        br.close();
        System.out.println(result);
    }    

    public static void calc(long left, long right){
        if(left > right) return;

        int mid = (int)((left+right)/2);

        // if(mid <= 0) return;
        
        int cnt = 0;
        for(int k=0; k<K; k++){
            cnt += length_list[k]/mid;
        }

        if(cnt < N){
            calc(left, mid-1);
        } else {
            result = mid;
            calc(mid+1, right);
        }
    }
}
