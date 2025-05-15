package ch3_2차원배열;

import java.util.*;
import java.io.*;

public class boj2563_색종이_100ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine()); // 색종이 수 (<=100)
        boolean[][] grid = new boolean[100][100];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sp_x = Integer.parseInt(st.nextToken());
            int sp_y = Integer.parseInt(st.nextToken())+9;

            for(int x=sp_x, ep_x=sp_x+10; x<ep_x; x++){
                for(int y=sp_y, ep_y=sp_y-10; y>ep_y; y--){
                    grid[x][y] = true;
                }
            }
        }

        int result = 0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(grid[i][j]) result++;
            }
        }

        System.out.println(result);
    }
}
