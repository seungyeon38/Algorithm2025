package ch2_2차원배열;

import java.io.*;
import java.util.*;

public class boj1018_체스판다시칠하기 {
    public static void main(String[] args) throws Exception{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 세로 (8~50)
        int N = Integer.parseInt(st.nextToken()); // 가로 (8~50)

        char[][] board = new char[M][N];

        for(int i=0; i<M; i++){
            board[i] = br.readLine().toCharArray();
        }

        int repaint_cnt1 = 0; 
        int repaint_cnt2 = 0; 
        char[] paint_kind = {'B', 'W'};
        
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                char cur = paint_kind[(i+j)%2];

                if(board[i][j] != cur) repaint_cnt1++;
            }
        }

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                char cur = paint_kind[(i+j+1)%2];

                if(board[i][j] != cur) repaint_cnt2++;
            }
        }
        
        System.out.println(Math.min(repaint_cnt1, repaint_cnt2));
        br.close();
    }
}
