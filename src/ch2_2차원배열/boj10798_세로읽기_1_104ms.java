package ch2_2차원배열;

import java.io.*;

public class boj10798_세로읽기_1_104ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        char[][] word_list = new char[5][15];
        int[] word_length = new int[5];

        for(int i=0; i<5; i++){
            String word = br.readLine();
            word_list[i] = word.toCharArray();
            word_length[i] = word.length();
        }

        StringBuilder sb = new StringBuilder();
        
        for(int j=0; j<15; j++){
            for(int i=0; i<5; i++){
                if(word_length[i] > j) sb.append(word_list[i][j]);
            }
        }
        
        System.out.println(sb.toString());
        // br.close();
    }
}
