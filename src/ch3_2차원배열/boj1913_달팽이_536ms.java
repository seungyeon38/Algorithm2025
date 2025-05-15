package ch3_2차원배열;

import java.io.*;

public class boj1913_달팽이_536ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine()); // 3~999 사이의 홀수
        int target_n = Integer.parseInt(br.readLine()); // 좌표 찾는 자연수
        int target_r = -1;
        int target_c = -1;
        int[][] grid = new int[N][N];

        int sp = N/2;
        int cur_n = 1;
        int cur_r = sp;
        int cur_c = sp;

        if(cur_n == target_n){
            target_r = cur_r;
            target_c = cur_c;
        }

        grid[cur_r][cur_c] = cur_n++;
        for(int i=1; i<=sp; i++){
            int length = i*2;

            cur_r--;
            for(int l=0; l<length; l++){
                if(cur_n == target_n) {
                    target_r = cur_r;
                    target_c = cur_c;
                }
                grid[cur_r][cur_c++] = cur_n++;
            }
            cur_c--;
            for(int l=0; l<length; l++){
                if(cur_n == target_n) {
                    target_r = cur_r+1;
                    target_c = cur_c;
                }
                grid[++cur_r][cur_c] = cur_n++; 
            }
            for(int l=0; l<length; l++){
                if(cur_n == target_n) {
                    target_r = cur_r;
                    target_c = cur_c-1;
                }
                grid[cur_r][--cur_c] = cur_n++;
            }
            for(int l=0; l<length; l++){
                if(cur_n == target_n) {
                    target_r = cur_r-1;
                    target_c = cur_c;
                }
                grid[--cur_r][cur_c] = cur_n++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }

        sb.append(target_r+1).append(" ").append(target_c+1);
        System.out.println(sb.toString());
        // br.close();
    }
}
