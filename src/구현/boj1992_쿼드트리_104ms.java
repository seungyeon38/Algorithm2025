package 구현;

import java.io.*;

public class boj1992_쿼드트리_104ms {
  static char[][] grid;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

    int N = Integer.parseInt(br.readLine()); // 영상의 크기. 2의 제곱수 (1~64)
    grid = new char[N][N];

    for(int i=0; i<N; i++){
      grid[i] = br.readLine().toCharArray();
    }

    recur(0, 0, N);

    System.out.println(sb.toString());
  }

  public static void recur(int sr, int sc, int n){
    boolean is_all_same = isAllSame(sr, sc, n);

    if(is_all_same){
      sb.append(grid[sr][sc]);
    } else {
      sb.append('(');
      int next_n = n/2;
      for(int i=0; i<2; i++){
        for(int j=0; j<2; j++){
          recur(sr+next_n*i, sc+next_n*j, next_n);
        }
      }
      sb.append(')');
    }
  }

  public static boolean isAllSame(int r, int c, int n){
    boolean is_all_same = true;
    char sc = grid[r][c];

    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        if(grid[r+i][c+j] != sc) {
          is_all_same = false; 
          break;
        }
      }
    }

    return is_all_same;
  }
}
