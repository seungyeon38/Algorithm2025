package ch1_1차원배열;

import java.util.*;
import java.io.*;

public class boj10951_ApBm4_104ms {
    public static void main(String[] args) throws Exception{
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();

        while((line = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(line);
            int A = Integer.parseInt(st.nextToken()); // 0 < A,B < 10
            int B = Integer.parseInt(st.nextToken());

            sb.append(A+B).append("\n");
        }

        System.out.println(sb.toString());
        // br.close();
    }
}