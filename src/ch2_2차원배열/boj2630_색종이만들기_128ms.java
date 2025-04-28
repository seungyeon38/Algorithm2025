package ch2_2차원배열;

import java.util.*;
import java.io.*;

public class boj2630_색종이만들기_128ms {
    static int white_cnt = 0;
    static int blue_cnt = 0;
    static char[][] paper;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine()); // 전체 종이의 한 변의 길이 (2,4,8,16,32,64,128)
        paper = new char[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                paper[i][j] = st.nextToken().charAt(0);
            }
        }

        calc(0, 0, N);
        System.out.println(white_cnt);
        System.out.println(blue_cnt);

        // br.close();
    }

    public static void calc(int sp_r, int sp_c, int length) {
        if(length < 1) return;
        
        boolean is_same_color = true;
        char cur_color = paper[sp_r][sp_c];
        
        for(int r=sp_r; r<sp_r+length; r++){
            for(int c=sp_c; c<sp_c+length; c++){
                if(paper[r][c] != cur_color) {
                    is_same_color = false;
                    break;
                }
            }

            if(!is_same_color) break;
        }

        if(is_same_color) {
            if(cur_color == '1') blue_cnt++;
            else white_cnt++;
        } else {
            int next_length = length/2;

            calc(sp_r, sp_c, next_length);
            calc(sp_r+next_length, sp_c, next_length);
            calc(sp_r, sp_c+next_length, next_length);
            calc(sp_r+next_length, sp_c+next_length, next_length);
        }
    }
}
