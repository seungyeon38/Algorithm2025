package 구현;

import java.io.*;
import java.util.*;

public class boj1074_Z_136ms {
  static int N, r, c;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 1~15
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    recur(0, (int)Math.pow(2, N), 0, 0);
  }

  public static void recur(int num, int cur_n, int cur_r, int cur_c){
    if(cur_r==r && cur_c==c){
      System.out.println(num);
      System.exit(0);
    }

    int next_n = cur_n/2;
    int next_cnt = next_n*next_n;

    if(r < cur_r+next_n){
      if(c < cur_c+next_n) recur(num, next_n, cur_r, cur_c);
      else recur(num+next_cnt, next_n, cur_r, cur_c+next_n);
    } else {
      if(c < cur_c+next_n) recur(num+next_cnt*2, next_n, cur_r+next_n, cur_c);
      else recur(num+next_cnt*3, next_n, cur_r+next_n, cur_c+next_n);
    }
  }
}
