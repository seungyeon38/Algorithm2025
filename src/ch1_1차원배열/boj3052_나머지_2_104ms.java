package ch1_1차원배열;

import java.io.*;
import java.util.*;

public class boj3052_나머지_2_104ms { 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        Set<Integer> remainder = new HashSet<>();
        for(int i=0; i<10; i++){
            remainder.add(Integer.parseInt(br.readLine())%42);
        }

        System.out.println(remainder.size());
        // br.close();
    }
}
