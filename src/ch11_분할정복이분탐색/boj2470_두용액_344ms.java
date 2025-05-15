package ch11_분할정복이분탐색;

import java.io.*;
import java.util.*;

public class boj2470_두용액_344ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine()); // 전체 용액의 수 2~100,000
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] liquid = new int[N]; // 용액 특성값 -1,000,000,000~1,000,000,000
        int max = -1000000001;
        int min = 1000000001;
        
        for(int n=0; n<N; n++){
            liquid[n] = Integer.parseInt(st.nextToken());

            max = Math.max(max, liquid[n]);
            min = Math.min(min, liquid[n]);
        }

        Arrays.sort(liquid);

        int left = 0;
        int right = N-1;
        int result1 = -1;
        int result2 = -1;
        int result_min = Integer.MAX_VALUE;
        while(left < right){
            int sum = liquid[left] + liquid[right];
            
            if(Math.abs(sum) < Math.abs(result_min)) {
                result_min = sum;
                result1 = left;
                result2 = right;
            }

            if(sum < 0) left++;
            else right--;
        }

        // br.close();
        System.out.println(liquid[result1] + " " + liquid[result2]);
    }   
}
