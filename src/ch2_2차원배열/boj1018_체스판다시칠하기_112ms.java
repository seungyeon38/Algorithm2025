package ch2_2차원배열;

import java.io.*;
import java.util.*;

public class boj1018_체스판다시칠하기_112ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 가로 (8~50)
        int N = Integer.parseInt(st.nextToken()); // 세로 (8~50)

        char[][] board = new char[M][N];

        for(int i=0; i<M; i++){
            board[i] = br.readLine().toCharArray();
        }

        int min = 33;

        for(int i=0, r=M-7; i<r; i++){
            for (int j=0, c=N-7; j<c; j++){
                min = Math.min(min, calc(i, j, board));
            }
        }

        System.out.println(min);        
        // br.close();
    }

    public static int calc(int r, int c, char[][] grid) {
        int cnt1 = 0;
        int cnt2 = 0;

        char[] char_list = {'B', 'W'};

        for(int i=r, max_r=r+8; i<max_r; i++){
            for(int j=c, max_c=c+8; j<max_c; j++){
                char color = char_list[(i+j)%2];
                if(color != grid[i][j]) cnt1++;
            }
        }

        for(int i=r, max_r=r+8; i<max_r; i++){
            for(int j=c, max_c=c+8; j<max_c; j++){
                char color = char_list[(i+j+1)%2];
                if(color != grid[i][j]) cnt2++;
            }
        }

        return Math.min(cnt1, cnt2);
    }
}
