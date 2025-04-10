package ch1_1차원배열;

import java.io.*;

public class boj2562_최댓값_124ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int idx = -1;
        int max = 0;

        for(int i=1; i<=9; i++){
            int n = Integer.parseInt(br.readLine()); // 100보다 작은 자연수 
            if(max < n) {
                max = n;
                idx = i;
            }
        }

        System.out.println(max + "\n" + idx);
        // br.close();
    }   
}
