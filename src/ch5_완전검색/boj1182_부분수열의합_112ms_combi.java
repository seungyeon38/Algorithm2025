package ch5_완전검색;

import java.util.*;
import java.io.*;

public class boj1182_부분수열의합_112ms_combi {
  static int N, S;
  static int cnt;
  static int[] arr;

  public static void main(String[] args) throws Exception{
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    StringTokenizer st = new StringTokenizer(br.readLine()); 

    N = Integer.parseInt(st.nextToken()); // 정수 개수 (1~20)
    S = Integer.parseInt(st.nextToken()); // 합 (-1,000,000~1,000,000)
    arr = new int[N];

    // N개의 정수로 이루어진 수열
    // 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수 구하기
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 조합
    combi(0, 0);
    if(S == 0) cnt--;
    System.out.println(cnt);

    br.close();
  } 

  public static void combi(int idx, int sum) {
    if(sum == S) cnt++;
    if(idx == N) return;

    for(int i=idx; i<N; i++){
      combi(i+1, sum+arr[i]);
    }
  }
}