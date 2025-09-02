package 구현;

import java.io.*;

public class boj2447_별찍기10_304ms {
  static boolean[][] grid;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine()); // 3의 거듭제곱

    grid = new boolean[N][N];
    recur(0, 0, N);

    StringBuilder sb = new StringBuilder();
    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        sb.append(grid[i][j] ? '*' : ' ');
      }
      sb.append("\n");
    }

    System.out.println(sb.toString());
  }

  public static void recur(int sr, int sc, int n){
    if(n == 3){
      for(int i=0; i<3; i++){
        grid[sr][sc+i] = true;
        grid[sr+2][sc+i] = true;
      }
      grid[sr+1][sc] = true;
      grid[sr+1][sc+2] = true;

      return;
    }

    int next_n = n/3;
    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        if(i==1 && j==1) continue;
        recur(sr+next_n*i, sc+next_n*j, next_n);
      }
    }
  }
}
