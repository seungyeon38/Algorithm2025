package ch16_서로소집합;

import java.io.*;
import java.util.*;

public class boj1976_여행가자_156ms{
    static int[] parents;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine()); // 도시의 수 <= 200
        int M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시들의 수 <= 1000

        parents = new int[N+1];

        for(int i=1; i<=N; i++){
            parents[i] = i;
        }

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                if(st.nextToken().equals("1")){
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean result = true;
        int cur_p = findSet(Integer.parseInt(st.nextToken()));
        for(int i=1; i<M; i++){
            if(cur_p != findSet(Integer.parseInt(st.nextToken()))) {
                result = false;
                break;
            }
        }

        // br.close();
        System.out.println(result ? "YES" : "NO");
    }

    public static int findSet(int n){
        if(parents[n] == n) return n;

        return parents[n] = findSet(parents[n]);
    }

    public static void union(int n1, int n2){
        int p_n1 = findSet(n1);
        int p_n2 = findSet(n2);

        if(p_n1 != p_n2) parents[p_n1] = p_n2;
    }
}