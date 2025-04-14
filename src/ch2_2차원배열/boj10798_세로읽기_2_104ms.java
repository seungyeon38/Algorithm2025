package ch2_2차원배열;

import java.io.*;

public class boj10798_세로읽기_2_104ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        String[] word_list = new String[5];

        for(int i=0; i<5; i++){
            String word = br.readLine();
            word_list[i] = word;
        }

        StringBuilder sb = new StringBuilder();
        
        for(int j=0; j<15; j++){
            for(int i=0; i<5; i++){
                if(word_list[i].length() > j) sb.append(word_list[i].charAt(j));
            }
        }
        
        System.out.println(sb.toString());
        // br.close();
    }
}
