package 구현;

import java.io.*;
import java.util.*;

public class boj10971_외판원순회2_136ms {
  static int N;
  static int[][] W;
  static boolean[] visited;
  static int result = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

    N = Integer.parseInt(br.readLine()); // 도시의 수 2~10

    // 가장 적은 비용으로 N개의 도시를 모두 거쳐 다시 원래의 도시로 돌아오는 순회 여행 경로 구하기.
    // 한 번 갔던 도시로는 갈 수 없음
    W = new int[N][N];
    for(int i=0; i<N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++){
        W[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    visited = new boolean[N];

    visited[0] = true; // 시작 도시: 0
    calc(0, 0, 1);

    System.out.println(result);
  }

  public static void calc(int cur, int cost, int count){
    if(count == N && W[cur][0] != 0){
      result = Math.min(result, cost+W[cur][0]);
      return;
    }

    for(int i=0; i<N; i++){
      if(W[cur][i] == 0 || visited[i]) continue; // 갈 수 없거나 이미 방문을 했을 경우에는 X

      visited[i] = true;
      calc(i, cost+W[cur][i], count+1);
      visited[i] = false;
    }
  }
}
