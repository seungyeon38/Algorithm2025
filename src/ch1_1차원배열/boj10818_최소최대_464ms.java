package ch1_1차원배열;

import java.util.*;
import java.io.*;

public class boj10818_최소최대_464ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine()); // 정수의 개수 (1~1000000)
        int min = 1000001;
        int max = -1000001;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        System.out.println(min + " " + max);
        // br.close();
    }
}
