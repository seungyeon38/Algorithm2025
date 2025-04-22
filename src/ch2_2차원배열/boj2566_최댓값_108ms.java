package ch2_2차원배열;

import java.io.*;
import java.util.*;

public class boj2566_최댓값_108ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int max = -1;
        int r = -1;
        int c = -1;

        for(int i=1; i<=9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
    
            for(int j=1; j<=9; j++){
                int n = Integer.parseInt(st.nextToken());

                if(max < n){
                    max = n;
                    r = i;
                    c = j;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(r).append(" ").append(c);

        System.out.println(sb.toString());
        // br.close();
    }
}